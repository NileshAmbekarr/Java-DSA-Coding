package Recursion;

import java.util.Scanner;

public class ArraysRecursoin {
    static int searchElementIndex(int[] arr, int target, int idx){
        if (idx >= arr.length) return target  ;
        if (arr[idx] == target) return idx;
        else return searchElementIndex(arr, target, idx + 1 );
    }
    static boolean searchElement(int[] arr , int target, int idx  ){
        if (idx >= arr.length) return false ;
        if (arr[idx] == target) return true;
        else return searchElement(arr, target, idx + 1 );
    }
    static boolean arraySortedOrNot(int[] arr , int idx){
        if(idx == arr.length-1) return true;
        if (arr[idx] < arr[idx + 1] ) return arraySortedOrNot(arr, idx +1) ;
        else return false ;
    }
    static int sumOfArray(int[] arr , int idx ){
        if (idx== arr.length-1) return arr[idx];
        return arr[idx] + sumOfArray(arr, idx + 1);
    }
    static int findMinElement(int[] arr , int idx ){
        if (idx == arr.length-1) return arr[idx];
        int min = findMinElement(arr , idx + 1);
        if(arr[idx] < min) return arr[idx];
        return min;
    }
    static int findMaxElement(int[] arr , int idx ){
        // base case
        if (idx == arr.length-1){
            return arr[idx];
        }
        int maxElement = findMaxElement(arr , idx + 1);
        if (arr[idx] > maxElement ) return arr[idx];
        return maxElement;
    }
    static void printArray(int[] arr , int idx){
        // base case
        if (idx == arr.length ) return ;
        System.out.print(arr[idx] + " ");
        printArray(arr , idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] Array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printArray(Array, 0);
        System.out.println();
        System.out.print("Greatest Element In the Array : ");
        System.out.println(findMaxElement(Array, 0));
        System.out.print("Smallest Element Of the Array : ");
        System.out.println(findMinElement(Array, 0));
        System.out.print("sum Of Array : ");
        System.out.println(sumOfArray(Array , 0));
        System.out.println("The array is Sorted : " + arraySortedOrNot(Array , 0));
        System.out.print("Enter any Number to search In the array :");
        int target = sc.nextInt();
        if (searchElement(Array,target, 0)) System.out.println("The number " + target + " is present in the array ");
        else System.out.println("The number " + target + " is not present in the array ");
        int result = searchElementIndex(Array, target, 0);
        if(result == target ) System.out.println("The number is not present !!");
        else System.out.println("The number is present at the index " + result );


    }
}
