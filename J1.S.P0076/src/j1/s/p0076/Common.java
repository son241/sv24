/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0076;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Common {
    public static Scanner in = new Scanner(System.in);
    
    public static int inputInteger(String message, int min, int max){
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
    
    public static double inputDouoble(String message, double min, double max){
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
    
    public static String inputString(String message, String regex){
        String S;
        while (true) {            
            System.out.print(message);
            S = in.nextLine();
            if (S.matches(regex)) {
                break;
            }
            System.out.println("Do not match requirement, try again!");
        }
        return S;
    }
    
    public Date inputDate(String message, String format){
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
}
