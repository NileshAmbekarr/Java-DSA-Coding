package Recursion;

import java.util.ArrayList;

public class SubSeq_Subsets {
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
    }
}
