package HashMap;

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,8, 6,7, 4, 3, 2, 1, 6, 9};
        // The best data structure we can use for this problem is SET, because it stores an element only once
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            ans.add(arr[i]);
        }

        System.out.println("ans = "+ ans.size());
    }
}
