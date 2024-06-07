package Arrays;

import java.util.Scanner;

public class TwoPointers {
    static int[] reverseArray(int[] arr ){
        int n = arr.length ;
        int j = n-1  ;
        int[] ans = new int[n];
        for (int i = 0 ; i < n ; i++ ){
            ans[i] = arr[j--];
        }
        return ans ;
    }
    static void Swap(int[] arr , int a , int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp ;
    }
    static void PrintArray(int[] arr ){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    static void SortArrayZeroOne(int[] arr ){
        int n =arr.length;
        // first count the number of Zeroes in the array
        int count = 0 ;
        for (int i = 0 ; i < n ; i++){
            if (arr[i]==0 )
                 count++ ;
        }
        for (int i = 0 ; i< n ; i++ ){
            if(i< count )
                arr[i] = 0 ;
            else
                arr[i] = 1 ;

        }
        System.out.println("Array After Sorting :");
        PrintArray(arr);
    }
    static void InplaceSortZeroOne(int[] arr ){
        int n = arr.length;
        int left = 0 ;
        int right = n - 1 ;
        while (left < right ){
            if (arr[left]==1 && arr[right] == 0 ){
                Swap(arr,left,right);
                left++;
                right--;

            }
            if (arr[left] == 0 ) {
                left++;
            }
            if (arr[right] == 1 ) {
                right-- ;
            }


        }
        System.out.println("Array after Sorting ");
        PrintArray(arr);
    }
    static void SortEvenOdd(int[] arr ){
        int n = arr.length;
        int left = 0 , right = n-1 ;
        while(left< right ){
            // jr array chya left side la odd ani right side la even nuber asel tarach swap karne
            if (arr[left]%2==1 && arr[right]%2 == 0){
                Swap(arr , left , right );
                left++;
                right--;
            }
            //if there is already even number on left then left ko aage badhao
            if (arr[left] % 2 == 0 ) {
                left++;
            }
            // and if there is already odd number on right side then right ko aage badhao 
            if(arr[right] % 2 == 1 ) {
                right--;
            }
        }
    }
    static int[] SortSquares(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int left = 0 , right = n - 1 ;
        int k = n-1 ;
        while(left <= right ){
            if (Math.abs(arr[left ]) > Math.abs(arr[right])){
                ans[k--] = arr[left ] * arr[left];
                left++;
            }
            else{
                ans[k--] = arr[right]*arr[right];
                right--;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size" );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array Elements ");
        for (int i = 0 ; i < n ; i++ ){
            arr[i] = sc.nextInt();
        } // Scanning Array elements
        System.out.println("Original Array :");
        PrintArray(arr);
        int[] ans = SortSquares(arr);
        System.out.println("Sorted Array :");
//        ans = reverseArray(ans);
        PrintArray(ans );
//        SortEvenOdd(arr);
//        PrintArray(arr);
//        InplaceSortZeroOne(arr);
//        PrintArray(arr);
//        SortArrayZeroOne(arr );
//        PrintArray(ans);
    }

}
