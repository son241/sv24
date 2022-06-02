/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author Admin
 */
public class Manager {
    
    public void subtraction() {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        int row1, row2, column1, column2;
        System.out.println("//Initialize Matrix 1//");
        row1 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
        column1 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
        matrix1.initialize(row1, column1);
        System.out.println("//Initialize Matrix 2//");
        while (true) {
            row2 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
            column2 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
            if (row2 != matrix1.getRow() || column2 != matrix1.getColumn()) {
                System.out.println("Not equal size as Matrix 1, try again!");
            } else {
                break;
            }
        }
        matrix2.initialize(row2, column2);
        
        Matrix.display(matrix1.toArray());
        System.out.println("+");
        Matrix.display(matrix2.toArray());
        System.out.println("=");
        Matrix.display(matrix1.subtraction(matrix2));
    }
    
    public void addition() {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        int row1, row2, column1, column2;
        System.out.println("//Initialize Matrix 1//");
        row1 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
        column1 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
        matrix1.initialize(row1, column1);
        System.out.println("//Initialize Matrix 2//");
        while (true) {
            row2 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
            column2 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
            if (row2 != matrix1.getRow() || column2 != matrix1.getColumn()) {
                System.out.println("Not equal size as Matrix 1, try again!");
            } else {
                break;
            }
        }
        matrix2.initialize(row2, column2);
        int[][] result = new int[column2][column2];
       
        Matrix.display(matrix1.toArray());
        System.out.println("+");
        Matrix.display(matrix2.toArray());
        System.out.println("=");
        Matrix.display(matrix1.addition(matrix2));
    }
    
    public void multiplication() {
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        int row1, row2, column1, column2;
        System.out.println("//Initialize Matrix 1//");
        row1 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
        column1 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
        matrix1.initialize(row1, column1);
        System.out.println("//Initialize Matrix 2//");
        while (true) {
            row2 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
            column2 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
            if (row2 != matrix1.getColumn()) {
                System.out.println("The number of row must be equal to the number of column of Matrix 1, try again!");
            } else {
                break;
            }
        }
        matrix2.initialize(row2, column2);
        
        Matrix.display(matrix1.toArray());
        System.out.println("x");
        Matrix.display(matrix2.toArray());
        System.out.println("=");
        Matrix.display(matrix1.multiplication(matrix2));
    }
    
}
