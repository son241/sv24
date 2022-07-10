/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author Admin
 */
public class PracticalExercises {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sum(n));
        int[] arr = {
            3, 4, 1, 6, 9
        };
        System.out.println("Min: " + findMin(arr, arr.length));
        System.out.println("Sum: " + sumArray(arr, arr.length));
        //System.out.println("Binary search: " + binSearch(arr, arr.length, 4));
        char[] a = {
            'c', 'b', 'a'
        };
        System.out.println("Is palidrome: " + isPalidrome(a, a.length - 1, 0));
        System.out.println("Power: " + power(5, 6));
    }

    private static int sum(int n) {
        if(n > 0){
            return n + sum(n - 1);
        }else
            return 0;
    }

    private static int findMin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    private static int sumArray(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return arr[n - 1] + sumArray(arr, n - 1);
    }
    
    static boolean isPalidrome(char[]a, int end, int start){
        if (start == end) {
            return true;
        }
        if (a[start] == a[end]) {
            return isPalidrome(a, end - 1, start + 1);
        }else
            return false;
    }

//    private static int binSearch(int[] arr, int n, int target) {
//        int mid = n/2;
//        int head = 0;
//        int tail = n - 1;
//        if (arr[mid] == target) {
//            return mid;
//        }
//        if (arr[mid] >= target) {
//            
//        }
//    }

    private static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        
        return x*power(x, n - 1);
    }
    
    
}
