/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListObj;

/**
 *
 * @author Admin
 */
public class LinkedList {

    public static void main(String[] args) {
        MyList list = new MyList();
        MyList list1 = new MyList();
        
        list.addFirst("A", 1);
        list.addLast("B", 2);
        list.addLast("C", 3);
        list.addLast("D", 4);
        list.addLast("E", 5);
        
        list.traverse();
    }

}
