package Arrays2D;

import java.util.Scanner;

public class SpiralOrder {
    static void printMatrix(int[][] arr){
        for (int i = 0 ; i< arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void spiralOrder(int[][] arr , int r , int c){
        int leftCol = 0 , rightCol = c-1 ;
        int topRow = 0 , bottomRow = r-1 ;
        int totalElements = 0 ;
        while(totalElements < r*c){
            for (int j = leftCol ; j <= rightCol && totalElements < r*c ; j++){
                System.out.print(arr[topRow][j]+ " ");
                totalElements++;
            }
            topRow++;
            for (int i = topRow ; i <= bottomRow && totalElements < r*c; i++){
                System.out.print(arr[i][rightCol]+" ");
                totalElements++;
            }
            rightCol--;
            for (int j = rightCol ; j >= leftCol && totalElements < r*c; j--){
                System.out.print(arr[bottomRow][j]+" ");
                totalElements++;
            }
            bottomRow--;
            for (int i = bottomRow ; i >= topRow && totalElements < r*c ; i--){
                System.out.print(arr[i][leftCol]+ " ");
            }
            leftCol++;

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows and columns af matrix ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        System.out.println("enter matrix elements : " + r*c + " Elements.");
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Your entered Matrix :");
        printMatrix(matrix);
        System.out.println("Spiral Order of Matrix :");
        spiralOrder(matrix , r , c);

    }
}
