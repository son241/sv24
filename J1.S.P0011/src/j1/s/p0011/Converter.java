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

    public static void menu() {
        System.out.println("1. Numeral");
        System.out.println("2. Binary number");
        System.out.println("3. Octal number");
        System.out.println("4. Hexadecimal number");
        System.out.println("5. Exit");
    }

    public static int toDecimal(String n, int base) {
        return Integer.parseInt(n, base);
    }

    public static String toBinary(String n, int base) {
        if (base == 10) {
            StringBuffer S = new StringBuffer("");
            int dec = toDecimal(n, base);
            while (dec > 0) {
                int p = dec % 2;
                S.append(p);
                dec /= 2;
            }
            return S.reverse().toString();
        }
        if (base == 8) {
            return toBinary(String.valueOf(toDecimal(n, base)), 10);
        }
        if (base == 16) {
            return toBinary(String.valueOf(toDecimal(n, base)), 10);
        }
        return null;
    }

    public static String toHexa(String n, int base) {
        if (base == 10) {
            StringBuffer S = new StringBuffer("");
            int dec = toDecimal(n, base);
            while (dec > 0) {
                int p = dec % 16;
                if (p == 10) {
                    S.append("A");
                } else if (p == 11) {
                    S.append("B");
                } else if (p == 12) {
                    S.append("C");
                } else if (p == 13) {
                    S.append("D");
                } else if (p == 14) {
                    S.append("E");
                } else if (p == 15) {
                    S.append("F");
                } else {
                    S.append(p);
                }
                dec /= 16;
            }
            return S.reverse().toString();
        }
        if (base == 2) {
            return toHexa(String.valueOf(toDecimal(n, base)), 10);
        }
        if (base == 8) {
            return toHexa(String.valueOf(toDecimal(n, base)), 10);
        }
        return null;
    }

    public static String toOctal(String n, int base) {
        if (base == 10) {
            int dec = toDecimal(n, base);
            StringBuffer S = new StringBuffer("");
            while (dec > 0) {
                int p = dec % 8;
                S.append(p);
                dec /= 8;
            }
            return S.reverse().toString();
        }
        if (base == 16) {
            return toOctal(String.valueOf(toDecimal(n, base)), 10);
        }
        if (base == 2) {
            return toOctal(String.valueOf(toDecimal(n, base)), 10);
        }
        return null;
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
