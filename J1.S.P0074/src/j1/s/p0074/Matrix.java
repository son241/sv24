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

    private int[][] matrix;

    public Matrix() {
    }

    public int getRow() {
        return matrix.length;
    }

    public int getColumn() {
        return matrix[0].length;
    }

    public void initialize(int row, int column) {
        matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Common.inputInteger("Enter Matrix" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    public int[][] toArray() {
        int[][] arr = new int[this.getRow()][this.getColumn()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        return arr;
    }

    public int getValueAt(int row, int column) {
        return matrix[row][column];
    }

    public int[][] addition(Matrix newMatrix) {
        //display(this.matrix);
        if (this.getRow() == newMatrix.getRow() && this.getColumn() == newMatrix.getColumn()) {
            int[][] matrix2 = newMatrix.toArray();
            int[][] result = new int[this.getRow()][this.getColumn()];
            //System.out.println("Row: " + this.getRow() + "    " + "Column: " + this.getColumn());
            for (int i = 0; i < this.getRow(); i++) {
                for (int j = 0; j < this.getColumn(); j++) {
                    result[i][j] = this.matrix[i][j] + matrix2[i][j];
                }
            }
            return result;
        }
        System.out.println("Fail to add Matrix!");
        return null;
    }

    public int[][] subtraction(Matrix newMatrix) {
        if (this.getRow() == newMatrix.getRow() && this.getColumn() == newMatrix.getColumn()) {
            int[][] matrix2 = newMatrix.toArray();
            int[][] result = new int[this.getRow()][this.getColumn()];
            for (int i = 0; i < this.getRow(); i++) {
                for (int j = 0; j < this.getColumn(); j++) {
                    result[i][j] = matrix[i][j] - matrix2[i][j];
                }
            }
            return result;
        }
        System.out.println("Fail to subtract!");
        return null;
    }

    public int[][] multiplication(Matrix newMatrix) {
        if (this.getColumn() == newMatrix.getRow()) {
            int[][] matrix2 = newMatrix.toArray();
            int[][] result = new int[this.getRow()][newMatrix.getColumn()];
            for (int i = 0; i < this.getRow(); i++) {
                for (int j = 0; j < newMatrix.getColumn(); j++) {
                    for (int k = 0; k < this.getColumn(); k++) {
                        result[i][j] += matrix[i][k] * matrix2[k][j];
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
