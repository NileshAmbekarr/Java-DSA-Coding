package Arrays2D;

import java.util.Scanner;

public class MatrixTranspose{
    static int[][] matrixTranspose(int[][] arr , int r , int c){
        // The Answer array will be of c * r size ;
        int[][] ans = new int[c][r];
        for (int i = 0 ; i < c ; i++){
            for (int j = 0 ; j < r ; j++){
                ans[i][j] = arr[j][i];
            }
        }
        return ans;
    }
    static void printArray(int[][] arr){
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void transposeInplace(int[][] mat , int r, int c ){
        // this method can be only used fro square matrix
        for (int i = 0 ; i < c ; i++){
            for (int j = i ; j < r ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i] ;
                mat[j][i] = temp ;
            }
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
//        int[][] TransMat = matrixTranspose(mat,r,c);
        transposeInplace(mat , r , c);
        System.out.println("Transposed Matrix :");
        printArray(mat);
    }
}
