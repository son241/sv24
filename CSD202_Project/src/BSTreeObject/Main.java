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

    public static void main(String[] args) throws IOException {
        MyTree tree = new MyTree();
        /*
                        A
                               C
                          D          E
                                     
         */
        tree.insertIfNotStartWithB("J", 10);
        tree.insertIfNotStartWithB("F", 7);
        tree.insertIfNotStartWithB("P", 9);
        tree.insertIfNotStartWithB("D", 7);
        tree.insertIfNotStartWithB("G", 8);
        tree.insertIfNotStartWithB("L", 8);
        tree.insertIfNotStartWithB("V", 8);
        tree.insertIfNotStartWithB("C", 8);
        tree.insertIfNotStartWithB("N", 8);
        tree.insertIfNotStartWithB("S", 8);
        tree.insertIfNotStartWithB("X", 8);
        tree.insertIfNotStartWithB("Q", 8);
        tree.insertIfNotStartWithB("U", 8);
//        tree.preOrder();
//        tree.writeFile();
        tree.breadth();
        tree.rotateRight(tree.search("Q"));
        tree.breadth();
//        System.out.println(tree.getHeight());
//        tree.printBalanceFactor();
        //tree.printBalanceFactor();
//        tree.breadth();
//        tree.singleBalance();
//        tree.breadth();
        //tree.printBalanceFactor();
        //System.out.println(tree.getHeight(tree.search("E")));
        //System.out.println("Count: " + tree.count());
//        tree.insert("K", 20);
//        tree.insert("T", 17);
        //tree.writeFile();
        //tree.delete("W");
        //tree.rotateLeft(tree.search("C"));
        //tree.breadth();
        // tree.inorder();
//        System.out.println("Number of node: " + tree.count());
//        tree.writeFile();
        //tree.writeFile();

    }
}
