package Sorting;

public class moveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 0, 1, 0, 3, 10, 0, 5, 0};
        int n = arr.length;

        for (int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < n - i - 1 ; j++){
                if (arr[j] == 0 && arr[j+1] != 0){
                    // Swap arr[j] & arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
       for (int i = 0 ; i < n ; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}
