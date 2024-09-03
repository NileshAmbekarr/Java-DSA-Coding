package Arrays;

import java.util.Scanner;

public class MiscProblems {
    static int[] ReverseArray(int[] arr ){
        int n = arr.length ;
        int[] ans = new int[n];
        int j = 0 ;
        for(int i = n - 1 ; i >= 0 ; i--){
            ans[j++] = arr[i] ;
        }
        return ans;


    }
    static void PrintArray(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    static void swapWithoutTemp(int a , int b ){
        System.out.println("original values a : "+ a+ " b : "+ b );
        a = a+b ;
        b = a-b ;
        a = a-b ;
        System.out.println("After Swapping values");
        System.out.println(a + " : " + b);
    }
    static void swap(int a, int b ){
        System.out.println("original values befpre swap : a = " + a + " b = " + b);
        int Temp = a ;
        a = b ;
        b = Temp ;
        System.out.println("After Swapping values");
        System.out.println(a + " : " + b);

    }
    static void swapInArray(int[] arr ,int i , int j ){
        int Temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = Temp ;
    }
    static void InplaceRevArray(int[] arr, int i , int j ){ // without creating additional array
        while(i < j ){
            swapInArray(arr , i , j );
            i++;
            j--;
        }
    }
    static int[] RotateArray(int[] arr , int k ){
        int n = arr.length ;
        k = k % n ;
        int[] ans = new int[n];
        int j = 0 ;

        for (int i = n-k ; i<n ; i++){
            ans[j++] = arr[i];
        }
        for(int i = 0 ; i < n - k ;i++){
            ans[j++] = arr[i];
        }
        return ans ;

    }
    static void rotateInplace(int[] arr , int k ){
        int n = arr.length ;
        k = k % n ;
        InplaceRevArray(arr, 0 , n-k-1);
        InplaceRevArray(arr , n-k , n-1 );
        InplaceRevArray(arr , 0 , n-1 );

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 9 ;
        int b = 3;
        int[] arr = {1, 2, 3, 4, 5, 6,7};
        System.out.print("enter number if rotations ");
        int k = sc.nextInt();
        System.out.print("Original Array :");
        PrintArray(arr);
        System.out.print("Array After Rotation :");
 //       int[] ans = RotateArray(arr, k );
        rotateInplace( arr , k );
        PrintArray(arr );
//        InplaceRevArray(arr);

        PrintArray(arr);
       // swap(a,b);
       // swapWithoutTemp( a, b );
    }
}
