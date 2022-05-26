/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class J1SP0011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here    
        int fromBase;
        int toBase;
        int[] base = {
            2, 8, 10, 16
        };
        String n = "";
        String still_going;
        do {
            fromBase = inputBase(base, "From base(2, 8, 10, 16): ");
            n = Converter.validInput(fromBase, regex(fromBase), message(fromBase));
            int exit;
            do {
                toBase = inputBase(base, "To base(2, 8, 10, 16): ");
                if (toBase != 10) {
                    System.out.println(n + " (base " + fromBase + ") = " + Converter.toOther(n, fromBase, toBase) + " (base " + toBase + ")");
                } else {
                    System.out.println(n + " (base " + fromBase + ") = " + Converter.toDecimal(n, fromBase) + " (base " + toBase + ")");
                }
                exit = Common.inputInteger("Continue converting(1-Continue | 0-Exit): ", 0, 1);
            } while (exit == 1);
            still_going = Common.inputString("Do you want to continue program(Y/N)? ", "[yYnN]");
        } while (still_going.equalsIgnoreCase("Y"));
    }

    private static int inputBase(int[] base, String message) {
        while (true) {
            int num = Common.inputInteger(message, 2, 16);
            for (int i = 0; i < base.length; i++) {
                if (num == base[i]) {
                    return num;
                }
            }
            System.out.println("Unavailable base, try again!");
        }
    }

    private static String regex(int fromBase) {
        if (fromBase == 2) {
            return "[0-1]+";
        }
        if (fromBase == 8) {
            return "[0-7]+";
        }
        if (fromBase == 10) {
            return "[0-9]+";
        }
        if (fromBase == 16) {
            return "[0-9[a-fA-F]]+";
        }
        return "";
    }

    private static String message(int fromBase) {
        if (fromBase == 2) {
            return "Enter a binary (0 or 1 only): ";
        }
        if (fromBase == 8) {
            return "Enter an octal (0-7 only): ";
        }
        if (fromBase == 10) {
            return "Enter a decimal (positive integer): ";
        }
        if (fromBase == 16) {
            return "Enter a hexadecimal(0-9 or A-F only): ";
        }
        return "";
    }

}
