/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Manager {

    ArrayList<Student> list = new ArrayList<Student>();

    public Manager(ArrayList<Student> list) {
        this.list = list;
    }

    public Manager() {
    }

    public void inputInformation() {
        String still_going;
        do {
            String name = Common.inputName("Name: ");
            String className = Common.inputString("Class: ", ".+");
            double math = Common.inputDouble("Math (1 - 10): ", 1, 10);
            double chemistry = Common.inputDouble("Chemistry (1 - 10): ", 1, 10);
            double physic = Common.inputDouble("Physics (1 - 10): ", 1, 10);
            Student S = new Student(name, className, math, physic, chemistry);
            list.add(S);
            still_going = Common.inputString("Do you want to enter more student information (Y/N)? ", "[yYnN]");
        } while (still_going.equalsIgnoreCase("Y"));
    }
    
    public void displayInformation(){
        int i = 0;
        for (Student item : list) {
            i++;
            System.out.println("------ Student" + i + " Info ------");
            item.display();
        }
    }

    public void displayPercentage() {
        int countTypeA = 0;
        int countTypeB = 0;
        int countTypeC = 0;
        int countTypeD = 0;

        for (Student item : list) {
            if (item.getType().equals("A")) {
                countTypeA++;
            }
            if (item.getType().equals("B")) {
                countTypeB++;
            }
            if (item.getType().equals("C")) {
                countTypeC++;
            }
            if (item.getType().equals("D")) {
                countTypeD++;
            }
        }
//        System.out.println("Type A: " + countTypeA);
//        System.out.println("Type B: " + countTypeB);
//        System.out.println("Type C: " + countTypeC);
//        System.out.println("Type D: " + countTypeD);
        System.out.println("--------Classification Info -----");
        System.out.println("A: " + ((double)countTypeA / (double)list.size()) * 100 + " %");
        System.out.println("B: " + ((double)countTypeB / (double)list.size()) * 100 + " %");
        System.out.println("C: " + ((double)countTypeC / (double)list.size()) * 100 + " %");
        System.out.println("D: " + ((double)countTypeD / (double)list.size()) * 100 + " %");
    }

}
