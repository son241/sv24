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
public class Node {
    Node next;
    int info;

    public Node(int info) {
        this.info = info;
        this.next = null;
    }
    
}
