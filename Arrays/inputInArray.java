package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class inputInArray {
    static void changeArray(int[] arr){
        for (int i = 0 ; i < arr.length ; i++ ){
            arr[i] = 0 ;
        }
    }
    static void PrintArray(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");

        }
        System.out.println();
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
//        Array Input
        System.out.println("Enter number of elements of Array");
        int n = sc.nextInt();
        int[] Arr = new int[5];
        for (int i = 0 ; i < Arr.length ; i++){
            Arr[i] = sc.nextInt();
        }
//        Array Reference
        int[] Arr2 = Arrays.copyOf(Arr , 2);
        System.out.println("Elements of the Array");
        System.out.println("Original Array");
        PrintArray(Arr);
        System.out.println("Copied Array");
        PrintArray(Arr2);
        Arr2[0] = 7;
        System.out.println("original Array after changing value");
        PrintArray(Arr);
        System.out.println("Copied Array after CHanging Value ");
        PrintArray(Arr2);
//        both the first values of both arrays changed by changing only in one array

        // CHANGING ARRAY =>
        changeArray(Arr2);
        PrintArray(Arr);
        PrintArray(Arr2);

    }
}
