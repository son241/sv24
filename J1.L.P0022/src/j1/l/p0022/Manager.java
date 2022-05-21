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
public class Manager implements IManager {

    ArrayList<Candidate> list = new ArrayList<Candidate>();

    public Manager(ArrayList<Candidate> list) {
        this.list = list;
    }

    Manager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void input(int option) throws Exception {

        String still_going;
        do {
            String id = idProcess();
            String name = Common.inputName("Enter candidate name: ");
            Date birdDate = birhDateProcess();
            String address = Common.inputString("Enter candidate's address: ", ".+");
            String phone = phoneProcess();
            String email = Common.inputString("Enter candidate's email: ", "[a-zA-z][a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+[\\.]*.*");
            int type;

            switch (option) {
                case 1:
                    int expInYear = Common.inputInteger("Enter year of experience: ", 1, 100);
                    String proSkill = Common.inputString("Enter professional skill: ", ".*");
                    type = 0;
                    Candidate C = new ExperienceCandidate(id, name, birdDate, address, phone, email, type, expInYear, proSkill);
                    list.add(C);
                    break;
                case 2:
                    Date graduationDate = Common.inputDate("Enter graduation date: ", "dd/MM/yyyy");
                    String rankOfGraduation = rankOfGraduationProcess();
                    String education = Common.inputString("Enter education: ", ".+");
                    type = 1;
                    Candidate C1 = new FresherCandidate(graduationDate, rankOfGraduation, education, id, name, birdDate, address, phone, email, type);
                    list.add(C1);
                    break;
                case 3:
                    String major;
                    String semester;
                    String university;
                    type = 2;
                    major = Common.inputString("Enter major: ", ".+");
                    semester = Common.inputString("Enter semester: ", ".+");
                    university = Common.inputString("Enter university: ", ".+");
                    Candidate C2 = new InternCandidate(major, semester, university, id, name, birdDate, address, phone, email, type);
                    list.add(C2);
                    break;
            }
            still_going = Common.inputString("Do you want to continue (Y/N)?", "[yYnN]").toUpperCase();
        } while (still_going.equalsIgnoreCase("Y"));
    }

    @Override
    public void updateById(int option) throws Exception {

        String id;

        switch (option) {
            case 1:
                reportInformation(option);
                id = Common.inputString("Enter id: ", ".*");
                for (Candidate item : list) {
                    if (item instanceof ExperienceCandidate && item.getId().equalsIgnoreCase(id)) {
                        ExperienceCandidate E = new ExperienceCandidate();
                        E = (ExperienceCandidate) newObject(item, option);
                        list.set(list.indexOf(item), E);
                        System.out.println("Successfully updated!");
                        break;
                    }
                }
                break;
            case 2:
                reportInformation(option);
                id = Common.inputString("Enter id: ", ".*");
                for (Candidate item : list) {
                    if (item instanceof FresherCandidate && item.getId().equalsIgnoreCase(id)) {
                        FresherCandidate F = new FresherCandidate();
                        F = (FresherCandidate) newObject(item, option);
                        list.set(list.indexOf(item), F);
                        System.out.println("Successfully updated!");
                        break;
                    }
                }
                break;
            case 3:
                reportInformation(option);
                id = Common.inputString("Enter id: ", ".*");
                for (Candidate item : list) {
                    if (item instanceof InternCandidate && item.getId().equalsIgnoreCase(id)) {
                        InternCandidate I = new InternCandidate();
                        I = (InternCandidate) newObject(item, option);
                        list.set(list.indexOf(item), I);
                        System.out.println("Successfully updated!");
                        break;
                    }
                }
                break;
        }

    }

