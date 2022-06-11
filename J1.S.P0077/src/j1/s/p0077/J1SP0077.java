/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0077;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class J1SP0077 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        while (true) {
            System.out.println("============ Word Program =========\n"
                    + "1. Count Word In File\n"
                    + "2. Find File By Word\n"
                    + "3. Exit");
            int option = Common.inputInteger("Enter option: ", 1, 3);

            switch (option) {
                case 1:
                    File source;

                    //Validate file can be read or not
                    while (true) {
                        String pathname = Common.inputString("Enter path: ", ".+");
                        source = new File(pathname);
                        //System.out.println("File doesn't exist, try again!");
                        if (!source.canRead()) {
                            System.out.println("Can't read file, try again!");
                        } else {
                            break;
                        }
                    }

                    //enter word to search
                    String wordSearch = Common.inputString("Enter Word: ", "\\S+");

                    //Store text in store variable
                    String store = getFileContent(source.getAbsolutePath());

                    //if the file is not empty ==> count else notify user the file is empty
                    if (!store.isEmpty()) {
                        String[] words = store.split("\\s+");
                        int count = 0;
                        for (String item : words) {
                            if (item.equalsIgnoreCase(wordSearch)) {
                                count++;
                            }
                        }
                        System.out.println("Number of occurrences of " + "\"" + wordSearch + "\": " + count);
                    } else {
                        System.out.println("The text file is empty!");
                    }
                    break;
                case 2:
                    File file;
                    
                    //validate the file can be read or not
                    while (true) {
                        String pathname = Common.inputString("Enter path: ", ".+");
                        file = new File(pathname);
                        if (!file.canRead()) {
                            System.out.println("Can't read file, try again!");
                        } else {
                            break;
                        }
                    }
                    
                    //Subfiles are stored in an array
                    File[] listFile = file.listFiles();
                    
                    //If there is not subfile ==> notify 
                    if (listFile.length == 0) {
                        System.out.println("File is empty!");
                    } else {
                        
                        //If there is subfile, store information of subfile in hashmap with the key is name of file
                        HashMap<String, String> list = new HashMap<String, String>();
                        for (int i = 0; i < listFile.length; i++) {
                            list.put(listFile[i].getName(), getFileContent(listFile[i].getAbsolutePath()));
                        }
                        String searchWord = Common.inputString("Enter Word: ", "\\S+");
                        
                        //List found will store name of file that contain the search word
                        ArrayList<String> found = new ArrayList<String>();
                        for (int i = 0; i < listFile.length; i++) {
                            if (list.get(listFile[i].getName()).contains(searchWord)) {
                                found.add(listFile[i].getName());
                            }
                        }

                        //if not found ==> notify else print the list of subfile
                        if (found.isEmpty()) {
                            System.out.println("Not Found!");
                        } else {
                            System.out.println("Found " + "\"" + searchWord + "\"" + " at subfile: ");
                            for (String item : found) {
                                System.out.println(item);
                            }
                        }
                    }

                    break;
                case 3:
                    return;
            }
        }
    }

    //The method return text in a file by passing the pathname
    public static String getFileContent(String pathname) throws FileNotFoundException {
        String store = "";
        File source = new File(pathname);
        Scanner in = new Scanner(source);
        while (in.hasNextLine()) {
            store += in.nextLine();
        }
        return store;
    }

}
