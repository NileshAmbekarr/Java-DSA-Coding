package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String str){
        Stack<Character> st = new Stack<>();
        // traverse on each character
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{'){
                st.push(ch);
            }
            else{
                if (st.isEmpty()) {
                    return false;
                }
                if((        st.peek() == '(' && ch == ')')
                        || (st.peek() == '[' && ch == ']')
                        || (st.peek() == '{' && ch == '}')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String str = "{}[]({}))";
        System.out.println(isValid(str));
    }
}
