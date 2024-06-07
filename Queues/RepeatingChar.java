package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class RepeatingChar {

    public static void repeatingChar(String str){
        int[] freq = new int[26]; // for storing the frequencies of each character
        Queue<Character> q= new LinkedList<>();

        for (int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ ch - 'a']++;
            while(!q.isEmpty() && freq[ q.peek() - 'a'] > 1){
                q.remove();
            }
            if (q.isEmpty()){
                System.out.println( -1 + " ");
            }else{
                System.out.println(q.peek());
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        

    }
}
