/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0022;

import java.util.ArrayList;
import java.util.Date;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //String n = Common.inputString("Enter candidate's email: ", "[a-zA-z][a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+[\\.]?[a-zA-Z]*");
        ArrayList<Candidate> list = new ArrayList<Candidate>();
        String phone = Common.inputString("Enter candidate's phone: ", "[0-9]{10,12}");
        IManager manager = new Manager(list);
        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM\n"
                    + "1. Experience\n"
                    + "2. Fresher\n"
                    + "3. Internship\n"
                    + "4. Searching\n"
                    + "5. Exit");
            int option = Common.inputInteger("Enter option: ", 1, 5);
            switch (option) {
                case 1:
                    while (true) {
                        menu();
                        int option1 = Common.inputInteger("Enter option: ", 1, 5);
                        if (option1 == 5) {
                            break;
                        }
                        switch (option1) {
                            case 1:
                                manager.createExperience();
                                break;
                            case 2:
                                manager.reportInformation(0);
                                manager.updateById(option);
                                break;
                            case 3:
                                manager.deleteById(option);
                                break;
                            case 4:
                                manager.reportInformation(0);
                                break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        menu();
                        int option1 = Common.inputInteger("Enter option: ", 1, 5);
                        if (option1 == 5) {
                            break;
                        }
                        switch (option1) {
                            case 1:
                                manager.createFresher();
                                break;
                            case 2:
                                manager.reportInformation(1);
                                manager.updateById(option);
                                break;
                            case 3:
                                manager.deleteById(option);
                                break;
                            case 4:
                                manager.reportInformation(1);
                                break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        menu();
                        int option1 = Common.inputInteger("Enter option: ", 1, 5);
                        if (option1 == 5) {
                            break;
                        }
                        switch (option1) {
                            case 1:
                                manager.createIntern();
                                break;
                            case 2:
                                manager.reportInformation(2);
                                manager.updateById(option);
                                break;
                            case 3:
                                manager.deleteById(option);
                                break;
                            case 4:
                                manager.reportInformation(2);
                                break;
                        }
                    }
                    break;
                case 4:
                    manager.reportName();
                    manager.searchByName(Common.inputInteger("Enter type(0: Experience | 1: Fresher | 2: Intern): ", 0, 2), Common.inputString("Enter name: ", ".*"));
                    break;
                case 5:
                    return;
            }
        }

    }
    public static void menu() {
        System.out.println("1. Input information");
        System.out.println("2. Update information");
        System.out.println("3. Delete information");
        System.out.println("4. Report infromation");
        System.out.println("5. Exit");
    }

}
