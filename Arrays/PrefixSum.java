package Arrays;

import Loops.Whileloop;

import java.util.Scanner;

public class PrefixSum {
    static boolean  equalSumPartition2(int[] arr ){
        // This method also works
        int n = arr.length ;
        int[] pref = makePrefixArray(arr);
        int totalSum = pref[n - 1]  ;
        for (int i = 0 ; i < n ; i++){
            if (totalSum - pref[i] == pref[i]){
                return true ;
            }
        }
        return false ;
    }
    static int findSum(int[] arr){
        int totalSum = 0 ;
        for (int i = 0 ; i < arr.length ; i++){
            totalSum += arr[i] ;
        }
        return totalSum ;
    }
    static boolean equalSumPartition(int[]  arr ){
        int totalSum = findSum(arr);
        int prefixSum = 0 , suffixSum = 0 ;
        for (int i = 0 ; i < arr.length ; i++){
            prefixSum += arr[i] ;
            suffixSum = totalSum - prefixSum;
            if (prefixSum == suffixSum)
                return true ;
        }
        return false;
    }
    static void PrintArray(int[] arr){
        for (int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    static int[] makePrefixArray(int[] arr){
        int n = arr.length ;
        int[] pref = new int[n];
        pref[0] = arr[0];
        for (int i = 1 ; i < n ; i++ ){
            pref[i] = pref[i-1] + arr[i];
        }
        return pref ;
    }
    static void MakePrefixArrayInplace(int[] arr){
        int n = arr.length ;
        for (int i = 1 ; i < n ;i++){
            arr[i] += arr[i-1];
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        System.out.println("Enter " + n + " Elements :");
        for (int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }
//        System.out.println("Input array :");
//        PrintArray(arr);
//        System.out.println("Prefix sum Array :");
//        MakePrefixArrayInplace(arr);
//        PrintArray(arr);
////        int[] pref = makePrefixArray(arr);
////        System.out.println("Prefix Sum Array ");
////        PrintArray(pref);
//        System.out.println("Enter no of Queries :");
//        int q = sc.nextInt();
//        int l , r;
//        while(q > 0){
//            System.out.println("Enter Range : ");
//            l = sc.nextInt();
//            r = sc.nextInt();
//            System.out.println("Answer is :" + (arr[r] - arr[l-1]) );
//            q--;
        System.out.println("Equal partition possible : " + equalSumPartition(arr));
        System.out.println("Equal partition possible by our method : " + equalSumPartition2(arr));

        }

    }