    @Override
    public void searchByName(int type, String name) {
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println("The candidate found:");
        for (Candidate item : list) {
            if (item.getCandidateType() == type && item.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void deleteById(int option) {
        String id;
        switch (option) {
            case 1:
                reportInformation(option);
                id = Common.inputString("Enter id: ", ".*");
                for (Candidate item : list) {
                    if (item instanceof ExperienceCandidate && item.getId().equalsIgnoreCase(id)) {
                        list.remove(list.indexOf(item));
                        break;
                    }
                }
                break;
            case 2:
                reportInformation(option);
                id = Common.inputString("Enter id: ", ".*");
                for (Candidate item : list) {
                    if (item instanceof FresherCandidate && item.getId().equalsIgnoreCase(id)) {
                        list.remove(list.indexOf(item));
                        break;
                    }
                }
                break;
            case 3:
                reportInformation(option);
                id = Common.inputString("Enter id: ", ".*");
                for (Candidate item : list) {
                    if (item instanceof InternCandidate && item.getId().equalsIgnoreCase(id)) {
                        list.remove(list.indexOf(item));
                        break;
                    }
                }
                break;
        }
    }

    public boolean isExisted(String id) {
        for (Candidate item : list) {
            if (item.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void reportName() {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate item : list) {
            if (item instanceof ExperienceCandidate) {
                System.out.println(item.getName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate item : list) {
            if (item instanceof FresherCandidate) {
                System.out.println(item.getName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate item : list) {
            if (item instanceof InternCandidate) {
                System.out.println(item.getName());
            }
        }
    }

    @Override
    public void reportInformation(int op) {
        switch (op) {
            case 1:
                System.out.println("===========EXPERIENCE CANDIDATE============");
                for (Candidate item : list) {
                    if (item instanceof ExperienceCandidate) {
                        System.out.println(((ExperienceCandidate) item).toString1());
                    }
                }
                break;
            case 2:
                System.out.println("==========FRESHER CANDIDATE==============");
                for (Candidate item : list) {
                    if (item instanceof FresherCandidate) {
                        System.out.println(((FresherCandidate) item).toString1());
                    }
                }
                break;
            case 3:
                System.out.println("===========INTERN CANDIDATE==============");
                for (Candidate item : list) {
                    if (item instanceof InternCandidate) {
                        System.out.println(((InternCandidate) item).toString1());
                    }
                }
                break;
        }
    }

    private Candidate newObject(Candidate item, int option) throws ParseException {
        while (true) {
            Candidate newObj = item;
            updateMenu(option);
            int op;
            if (option == 1) {
                op = Common.inputInteger("Enter option: ", 1, 9);
            } else {
                op = op = Common.inputInteger("Enter option: ", 1, 10);
            }
            switch (op) {
                case 1:
                    newObj.setId(idProcess());
                    break;
                case 2:
                    newObj.setName(Common.inputName("Enter candidate name: "));
                    break;
                case 3:
                    newObj.setBirthDay(birhDateProcess());
                    break;
                case 4:
                    newObj.setAddress(Common.inputString("Enter candidate's address: ", ".+"));
                    break;
                case 5:
                    newObj.setPhone(phoneProcess());
                    break;
                case 6:
                    newObj.setEmail(Common.inputString("Enter candidate's email: ", "[a-zA-z][a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+[\\.]?[a-zA-Z]*"));
                    break;

            }
            if (option == 1) {
                switch (op) {
                    case 7:
                        ((ExperienceCandidate) newObj).setExpInYear(Common.inputInteger("Enter year of experience: ", 1, 100));
                        break;
                    case 8:
                        ((ExperienceCandidate) newObj).setProSkill(Common.inputString("Enter professional skill: ", ".*"));
                        break;
                    case 9:
                        return ((ExperienceCandidate) newObj);
                }
            } else if (option == 2) {
                switch (op) {
                    case 7:
                        ((FresherCandidate) newObj).setGraduationDate(Common.inputDate("Enter graduation date: ", "dd/MM/yyyy"));
                        break;
                    case 8:
                        ((FresherCandidate) newObj).setRankOfGraduation(rankOfGraduationProcess());
                        break;
                    case 9:
                        ((FresherCandidate) newObj).setEducation(Common.inputString("Enter education: ", ".+"));
                        break;
                    case 10:
                        return ((FresherCandidate) newObj);
                }

            } else if (option == 3) {
                switch (op) {
                    case 7:
                        ((InternCandidate) newObj).setMajor(Common.inputString("Enter major: ", ".+"));
                        break;
                    case 8:
                        ((InternCandidate) newObj).setSemester(Common.inputString("Enter semester: ", ".+"));
                        break;
                    case 9:
                        ((InternCandidate) newObj).setUniversity(Common.inputString("Enter university: ", ".+"));
                        break;
                    case 10:
                        return ((InternCandidate) newObj);
                }
            }

        }
    }

    public void updateMenu(int op) {
        switch (op) {
            case 1:
                System.out.println("Update information of: ");
                System.out.println("1. Id");
                System.out.println("2. Name");
                System.out.println("3. Birthday");
                System.out.println("4. Address");
                System.out.println("5. Phone number");
                System.out.println("6. Email");
                System.out.println("7. Year of experience");
                System.out.println("8. Professional skill");
                System.out.println("9. Exit");
                break;
            case 2:
                System.out.println("Update information of: ");
                System.out.println("1. Id");
                System.out.println("2. Name");
                System.out.println("3. Birthday");
                System.out.println("4. Address");
                System.out.println("5. Phone number");
                System.out.println("6. Email");
                System.out.println("7. Graduation date");
                System.out.println("8. Rank of graduation");
                System.out.println("9. Education");
                System.out.println("10. Exit");
                break;
            case 3:
                System.out.println("Update information of: ");
                System.out.println("1. Id");
                System.out.println("2. Name");
                System.out.println("3. Birthday");
                System.out.println("4. Address");
                System.out.println("5. Phone number");
                System.out.println("6. Email");
                System.out.println("7. Major");
                System.out.println("8. Semester");
                System.out.println("9. University");
                System.out.println("10. Exit");
                break;
        }
    }

    private String idProcess() {
        String id;
        while (true) {
            id = Common.inputString("Enter candidate id: ", ".+");
            if (!isExisted(id)) {
                return id;
            } else {
                System.out.println(id + " has already exisited, try again!");
            }
        }
    }

    private Date birhDateProcess() throws ParseException {
        Date birdDate;
        while (true) {
            birdDate = Common.inputDate("Enter birth date: ", "dd/MM/yyyy");
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            if (birdDate.after(f.parse("1/1/1900")) && birdDate.before(new Date())) {
                return birdDate;
            } else {
                System.out.println("Invalid date, try again!");
            }
        }
    }

    private String phoneProcess() {
        String phone;
        while (true) {
            phone = Common.inputString("Enter candidate's phone number: ", "\\d+");
            if (phone.length() >= 10) {
                return phone;
            } else {
                System.out.println("Invalid phone number, try again!");
            }
        }
    }

    private String rankOfGraduationProcess() {
        String rankOfGraduation;
        while (true) {
            rankOfGraduation = Common.inputString("Enter rank of graduation(Excellence, Good, Fair, Poor): ", ".+").toLowerCase().trim();
            rankOfGraduation = rankOfGraduation.substring(0, 1).toUpperCase() + rankOfGraduation.substring(1);
            String[] rank = {
                "Excellence", "Good", "Fair", "Poor"
            };
            for (String item : rank) {
                if (item.equalsIgnoreCase(rankOfGraduation)) {
                    return rankOfGraduation;
                }
            }
            System.out.println("Invalid value, try again!");
        }
    }
}
