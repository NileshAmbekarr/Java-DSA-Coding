package Stacks;
import java.util.Stack;
public class InfixToPostfix {
    public static String toPostFIx(String infix){
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++){
            if (infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '/' || infix.charAt(i) == '*'
                    || infix.charAt(i) == '('){
                st.push(infix.charAt(i));
            }else if(infix.charAt(i) == ')'){
                while(st.peek() != '('){
                    postfix.append(st.peek());
                    st.pop();
                }
                st.pop();
            }else{
                postfix.append(infix.charAt(i));
            }

        }
        while(!st.isEmpty()){
            postfix.append(st.peek());
            st.pop();
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        String infix = "A+B+C";
        System.out.println(toPostFIx(infix));
    }
}
