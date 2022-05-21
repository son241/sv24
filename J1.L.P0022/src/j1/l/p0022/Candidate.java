/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Candidate {

    private String id;
    private String name;
    private Date birthDay;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    public Candidate() {
    }

    public Candidate(String id, String name, Date birthDay, String address, String phone, String email, int candidateType) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return id + " | " + name + " | " + f.format(birthDay) + " | " + address + " | " + phone + " | " + email + " | " + candidateType;
    }

    public Candidate update(Candidate C1) throws ParseException {
        Candidate C = C1;
        while (true) {
            System.out.println("Update information of: ");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("3. Birthday");
            System.out.println("4. Address");
            System.out.println("5. Phone number");
            System.out.println("6. Email");
            System.out.println("7. Exit");
            int op = Common.inputInteger("Enter option: ", 1, 7);
            if (op == 7) {
                return C;
            }
            switch (op) {
                case 1:
                    String id;
                    Manager manager = new Manager();
                    while (true) {
                        id = Common.inputString("Enter candidate id: ", ".+");
                        if (!manager.isExisted(id)) {
                            C.setId(id);
                            break;
                        } else {
                            System.out.println(id + " has already exisited, try again!");
                        }
                    }
                    break;
                case 2:
                    C.setName(Common.inputName("Enter candidate name: "));
                    break;
                case 3:
                    Date birdDate;
                    while (true) {
                        birdDate = Common.inputDate("Enter birth date: ", "dd/MM/yyyy");
                        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                        if (birdDate.after(f.parse("1/1/1900")) && birdDate.before(new Date())) {
                            C.setBirthDay(birdDate);
                            break;
                        } else {
                            System.out.println("Invalid date, try again!");
                        }
                    }
                    break;
                case 4:
                    C.setAddress(Common.inputString("Enter candidate's address: ", ".+"));
                    break;
                case 5:
                    String phone;
                    while (true) {
                        phone = Common.inputString("Enter candidate's phone number: ", "\\d+");
                        if (phone.length() >= 10) {
                            C.setPhone(phone);
                            break;
                        } else {
                            System.out.println("Invalid phone number, try again!");
                        }
                    }
                    break;
                case 6:
                    C.setEmail(Common.inputString("Enter candidate's email: ", "[a-zA-z][a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+[\\.]*.*"));
                    break;
            }
        }
    }
}
