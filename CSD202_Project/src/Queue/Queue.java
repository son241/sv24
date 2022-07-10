/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Admin
 */
public class Queue {

    public static void main(String[] args) throws Exception {
        MyList list = new MyList();
//        list.enqueue(1);
//        list.enqueue(2);
//        list.enqueue(3);
//        list.enqueue(4);
//        list.enqueue(5);
//        list.dequeue();
//        double n = 0.40625;
//        while (n != 1) {            
//            double i = n*2;
//            if (i >= 1) {
//                list.enqueue(1);
//            }else
//                list.enqueue(0);
//            n *= 2;
//            if (n > 1) {
//                n -= 1;
//            }
//        }

//        
        System.out.println(list.isEmpty());
        System.out.println(list.first());
        list.traverse();
        System.out.println("");
    }
}
