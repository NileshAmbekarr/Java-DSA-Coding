package Tries;

import java.util.Arrays;

public class Classroom {
    static class Node {
        Node children[]= new Node[26];
        boolean eow = false ; // end of word

        public Node(){
            Arrays.fill(children, null);  // instead of using for loop , we performed the same action by using this method
        }
    }
    public static Node root = new Node();
    public static void insert(String word){  // Time Complexity = O(L) => The word length which is to be inserted \
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static boolean search(String key){
        Node curr = root;
        for (int level = 0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow ;
    }
    public static boolean breakString(String key){
        if(key.length() == 0){
            return true;
        }
        for (int i = 1; i < key.length(); i++){
            if(search(key.substring(0, i)) &&
                breakString(key.substring(i))){
                return true;
            };
        }
        return false;
    }
    public static void main(String[] args) {
        String[] words = {"the", "there", "thee", "a", "any", "their", "amo"};
        for (String word : words) {
            insert(word);
        }

        System.out.println(search("there"));
        System.out.println(search("amo"));
        System.out.println(search("th"));

    }
}
