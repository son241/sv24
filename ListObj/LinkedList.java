/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListObj;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class LinkedList {

    public static void main(String[] args) {
        MyList list = new MyList();

        list.addFirst("A", 1);
        list.addLast("E", 23);
        list.addLast("C", 20);
        list.addLast("D", 24);
        list.addLast("E", 26);
        list.addLast("B", 28);
        list.addLast("A", 20);
        list.addLast("I", 28);
        list.addLast("E", 20);
        list.addLast("C", 31);
        //list.delByAge(20);
        //list.displayFirst5ByAge(22);
        System.out.println("Second max value: " + maxAge(list, 2));
        //list.add("New Node", 2405, 10);
        //list.dele(list.getLastNodeByAge(20));
        //list.sortByAge();
        list.sort(0, 10);
        list.traverse();
        System.out.println("Head: " + list.head.info.toString() + "\tTail: " + list.tail.info.toString());

    }

    static int maxAge(MyList list, int rank) {
        if (list.count() < rank) {
            System.out.println("Invalid!");
            return -1;
        }
        Person[] personArray = list.toArray();
        int countBigger = 0;
        int[] ageArray = new int[list.count()];
        for (int i = 0; i < list.count(); i++) {
            ageArray[i] = personArray[i].getAge();
        }
        Arrays.sort(ageArray);

        for (int i = ageArray.length - 1; i >= 0; i--) {
            if (ageArray[i - 1] < ageArray[i]) {
                countBigger += 1;
                if (countBigger == rank) {
                    return ageArray[i];
                }
            }
        }
//        int max = 0;
//        for (int i : ageArray) {
//            if (i >= max) {
//                max = i;
//            }
//          //  System.out.println(i);
//        }

        return 0;
    }
}
