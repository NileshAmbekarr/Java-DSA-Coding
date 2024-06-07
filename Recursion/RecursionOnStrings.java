package Recursion;

import java.util.Scanner;

public class RecursionOnStrings {

    static boolean palindromeOrNot(String s, int idx, int right  ){
        if (idx >= right){
            return true ;
        }
        if (s.charAt(idx) == s.charAt(right)){
            palindromeOrNot(s,idx+1, right-1);
            return true;
        }
       else return false ;
    }

    static String reverseString(String s, int idx ){
        if (idx >= s.length()) return "";
        String ans = reverseString(s, idx+1) + s.charAt(idx);
        return ans;
    }

    // Remove occurrences of char 'a' from string
    static String removeCharacters(String s , char a, int idx){
        if (idx >=s.length()){
            return "";
        }
        String smallAns = removeCharacters(s, a, idx+1);
        char curr = s.charAt(idx);
        if(curr != a) {
            return curr + smallAns;
        }
        else return smallAns;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String ");
        String s = sc.nextLine();
        String ans = removeCharacters(s, 'a', 0);
        System.out.println(ans);
//        String rev = reverseString(s, 0);
//        System.out.println(rev);
//        if (rev.equals(s)){
//            System.out.printf("%s is Palindrome ", s);
//        }
//        else System.out.printf("%s is not a Palindrome ", s);
//        // checking palindrome or not without reversing the string
//        if (palindromeOrNot(s,0,s.length()-1)){
//            System.out.println("It is Palindrome ");
//        } else System.out.println("Not a palindrome ");
    }
}
