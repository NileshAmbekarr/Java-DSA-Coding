package Sorting;

public class QuickSort {
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    static void swap (int[] arr, int i , int j ){
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void partition(int[] arr, int st, int end){
        
    }
    static void quickSort(int[] arr, int st, int end){
        if (st>= end) return; // base case
        int pivot = arr[st];
        partition(arr, st, end);
        quickSort(arr, st, pivot-1);
        quickSort(arr, pivot+1, end);

    }
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 2};
        System.out.println("Array before sorting ");
        printArray(arr);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}
