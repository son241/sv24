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
public class MyList {
    Node front;
    Node rear;
    
    public boolean isEmpty(){
        return front == null;
    }
    
    public void clear(){
        front = rear = null;
    }
    
    public void enqueue(int x){
        Node p = new Node(x);
        if (isEmpty()) {
            front = rear = p;
            return;
        }
        rear.next = p;
        rear = p;
    }
    
    public int dequeue() throws Exception{
        if (isEmpty()) {
            return -1;
        }
        int x = front.info;
        front = front.next;
        return x;
    }
    
    public int first() throws Exception{
        try {
            return front.info;
        } catch (Exception e) {
            System.out.println("The list is empty!");
        }
        return -1;
    }
    
    public void traverse(){
        Node p = front;
        while (p != null) {            
            System.out.print(p.info);
            p = p.next;
        }
    }
}
