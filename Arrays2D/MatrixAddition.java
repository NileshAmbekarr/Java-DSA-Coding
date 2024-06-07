package Arrays2D;

import java.util.Scanner;

public class MatrixAddition {
    static void printArray(int[][] arr){
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    static int[][] addMatrix(int[][] arr1 , int[][] arr2 , int r , int c){
        int[][] ans = new int[r][c];
        for (int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c ; j++){
                ans[i][j] = arr1[i][j] + arr2[i][j] ;
            }
        }
        return ans ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Rows of Matrix :");
        int r = sc.nextInt();
        System.out.println("Enter no of columns of Matrix :");
        int c = sc.nextInt();
        int[][] mat1 = new int[r][c];
        int[][] mat2 = new int[r][c];
        System.out.println("Enter first matrix");
        for (int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c ; j++){
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter Second matrix :");
        for (int i = 0 ; i < r ; i++){
            for (int j = 0 ; j < c ; j++){
                mat2[i][j] = sc.nextInt();
            }
        }
        System.out.println("the Addition of the two Matrices is : ");
        int[][] ans = addMatrix(mat1, mat2,r,c);
        printArray(ans);


    }
}
