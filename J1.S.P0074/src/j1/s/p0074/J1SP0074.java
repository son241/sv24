/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author Admin
 */
public class J1SP0074 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manager manager = new Manager();
        int option;
        while (true) {
            System.out.println("=====Caculator Program=====");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Mutiplication Matrix");
            System.out.println("4. Quit");
            option = Common.inputInteger("Enter option: ", 1, 4);
            
            switch (option) {
                case 1:
                    manager.addition();
                    break;
                case 2:
                    manager.subtraction();
                    break;
                case 3:
                    manager.multiplication();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
