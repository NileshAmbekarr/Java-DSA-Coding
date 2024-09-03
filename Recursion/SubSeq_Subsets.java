package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSeq_Subsets {

    static void ssq(int idx, int[] arr, int n, int[] nums){
        if(idx == n){
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[idx] = nums[idx];
        ssq(idx + 1, arr, n, nums);
        arr[idx] = 0;
        ssq(idx + 1, arr, n, nums);
    }
    static ArrayList<String> getSSQ(String s){
        // Created Arraylist for storing the answer
        ArrayList<String> ans = new ArrayList<>();
        // base case
        if (s.equals("")){
            ans.add("");
            return ans;
        }
        char curr = s.charAt(0);
        ArrayList<String> smallAns = getSSQ(s.substring(1));
        for (String ss : smallAns){
            ans.add(ss);
            ans.add(curr+ss);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<String> ans = getSSQ("abc");
        System.out.println(ans);
        int[] nums = {3, 1, 2};
        ssq(0, new int[nums.length], nums.length, nums  );
    }
}
