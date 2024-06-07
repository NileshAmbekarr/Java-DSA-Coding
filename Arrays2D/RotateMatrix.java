package Arrays2D;

import java.util.Scanner;

public class RotateMatrix {
    static void printArray(int[][] arr){
         for(int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
            System.out.println();
        }
    }
    static void TransposeMatrix(int[][] matrix , int r , int c ){
        for(int i = 0; i<r ; i++){
            for(int j = i; j<c; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp ;
            }
        }
    }
    static void rotateMatrix(int[][] matrix ,int  n){
        // To rotate the matrix , we will first transpose the matrix
        // and then reverse each row of the matrix
        TransposeMatrix(matrix , n, n);
        for (int i = 0; i < n ; i++){
            reverseArray(matrix[i]);
        }

    }
    static void reverseArray(int[] arr ){
        int i = 0 , j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp ;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no pf rows and columns of matrix :");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] mat = new int[r][c];
        System.out.println("Enter Array Elements :");
        for (int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c ; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Your entered Matrix is : ");
        printArray(mat);
        rotateMatrix(mat, r);
        System.out.println("The Rotated Matrix is :");
        printArray(mat);
    }
}
