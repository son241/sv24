/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import com.sun.javafx.css.Combinator;
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

    //hàm này để input thông tin cho các thuộc tính chung
    private Candidate commonInput() throws Exception {
        //xử lý ID (nếu trùng với id có sẵn trong list)
        String id = null;
        while (true) {
            id = Common.inputString("Enter candidate's ID: ", ".+");
            if (getObjectById(id) == null) {
                break;
            }
            System.out.println("\"" + id + "\"" + " has already existed, try again!");
        }
        //Nhập tên candidate
        String name = Common.inputName("Enter candidate name: ");
        //Xử lý ngày sinh phải sau 1/1/1900 và trước thời gian hiện tại
        Date birdDate = birhDateProcess();
        //Nhập thông tin địa chỉ candidate
        String address = Common.inputString("Enter candidate's address: ", ".+");
        //Nhập thông tin số điện thoại của candidate (ít nhất 10 chữ số)
        String phone = Common.inputString("Enter candidate's phone: ", "[0-9]{10,}+");
        //Xử lý định dạng email của candidate
        String email = Common.inputString("Enter candidate's email: ", "[a-zA-z][a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+[\\.]*.*");
        int type;
        //Tạo 1 instance của Candidate để lưu trữ các thông tin chung đã xử lý bên trên
        Candidate C = new Candidate(id, name, birdDate, address, phone, email, 0);
        return C;
    }

    //Input thông tin riêng cho Experienced candidate
    @Override
    public void createExperience() throws Exception {
        String still_going;
        do {
            Candidate C = commonInput();
            //số năm kinh nghiêm trong range (1-100)
            double expInYear = Common.inputDouble("Enter year of experience: ", 1, 100);
            //input thông tin cho professional skill
            String proSkill = Common.inputString("Enter professional skill: ", ".*");
            int type = 0;
            Candidate E = new ExperienceCandidate(C.getId(), C.getName(), C.getBirthDay(), C.getAddress(), C.getPhone(), C.getEmail(), type, expInYear, proSkill);
            list.add(E);
            still_going = Common.inputString("Do you want to continue <Y/N>? ", "[yYnN]");
        } while (still_going.equalsIgnoreCase("Y"));
    }

    //Input thông tin riêng cho Fresher candidate
    @Override
    public void createFresher() throws Exception {
        String still_going;
        do {
            Candidate C = commonInput();
            Date graduationDate = Common.inputDate("Enter graduation date: ", "dd/MM/yyyy");
            String[] rank = {
                "Excellence", "Good", "Fair", "Poor"
            };
            int choice = Common.inputInteger("Rank of graduation(0: Excellent | 1: Good | 2: Fair | 3: Poor):", 0, 3);
            String rankOfGraduation = rank[choice];
            String education = Common.inputString("Enter education: ", ".+");
            int type = 1;
            Candidate F = new FresherCandidate(graduationDate, rankOfGraduation, education, C.getId(), C.getName(), C.getBirthDay(), C.getAddress(), C.getPhone(), C.getEmail(), type);
            list.add(F);
            still_going = Common.inputString("Do you want to continue <Y/N>? ", "[yYnN]");
        } while (still_going.equalsIgnoreCase("Y"));
    }

    //Input thông tin riêng cho Internship candidate
    @Override
    public void createIntern() throws Exception {
        String still_going;
        do {
            Candidate C = commonInput();
            String major = Common.inputString("Enter major: ", ".+");
            String semester = Common.inputString("Enter semester: ", ".+");
            String university = Common.inputString("Enter university: ", ".+");
            int type = 2;
            Candidate I = new InternCandidate(major, semester, university, C.getId(), C.getName(), C.getBirthDay(), C.getAddress(), C.getPhone(), C.getEmail(), type);
            list.add(I);
            still_going = Common.inputString("Do you want to continue <Y/N>? ", "[yYnN]");
        } while (still_going.equalsIgnoreCase("Y"));
    }

    @Override
    public void updateById(int option) throws Exception {

        reportInformation(option - 1);
        String id = Common.inputString("Update by ID: ", ".*");
        Candidate C = getObjectById(id);
        if (C == null) {
            System.out.println("Fail to update!");
            return;
        }

        switch (option) {
            case 1:
                if (C instanceof ExperienceCandidate) {
                    ExperienceCandidate E = (ExperienceCandidate) commonUpdate(C, C.getCandidateType());
                    list.set(list.indexOf(C), E);
                    System.out.println("Successfully updated!");
                } else {
                    System.out.println("Fail to update!");
                }
                break;
            case 2:
                if (C instanceof FresherCandidate) {
                    FresherCandidate F = (FresherCandidate) commonUpdate(C, C.getCandidateType());
                    list.set(list.indexOf(C), F);
                    System.out.println("Successfully updated!");
                } else {
                    System.out.println("Fail to update!");
                }
                break;
            case 3:
                if (C instanceof InternCandidate) {
                    InternCandidate I = (InternCandidate) commonUpdate(C, C.getCandidateType());
                    list.set(list.indexOf(C), I);
                    System.out.println("Successfully updated!");
                } else {
                    System.out.println("Fail to update!");
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
        reportInformation(option);
        String id = Common.inputString("Delete by ID: ", ".*");
        Candidate C = getObjectById(id);
        if (C == null) {
            System.out.println("Fail to delete!");
            return;
        }
        switch (option) {
            case 1:
                if (C instanceof ExperienceCandidate) {
                    list.remove(list.indexOf(C));
                } else {
                    System.out.println("Fail to delete!");
                    return;
                }
                break;
            case 2:
                if (C instanceof FresherCandidate) {
                    list.remove(list.indexOf(C));
                } else {
                    System.out.println("Fail to delete!");
                    return;
                }
                break;
            case 3:
                if (C instanceof InternCandidate) {
                    list.remove(list.indexOf(C));
                } else {
                    System.out.println("Fail to delete!");
                    return;
                }
                break;
        }
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

    private Candidate commonUpdate(Candidate C, int type) throws ParseException {
        while (true) {
            //newObj lưu trữ thông tin có sẵn của đối tượng cần update
            Candidate newObj = C;
            updateMenu(type);
            int optionUpdate;
            if (type == 0) {
                optionUpdate = Common.inputInteger("Enter option: ", 1, 9);
            } else {
                optionUpdate = Common.inputInteger("Enter option: ", 1, 10);
            }

            //Update các thuộc tính chung của 3 loại candidate
            switch (optionUpdate) {
                case 1:
                    String id;
                    while (true) {
                        id = Common.inputString("Enter candidate's ID: ", ".+");
                        if (getObjectById(id) == null) {
                            break;
                        }
                        System.out.println("\"" + id + "\"" + " has already existed, try again!");
                    }
                    newObj.setId(id);
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
                    newObj.setPhone(Common.inputString("Enter candidate's phone: ", "[0-9]{10,}+"));
                    break;
                case 6:
                    newObj.setEmail(Common.inputString("Enter candidate's email: ", "[a-zA-z][a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+[\\.]?[a-zA-Z]*"));
                    break;

            }

            //Update thông tin riêng của Experienced candidate
            if (type == 0) {
                switch (optionUpdate) {
                    case 7:
                        ((ExperienceCandidate) newObj).setExpInYear(Common.inputInteger("Enter year of experience: ", 1, 100));
                        break;
                    case 8:
                        ((ExperienceCandidate) newObj).setProSkill(Common.inputString("Enter professional skill: ", ".*"));
                        break;
                    case 9:
                        return newObj;
                }

                //Update thông tin riêng của Fresher candidate
            } else if (type == 1) {
                switch (optionUpdate) {
                    case 7:
                        ((FresherCandidate) newObj).setGraduationDate(Common.inputDate("Enter graduation date: ", "dd/MM/yyyy"));
                        break;
                    case 8:
                        String[] rank = {
                            "Excellent", "Good", "Fair", "Poor"
                        };
                        int choice = Common.inputInteger("Rank of graduation(0: Excellent | 1: Good | 2: Fair | 3: Poor):", 0, 3);
                        String rankOfGraduation = rank[choice];
                        ((FresherCandidate) newObj).setRankOfGraduation(rankOfGraduation);
                        break;
                    case 9:
                        ((FresherCandidate) newObj).setEducation(Common.inputString("Enter education: ", ".+"));
                        break;
                    case 10:
                        return newObj;
                }
                //Update thông tin riêng của Internship candidate
            } else if (type == 2) {
                switch (optionUpdate) {
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
                        return newObj;
                }
            }
        }
    }

    private Candidate getObjectById(String id) {
        for (Candidate item : list) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
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

    @Override
    public void reportInformation(int type) {
        String[] title = {
            "===========EXPERIENCE CANDIDATE============", "==========FRESHER CANDIDATE==============","===========INTERN CANDIDATE=============="
        };
        System.out.println(title[type]);
        for (Candidate item : list) {
            if (item.getCandidateType() == type) {
                if (item instanceof ExperienceCandidate) {
                    System.out.println(((ExperienceCandidate)item).toString());
                }else if(item instanceof FresherCandidate){
                    System.out.println(((FresherCandidate)item).toString());
                }else
                    System.out.println(((InternCandidate)item).toString());
            }
        }
    }

    private void updateMenu(int type) {
        System.out.println("Update information of: ");
        System.out.println("1. Id");
        System.out.println("2. Name");
        System.out.println("3. Birthday");
        System.out.println("4. Address");
        System.out.println("5. Phone number");
        System.out.println("6. Email");
        switch (type) {
            case 0:
                System.out.println("7. Year of experience");
                System.out.println("8. Professional skill");
                System.out.println("9. Exit");
                break;
            case 1:
                System.out.println("7. Graduation date");
                System.out.println("8. Rank of graduation");
                System.out.println("9. Education");
                System.out.println("10. Exit");
                break;
            case 2:
                System.out.println("7. Major");
                System.out.println("8. Semester");
                System.out.println("9. University");
                System.out.println("10. Exit");
                break;
        }
    }
}
