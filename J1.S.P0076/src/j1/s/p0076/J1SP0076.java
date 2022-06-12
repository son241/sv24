/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0076;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.print.Printer;

/**
 *
 * @author Admin
 */
public class J1SP0076 {

    /**
     * @param args the command line arguments
     */
    static String dataCSV = "";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String[] list = null;
        while (true) {
            System.out.println("======= Format CSV Program =======\n"
                    + "1. Import CSV\n"
                    + "2. Format Address\n"
                    + "3. Format Name\n"
                    + "4. Export CSV\n"
                    + "5. Exit"
            );
            int option = Common.inputInteger("Enter option: ", 1, 5);
            if (option == 5) {
                return;
            }
            switch (option) {
                case 1:
                    String pathname = Common.inputString("Enter path: ", ".+");
                    importCSV(pathname);
                    list = dataCSV.split("\\n");
                    System.out.println("Import: Done");
                    //System.out.println(dataCSV);
                    break;
                case 2:
                    try {
                        for (int i = 0; i < list.length; i++) {
                            list[i] = list[i].replace(getAddress(list[i]), formatAddress(getAddress(list[i])));
                        }
                        dataCSV = "";
                        for (String item : list) {
                            dataCSV += item + "\n";
                        }
                        System.out.println("Format: Done");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Fail to format!");
                    }
                    break;
                case 3:
                    try {
                        for (int i = 0; i < list.length; i++) {
                            list[i] = list[i].replace(getName(list[i]), formatName(getName(list[i])));
                        }
                        dataCSV = "";
                        for (String item : list) {
                            dataCSV += item + "\n";
                        }
                        System.out.println("Format: Done");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Fail to format!");
                    }

                    break;
                case 4:
                    String pathName = Common.inputString("Enter path: ", ".+");
                    File file = new File(pathName);

                    if (file.exists()) {
                        FileWriter out = new FileWriter(file);
                        out.write(dataCSV);
                        out.close();
                        System.out.println("Export: Done");
                    } else {
                        System.out.println("File doesn't exist!");
                        String agree = Common.inputString("Create new file with path " + "\"" + pathName + "\" <Y/N>? ", "[yYnN]");

                        if (agree.equalsIgnoreCase("Y")) {
                            FileWriter out = new FileWriter(file);
                            System.out.println("Creating file successfully!");
                            out.write(dataCSV);
                            out.close();
                            System.out.println("Export: Done");
                        }
                    }

                    break;
            }
        }

    }

    public static String formatName(String name) {

        name = name.replaceAll("\\s+", " ").trim().toLowerCase();
        String surname;
        String firstname;
        String lastname;

        //Chuẩn hóa firstname
        firstname = name.substring(name.lastIndexOf(" ") + 1);
        firstname = uppercaseFirstChar(firstname);

        //Chuẩn hóa lastname
        lastname = name.substring(0, name.indexOf(" "));
        lastname = uppercaseFirstChar(lastname);

        //Chuânr hóa surname
        surname = "";
        try {
            surname = name.substring(name.indexOf(" ") + 1, name.lastIndexOf(" "));
            surname = uppercaseFirstChar(surname);
        } catch (Exception e) {
        }

        if (surname.isEmpty()) {
            name = lastname + " " + firstname;
        } else {
            name = lastname + " " + surname + " " + firstname;
        }
        return name;
    }

    private static String formatAddress(String address) {
        address = address.replaceAll("\\s+", " ");
        String[] S = address.split("-");
        address = "";
        for (int i = 0; i < S.length - 1; i++) {
            address += uppercaseFirstChar(S[i].trim()) + " - ";
        }
        address += uppercaseFirstChar(S[S.length - 1].trim());
        return address;
    }

    private static void importCSV(String pathname) throws FileNotFoundException {
        try {
            File file = new File(pathname);
            dataCSV = getFileContent(file);
            return;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Fail to import!");
    }

    private static String getFileContent(File file) throws FileNotFoundException, IOException {
        String S = "";
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            S += in.nextLine() + "\n";
        }
        return S;
    }

    private static String getName(String info) {
        String[] S = info.split(", ");
        return S[1];
    }

    private static String getAddress(String info) {
        String[] S = info.split(", ");
        return S[S.length - 1];
    }

    private static String uppercaseFirstChar(String text) {
        text = text.toLowerCase();
        String[] S = text.split(" ");
        text = "";
        for (String item : S) {
            text += item.substring(0, 1).toUpperCase() + item.substring(1) + " ";
        }
        return text.trim();
    }
}
