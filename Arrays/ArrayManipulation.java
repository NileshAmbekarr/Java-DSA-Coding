package Arrays;

import java.util.Scanner;

public class ArrayManipulation {
    //For an array of integers return the first value that is repeating in the array
    static int RepeatingValue(int[] arr ){
        //int ans = -1 ;
        for (int i = 0 ; i < arr.length ; i++){
            for ( int j = i+1 ; j< arr.length ; j++){
                if (arr[i] == arr[j]){
                    return arr[i];
                    //ans = arr[i];
                   // break outer;
                }
            }

        }
        return -1 ;
    }
    
    //Program to find the second-largest element in the given array
    static int IntMax(int[] arr ){
        int max = Integer.MIN_VALUE ;
        for(int i= 0 ; i< arr.length ; i++){
            if (arr[i]> max)
                max = arr[i];
        }
        return max;
    }
    static int FindSecondMax(int[] arr){
        int mx = IntMax(arr);
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i]==mx ){
                arr[i] = Integer.MIN_VALUE;
            }
        }
        int SecondMax = IntMax(arr);
        return SecondMax ;
    }

    //Program to find a unique number in a given array
    static int UniqueNum(int[] arr ) {
        int ans = 0 ;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = -1;
                    arr[j] = -1;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                ans = arr[i];
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements os array ");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array Elemnts ");
         for(int i = 0 ; i < n ; i++ ){
             array[i] = sc.nextInt();
         }
//            int Ans = UniqueNum(array);
//            System.out.println("ans is "+ Ans );
//            int MaxNumber = IntMax(array);
//            System.out.println("The Largest number in the array is "+ MaxNumber);
//            int SecLargestN =  FindSecondMax(array);
        System.out.println("The repeating value on the array is " + RepeatingValue(array));
    }
}
