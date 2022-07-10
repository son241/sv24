/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 */
public class MyList {
    Node top;
    
    public boolean isEmpty(){
        return top == null;   
    }
    
    public void clear(){
        top = null;
    }
    
    public void push(int x){
        Node p = new Node(x);
        if (isEmpty()) {
            top = p;
            return;
        }
        p.next = top;
        top = p;
    }
    
    public int pop() throws EmptyStackException{
        int x = top.info;
        top = top.next;
        return x;
    }
    
    public int top() throws EmptyStackException{
        return top.info;
    }
    
    public int size(){
        Node p = top;
        int count = 0;
        if (isEmpty()) {
            return 0;
        }
        while (p != null) {            
            count += 1;
            p = p.next;
        }
        return count;
    }
    
    public void traverse(){
        Node p = top;
        while (p != null) {            
            System.out.print(p.info);
            p = p.next;
        }
    }
  
}
