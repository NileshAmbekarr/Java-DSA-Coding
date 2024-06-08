package Heaps;

public class HeapSort {
    // implement heapify for maxHeap
    public static void heapify(int[] arr, int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int[] arr){
        // Build maxHeap ( for ascending order )
        int n = arr.length;
        for (int i = n/2 ; i >= 0 ; i--){
            heapify(arr, i, n);
        }

        // push the largest at the end
        for(int i = n-1 ; i>0 ; i--){
            // swap the largest (first) element with last element
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr,0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3,2, 5};

        heapSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    // for ascending order sorting => build maxHeap
    // for descending order sorting => build minHeap

    // step 1 >> build maxHeap or minHeap
    // step 2 >> swap the first element with the last element and reconstruct the Heap

    // how 'heapify' function works ?
    // ===>>> 1. An array , the root , size are passed to the function
    //        2. first find the roots left right elements.
    //        3. find the Max element or min element among those three
    //        4. if found , swap with the root
    //        5. call heapify again for the maxIdx
}
