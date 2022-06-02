/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0065;

/**
 *
 * @author Admin
 */
public class J1SP0065 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manager manager = new Manager();
        System.out.println("====== Management Student Program ======");
        manager.inputInformation();
        manager.displayInformation();
        manager.displayPercentage();
    }
    
}
