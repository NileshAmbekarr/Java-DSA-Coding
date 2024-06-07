package Sorting;


public class MergeSort {

    // merge sorting , the approach of this method is to use recursion ,
    static void displayArray(int[] arr){ // method from printing array
        for (int val : arr){
            System.out.print(val + " ");
        }
    }

    static void merge(int[] arr, int l, int mid, int r){ // merging two arrays
        int n1 = mid- l+1;
        int n2 = r - mid;
        // creating two new arrays which will have sorted elements
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Adding values to the empty arrays [ left & right ]
        int i, j, k;
        for (i = 0; i < n1; i++ ) left[i] = arr[l + i];
        for (j = 0; j < n2; j++ ) right[j] = arr[mid + 1+j];
        // initialising values of i j & k for overriding the sorted values back to the arrays
        i = 0;
        j = 0;
        k = l;
        while(i < n1 && j < n2){
            if (left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
    }

    static void mergeSort(int[] arr, int l, int r){
        // base case
        if(l >= r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 5, 11, 6, 5, 8, 9, 24, 56, 23, 100, 96, 36};
        System.out.println("Array Before Sorting :");
        displayArray(arr);
        System.out.println();
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Array After Sorting :");
        displayArray(arr);

    }
}
