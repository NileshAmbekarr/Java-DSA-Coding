package Sorting;

public class SelectionSort {
   static void sortArray(int[] arr ) {
       int n = arr.length ;

       for (int i = 0; i < n - 1; i++) {
           int minIndex = i;
           for (int j = i + 1; j < n ; j++) {
               if (arr[j] < arr[minIndex]) {
                   minIndex = j;
               }
               if (minIndex != i) {
                   int temp = arr[i];
                   arr[i] = arr[minIndex];
                   arr[minIndex] = temp;
               }
           }
       }
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
       }
   }
    public static void main(String[] args) {
        int[] array = {7, 4, 3, 5 , 1, 8, 4, 9, 2,9 ,19};
        sortArray(array);
        //DO DRY RUN >>>>
    }
}
