package Arrays;

import java.util.Scanner;


public class TargetSum {

    static int TripleSum(int[] arr , int target ){
       // Program to count the number of triplets whose sum is equal to the given value x
        int ans = 0 ;
        int n = arr.length ;
        for(int i = 0 ; i < n-1 ; i++){
            for (int j = i + 1 ; j < n-1 ; j++){
                for (int k = j+ 1 ; k < n ; k++ ){
                    if (arr[i]+arr[j]+arr[k]==target){
                        ans++;
                    }
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        // Program to find the total number of pairs in the arrays whose sum is equal to the given value x

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array ");
        int n = sc.nextInt();
        System.out.println("Enter The array Elements ");
        int[] array = new int[n];
        for (int i = 0 ; i < array.length ; i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Enter target sum");
        int targetSum = sc.nextInt();
//        int ans = 0 ;
//        for(int i = 0 ; i < array.length - 1 ; i++){
//            for (int j = i+1 ; j< array.length ; j++){
//                if ( array[i] + array[j] == targetSum){
//                    ans++;
//                }
//            }
//        }
//        System.out.println("answer is "+ ans );


        int TripleSumAns = TripleSum( array , targetSum );
        System.out.println( "answer is " + TripleSumAns);


    }
}
