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
public class Node {

    Song info;
    Node left, right;

    public Node(String id, String name, double rate) {
        info = new Song(id, name, rate);
        left = right = null;
    }

}
