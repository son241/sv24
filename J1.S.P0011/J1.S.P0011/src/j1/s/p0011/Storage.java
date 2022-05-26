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
public class Storage {
      while (true) {
            System.out.println("Please choose base for inputing");
            Converter.menu();
            inputOption = Common.inputInteger("Enter option: ", 1, 5);
            switch (inputOption) {
                case 1:
                    while (true) {
                        n = Common.inputString("Enter a decimal (positive integer): ", "[0-9]+");
                        base = 10;
                        if (Converter.checkLimitation(n, base)) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        n = Common.inputString("Enter a binary (0 or 1 only): ", "[0-1]+");
                        base = 2;
                        if (Converter.checkLimitation(n, base)) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        n = Common.inputString("Enter an octal (0-7 only): ", "[0-7]+");
                        base = 8;
                        if (Converter.checkLimitation(n, base)) {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        n = Common.inputString("Enter a hexadecimal(0-9 or A-F only): ", "[0-9[a-fA-F]]+").toUpperCase();
                        base = 16;
                        if (Converter.checkLimitation(n, base)) {
                            break;
                        }
                    }
                    break;
                case 5:
                    return;
            }
            System.out.println("Please choose base for outputing");
            //When user input decimal
            if (base == 10) {
                while (true) {
                    outputOption = Common.inputInteger("1. To binary\n"
                            + "2. To octal\n"
                            + "3. To hexadecimal\n"
                            + "4. Exit\n"
                            + "Enter option: ", 1, 4);
                    switch (outputOption) {
                        case 1:
                            System.out.println(n + "(dec) = " + Converter.toBinary(n, base) + "(bin)");
                            break;
                        case 2:
                            System.out.println(n + "(dec) = " + Converter.toOctal(n, base) + "(oct)");
                            break;
                        case 3:
                            System.out.println(n + "(dec) = " + Converter.toHexa(n, base) + "(hex)");
                            break;
                    }
                    if (outputOption == 4) {
                        break;
                    }
                }
                //When user input binary
            } else if (base == 2) {
                while (true) {
                    outputOption = Common.inputInteger("1. To decimal\n"
                            + "2. To octal\n"
                            + "3. To hexadecimal\n"
                            + "4. Exit\n"
                            + "Enter option: ", 1, 4);
                    switch (outputOption) {
                        case 1:
                            System.out.println(n + "(bin) = " + Converter.toDecimal(n, base) + "(dec)");
                            break;
                        case 2:
                            System.out.println(n + "(bin) = " + Converter.toOctal(n, base) + "(oct)");
                            break;
                        case 3:
                            System.out.println(n + "(bin) = " + Converter.toHexa(n, base) + "(hex)");
                            break;
                    }
                    if (outputOption == 4) {
                        break;
                    }
                }
              //When user input octal
            } else if (base == 8) {
                while (true) {
                    outputOption = Common.inputInteger("1. To decimal\n"
                            + "2. To binary\n"
                            + "3. To hexadecimal\n"
                            + "4. Exit\n"
                            + "Enter option: ", 1, 4);
                    switch (outputOption) {
                        case 1:
                            System.out.println(n + "(oct) = " + Converter.toDecimal(n, base) + "(dec)");
                            break;
                        case 2:
                            System.out.println(n + "(oct) = " + Converter.toBinary(n, base) + "(oct)");
                            break;
                        case 3:
                            System.out.println(n + "(oct) = " + Converter.toHexa(n, base) + "(bin)");
                            break;
                    }
                    if (outputOption == 4) {
                        break;
                    }
                }
                //When user input hexadecimal
            } else if (base == 16) {
                while (true) {
                    outputOption = Common.inputInteger("1. To decimal\n"
                            + "2. To binary\n"
                            + "3. To octal\n"
                            + "4. Exit\n"
                            + "Enter option: ", 1, 4);
                    switch (outputOption) {
                        case 1:
                            System.out.println(n + "(hex) = " + Converter.toDecimal(n, base) + "(dec)");
                            break;
                        case 2:
                            System.out.println(n + "(hex) = " + Converter.toBinary(n, base) + "(bin)");
                            break;
                        case 3:
                            System.out.println(n + "(hex) = " + Converter.toOctal(n, base) + "(oct)");
                            break;
                    }
                    if (outputOption == 4) {
                        break;
                    }
                }
            }
        }
}
