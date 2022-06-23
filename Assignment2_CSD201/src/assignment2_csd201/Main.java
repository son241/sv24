/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_csd201;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyTree tree = new MyTree();
        tree.insert("A6", "Mama mia", 3.5);
        tree.insert("A2", "Panama", 3.4);
        tree.insert("A1", "Paradise", 4.5);
        tree.insert("A5", "Tomorrow we fight", 4.5);
        tree.insert("A4", "Hello", 3.9);
        tree.insert("A3", "Colors of the wind", 4.0);
        tree.insert("A8", "Summer in Paris", 5.0);
        tree.insert("A7", "In a Persian Market", 4.5);
        tree.insert("A9", "Love in Paris", 3.8);
        tree.insert("A9", "Sang pour sang", 4.8);
        tree.insert("A8", "Memorie", 4.7);
       // tree.traverse();
//        System.out.println(tree.rateAverage());
//        tree.preOrder();
//        tree.dele();
//        tree.preOrder();
        //tree.traverse();
        //System.out.println(tree.level(tree.search("A8")));
       // System.out.println(tree.getHeight(tree.root) - );
    } 
}
