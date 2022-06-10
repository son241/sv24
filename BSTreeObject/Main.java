/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTreeObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws IOException{
        MyTree tree = new MyTree();
        /*
                        A
                               C
                          D          E
                                     
        */
        tree.insert("C", 34);
        tree.insert("A", 21);
        tree.insert("D", 24);
        tree.insert("E", 14);
        tree.insert("W", 28);
        tree.insert("K", 20);
        tree.insert("T", 17);
        //tree.delete("W");
        //tree.rotateLeft(tree.search("C"));
        //tree.breadth();
       // tree.inorder();
//        System.out.println("Number of node: " + tree.count());
//        tree.writeFile();
        //tree.writeFile();
        
    }
}
