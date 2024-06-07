package Arrays;

import java.util.Scanner;

public class QueryQuestion {
    static int[] MakeFrequencyArray(int[] arr){
        int[] Freq = new int[100005];
        for (int i = 0 ; i < arr.length ; i++){
            Freq[arr[i]]++;
        }
        return Freq;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array Size ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements : ");
        for (int i = 0 ; i < n ; i++ ){
            arr[i] = sc.nextInt();
        }
        int[] Freq = MakeFrequencyArray(arr);
        System.out.println("Enter number of queries ");
        int q = sc.nextInt();
        while(q > 0 ){
            System.out.println("Enter element to search ");
            int x = sc.nextInt();
            if (Freq[x] > 0){
                System.out.println("YES !!");
            }
            else
                System.out.println("NO !!");
            q--;
        }
    }
}
