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

    public int[][] initialize(int row, int column) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Common.inputInteger("Enter Matrix" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    public void subtraction() {
        int[][] matrix1;
        int[][] matrix2;
        int row1, row2, column1, column2;
        
        System.out.println("//Initialize Matrix 1//");
        row1 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
        column1 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
        matrix1 = initialize(row1, column1);
        
        String regexRow = "[" + String.valueOf(row1) + "]";
        String regexColumn = "[" + String.valueOf(column1) + "]";
        
        System.out.println("//Initialize Matrix 2//");
        row2 = Integer.parseInt(Common.inputString("Enter number of row: ", regexRow, "Not equal size as Matrix 1, try again!"));
        column2 = Integer.parseInt(Common.inputString("Enter number of column: ", regexColumn, "Not equal size as Matrix 1, try again!"));
        matrix2 = initialize(row2, column2);
        
        Matrix.display(matrix1);
        System.out.println("-");
        Matrix.display(matrix2);
        System.out.println("=");
        Matrix.display(Matrix.subtraction(matrix1, matrix2));
    }

    public void addition() {
        int[][] matrix1;
        int[][] matrix2;
        int row1, row2, column1, column2;
        
        System.out.println("//Initialize Matrix 1//");
        row1 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
        column1 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
        matrix1 = initialize(row1, column1);
        
        String regexRow = "[" + String.valueOf(row1) + "]";
        String regexColumn = "[" + String.valueOf(column1) + "]";
        
        System.out.println("//Initialize Matrix 2//");
        row2 = Integer.parseInt(Common.inputString("Enter number of row: ", regexRow, "Not equal size as Matrix 1, try again!"));
        column2 = Integer.parseInt(Common.inputString("Enter number of column: ", regexColumn, "Not equal size as Matrix 1, try again!"));
        matrix2 = initialize(row2, column2);
        
        Matrix.display(matrix1);
        System.out.println("+");
        Matrix.display(matrix2);
        System.out.println("=");
        Matrix.display(Matrix.addition(matrix1, matrix2));
    }

    public void multiplication() {
        int[][] matrix1;
        int[][] matrix2;
        int row1, row2, column1, column2;
        
        System.out.println("//Initialize Matrix 1//");
        row1 = Common.inputInteger("Enter number of row: ", 1, Integer.MAX_VALUE);
        column1 = Common.inputInteger("Enter number of column: ", 1, Integer.MAX_VALUE);
        
        matrix1 = initialize(row1, column1);
        
        String regexRow = "[" + String.valueOf(column1) + "]";
        System.out.println("//Initialize Matrix 2//");
        row2 = Integer.parseInt(Common.inputString("Enter number of row: ", regexRow, "Not equal size as column of Matrix 1, try again!"));
        column2 = Integer.parseInt(Common.inputString("Enter number of column: ", ".+", ""));
        matrix2 = initialize(row2, column2);

        Matrix.display(matrix1);
        System.out.println("x");
        Matrix.display(matrix2);
        System.out.println("=");
        Matrix.display(Matrix.multiplication(matrix1, matrix2));
    }

}
