/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

/**
 *
 * @author Admin
 */
public class Converter {

    public static String validInput(int fromBase, String regex, String message) {
        while (true) {
            String n = Common.inputString(message, regex);
            if (Converter.checkLimitation(n, fromBase)) {
                return n;
            }
        }
    }

    public static int toDecimal(String n, int base) {
        return Integer.parseInt(n, base);
    }

    public static String toOther(String n, int fromBase, int toBase) {
        StringBuffer S = new StringBuffer("");
        String hexa = "0123456789ABCDEF";
        int dec = toDecimal(n, fromBase);
        while (dec != 0) {
            int i = dec % toBase;
            if (toBase == 16) {
                S.append(hexa.charAt(i));
            } else {
                S.append(i);
            }
            dec /= toBase;
        }
        return S.reverse().toString();

    }

    public static boolean checkLimitation(String n, int base) {
        try {
            int num = toDecimal(n, base);
        } catch (Exception e) {
            if (base == 2) {
                System.out.println("Out of range (0-" + Integer.toBinaryString(Integer.MAX_VALUE) + ")");
                return false;
            }
            if (base == 8) {
                System.out.println("Out of range (0-" + Integer.toOctalString(Integer.MAX_VALUE) + ")");
                return false;
            }
            if (base == 10) {
                System.out.println("Out of range (0-" + Integer.MAX_VALUE + ")");
                return false;
            }
            if (base == 16) {
                System.out.println("Out of range (0-" + Integer.toHexString(Integer.MAX_VALUE).toUpperCase() + ")");
                return false;
            }
        }
        return true;
    }

}
