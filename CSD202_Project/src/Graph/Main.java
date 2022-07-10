/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        MyGraph g = new MyGraph();
        int[][]b = {
            {0, 1, 1, 0, 0, 0}, //a - b, a- c
            {1, 0, 0, 1, 0, 0}, //b - d
            {1, 0, 0, 0, 0, 0}, //c - a
            {0, 1, 0, 0, 0, 0}, //d - b
            {0, 0, 0, 0, 0, 1}, //e - f
            {0, 0, 0, 0, 1, 0}  // f - e
        };
        g.setData(b);
        g.breath(4);
        Dijkstra d = new Dijkstra(new int[][] {
            //A  B  C  D  E  F 
            {0, 2, 5, 1, 99, 99},//A
            {2, 0, 3, 2, 99, 99},//B
            {5, 3, 0, 3, 1, 5},//C
            {1, 2, 3, 0, 1, 99},//D
            {99, 99, 1, 1, 0, 2},//E
            {99, 99, 5, 99, 2, 0},//F
        });
        d.ijk(2, 5);
        //g.depth();    
        //g.display();
    }
}
