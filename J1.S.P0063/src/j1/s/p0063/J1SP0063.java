/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0063;

/**
 *
 * @author Admin
 */
public class J1SP0063 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Person[] list = new Person[3];
        Manager manager = new Manager();

        //Input information
        for (int i = 0; i < 3; i++) {
            System.out.println("//Enter information of Person " + i + "//");
            String name = Common.inputName("Enter name: ");
            String address = Common.inputString("Enter address: ", ".+");
            double salary = Common.inputDouble("Enter salary: ", 1, Double.MAX_VALUE);
            list[i] = manager.inputPersonInfo(name, address, salary);
        }
        
        //Sort information
        list = manager.sortBySalary(list);

        //Report information by ascending order
        System.out.println("");
        for (int i = 0; i < list.length; i++) {
            System.out.println("You have entered information:");
            System.out.println(list[i].toString());
        }

    }

}
