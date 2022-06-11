/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Common {

    public static Scanner in = new Scanner(System.in);

    public static int inputInteger(String message, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(message);
                n = Integer.parseInt(in.nextLine());
                if (n >= min && n <= max) {
                    break;
                }
                System.out.println("Out of range, try again!");
            } catch (Exception e) {
                System.out.println("Invalid input, try again!");
            }
        }
        return n;
    }

    public static double inputDouble(String message, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(message);
                n = Double.parseDouble(in.nextLine());
                if (n >= min && n <= max) {
                    break;
                }
                System.out.println("Out of range, try again!");
            } catch (Exception e) {
                System.out.println("Invalid input, try again!");
            }
        }
        return n;
    }

    public static String inputString(String message, String regex, String errorMessage) {
        String S;
        while (true) {
            System.out.print(message);
            S = in.nextLine();
            if (S.matches(regex)) {
                break;
            }
            System.out.println(errorMessage);
        }
        return S;
    }

    public static Date inputDate(String message, String format) {
        Date n;
        SimpleDateFormat f = new SimpleDateFormat(format);
        f.setLenient(false);
        while (true) {
            try {
                System.out.print(message);
                n = f.parse(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input, try again!");
            }
        }
        return n;
    }

    public static String inputName(String message) {
        String name;
        while (true) {
            System.out.print(message);
            name = in.nextLine().toLowerCase().trim();
            if (name.contains(" ")) {
                break;
            } else {
                System.out.println("Invalid name!");
            }
        }
        name = name.replaceAll("\\s+", " ");
        String surname;
        String firstname;
        String lastname;

        //Chuẩn hóa firstname
        firstname = name.substring(name.lastIndexOf(" ") + 1);
        firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1);

        //Chuẩn hóa lastname
        lastname = name.substring(0, name.indexOf(" "));
        lastname = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);

        //Chuânr hóa surname
        surname = "";
        try {
            surname = name.substring(name.indexOf(" ") + 1, name.lastIndexOf(" "));
            String[] S = surname.split(" ");
            surname = "";
            for (String item : S) {
                surname += item.substring(0, 1).toUpperCase() + item.substring(1) + " ";
            }
            surname = surname.trim();
        } catch (Exception e) {
        }
        if (surname.isEmpty()) {
            name = lastname + " " + firstname;
        } else {
            name = lastname + " " + surname + " " + firstname;
        }
        return name;
    }
}
