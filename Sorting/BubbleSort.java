package Sorting;

public class BubbleSort {
    static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void sortArray(int[] arr){
        int n = arr.length;
        //Outer loop for iterations
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            // Inner loop for checking condition
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // Swapping two numbers if one > two
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag  = true;
                }
            }
            if (!flag) {
                break; // Flag for checking the array is sorted or not After every iteration
            }
        }
        PrintArray(arr);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 7};
        sortArray(arr);

    }
}
