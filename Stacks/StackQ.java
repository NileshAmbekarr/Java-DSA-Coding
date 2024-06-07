package Stacks;
import java.util.Arrays;
import java.util.Stack;
public class StackQ {
    public static void pushAtBottom(Stack<Integer> s, int data){
        // base case
        if (s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();
        int idx = 0;
        while(idx < str.length()) {
            st.push(str.charAt(idx));
            idx++;
        }
        String result = new String("");
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);
        pushAtBottom(st, top);
    }
    public static void findSpan(int[] stocks, int[] span){
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for(int i = 1; i < stocks.length; i++){
            int currPrice = stocks[i];
            while(!st.isEmpty() && currPrice > stocks[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i] = i + 1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }

    }
    public static int[] nextGreater(int[] arr){
        // firstly we need a Stack
        Stack<Integer> st = new Stack<>();
        // A nextGreater Array which we will return after the execution
        int[] nextGreater = new int[arr.length];

        // iterate on the array in backward
        for(int i = arr.length - 1; i >= 0; i--){
            int currVal = arr[i];
            // jab-tak we don't find a value greater than the currValue , we will keep pop() ing the stack
            while(!st.isEmpty() && currVal >= st.peek() ){
                st.pop();
            }
            // if the stack is empty till now, means there is no greater element on the right side of  array
            if (st.isEmpty()){
                nextGreater[i] = -1; // so put the value -1 ;
            }else{
                nextGreater[i] = st.peek(); // nextGreater element found , so put that value in the result array
            }
            st.push(currVal); // push the curr Element on the stack for next iterations ;
        }
        return nextGreater;
    }
    public static void main(String[] args) {
//        /* Implementation of Stack Using Java Collections Framework */
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//
//        System.out.println(st);
//        reverseStack(st);
//        System.out.println(st);
        //
//        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
//        int[] span = new int[stocks.length];
//        findSpan(stocks, span);
//        for(int i = 0; i < span.length; i++){
//            System.out.print(span[i] + " ");
//        }
    int[] arr = {6, 8, 0, 1, 3};
    System.out.println(Arrays.toString(nextGreater(arr)));

    }
}
