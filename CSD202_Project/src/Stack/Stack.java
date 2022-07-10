/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Admin
 */
public class Stack {
    public static void main(String[] args) {
        MyList list = new MyList();       
        int dec = 78;
        
        //System.out.println("Top: " + list.top());
        //System.out.println("Pop: " + list.pop());
        while (dec > 0) {            
            int i = dec % 2;
            list.push(i);
            dec /= 2;
        }
        list.clear();
        System.out.println("Is empty: " + list.isEmpty());
        list.traverse();
        System.out.println("");
    }
}
