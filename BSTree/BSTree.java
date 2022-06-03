/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTree;

/**
 *
 * @author Admin
 */
public class BSTree {

    public static void main(String[] args) {
        /*
                             50
            30                                  90
        15      40                         70        100
    10              45                60        80
                                  55         65
                                                67
                                            66     
         */
        int[] a = {
            50, 90, 70, 100, 30, 15, 10, 40, 45, 60, 80, 65, 67, 66, 55
        };
        /*
        
         */
        MyTree tree = new MyTree();
        System.out.println("Is empty: " + tree.isEmpty());
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        //tree.clear();
        //System.out.println("Test Search: " + tree.search(100).info);
//        System.out.print("Preorder: ");
//        tree.preOrder();
//        System.out.print("Inorder: ");
//        tree.inorder();
//        System.out.print("Postorder: ");
//        tree.postorder();
//        System.out.println("");
        //System.out.print("Breath: ");   
        tree.breadth();
        tree.delete(70);
        tree.breadth();
//        System.out.println("Min: " + tree.min());
//        System.out.println("Max: " + tree.max());
//        System.out.println("Count: " + tree.count());
//        System.out.println("Sum: " + tree.sum());
//        System.out.println("Average: " + tree.avg());
//        System.out.println("Height: " + tree.getHeight());
    }

}
