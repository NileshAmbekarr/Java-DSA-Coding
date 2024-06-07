package Sorting;

public class InsertionSort {
    static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            //i starts form 1 because we are considering that element at index 0 is already part of sorted array
            for (int j = i; j > 0; j--){
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {5,2,4, 3, 1, 6, 0};
        insertionSort(a);
        for (int val : a){
            System.out.print(a[val] + " ");
        }
    }
}
