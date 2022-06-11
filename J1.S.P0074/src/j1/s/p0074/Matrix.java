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
public class Matrix {


    public static int[][] addition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            int[][] result = new int[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return result;
        }
        System.out.println("Fail to add Matrix!");
        return null;
    }

    public static int[][] subtraction(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            int[][] result = new int[matrix1.length][matrix1[0].length];
            //System.out.println("Row: " + this.getRow() + "    " + "Column: " + this.getColumn());
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            return result;
        }
        System.out.println("Fail to subtract Matrix!");
        return null;
    }

    public static int[][] multiplication(int[][]matrix1, int[][]matrix2) {
        if (matrix1[0].length == matrix2.length) {
            int[][] result = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return result;
        }
        System.out.println("Fail to multiply!");
        return null;
    }

    public static void display(int[][] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print("[" + arr[i][j] + "]");
                }
                System.out.println("");
            }
            return;
        }
        System.out.println("Fail to display!");
        return;
    }
}
