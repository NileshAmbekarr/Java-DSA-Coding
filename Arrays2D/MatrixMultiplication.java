package Arrays2D;
import java.util.Scanner;

public class MatrixMultiplication {
    static void multiply(int[][] a , int r1, int c1 , int[][] b , int r2 , int c2 ){
        if (r1 != c2 ){
            System.out.println("The multiplication is not Possible !! : WRONG INPUT ");
            return;
        }
        int[][] mul  = new int[r1][c2];
        for (int i = 0 ; i < r1 ; i++){
            for (int j = 0 ; j < c2 ; j++){
                for (int k = 0 ; k < c1 ; k++){
                    mul[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("The multiplication of MAtrices is : ");
        printArray(mul);
    }
    static void printArray(int[][] arr){
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Rows & columns of 1st Matrix :");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] mat1 = new int[r1][c1];
        System.out.println("Enter first matrix");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter no of Rows & columns of 2nd Matrix :");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] mat2 = new int[r2][c2];
        System.out.println("Enter first matrix");
        for (int i = 0 ; i < r2 ; i++){
            for (int j = 0 ; j < c2 ; j++){
                mat2[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix 1 :");
        printArray(mat1);
        System.out.println("matrix 2 :");
        printArray(mat2);

        multiply(mat1, r1,c1,mat2,r2,c2);

    }
}