package Arrays;

import java.util.Scanner;

public class GroupsDSandGT {
    static void Print2DArray(int[][] arr){
        for (int i = 0 ; i < arr.length ; i++ ){
            for (int j = 0 ; j< arr.length ; j ++ ){
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();

        }
    }
    static void PrintArray(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in group ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println(" Enter Array Elements :");
        for (int i = 0 ;i < n ; i++){
            arr[i] = i ;
        }
        System.out.println("Input Array :");
        PrintArray(arr);
        int[][] AddAns = new int[n][n];
        for (int i = 0 ; i< n ; i++){
            for (int j = 0 ; j < n ; j++){
                if (arr[i]+arr[j] < n) {
                    AddAns[i][j] = arr[i] + arr[j];
                }
                else
                    AddAns[i][j] = (arr[i] + arr[j]) % n ;
            }
        }
        System.out.println("Printing Addition Group :  ");
        Print2DArray(AddAns);
        int[][] MULArray = new int[n][n];
        for (int i = 0 ; i< n ; i++){
            for (int j = 0 ; j < n ; j++){
                if (i * j < n) {
                    MULArray[i][j] = i * j;
                }
                else
                    MULArray[i][j] = (i * j) % n ;
            }
        }
        System.out.println("Printing Multiplication Group :");
        Print2DArray(MULArray);


    }
}
