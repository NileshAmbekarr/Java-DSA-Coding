package HashMap;

import java.util.HashMap;

public class LargestSubArray {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 3, -3, 7, 10};
        HashMap<Integer, Integer> map = new HashMap<>(); // sum , idx

        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j- map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        System.out.println("The length of Largest SubArray of sum 0 is =>" + len);

    }
}
