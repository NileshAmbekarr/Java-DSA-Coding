package Stacks;

import java.util.ArrayList;

public class StackBasics { // This class Contains Basic implementation of Stack Using arrayList and LinkedList
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class StackA {
        static Node head = null;
        // implementing STACK using LINKEDLIST
        public static boolean isEmpty(){
            return head == null; // if the head is null , Stack is empty.
        }
         public static void push(int data){
            if(isEmpty()){
                head = new Node(data);
            }else {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            }
         }

         public static int pop(){
             int var = head.data;
             if(isEmpty()){
                return -1;
            }
            head = head.next;
            return var;
         }
         public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return head.data;
         }
    }
        public static class StackLL {
        static ArrayList<Integer> list = new ArrayList<>();

        // implementing stack methods
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if (isEmpty()) return -1;             // return -1 if stack empty
            int top = list.get(list.size() - 1);   // store top
            list.remove(list.size() -1);     // remove top
            return top;
        }

        public static int peek(){
            if (isEmpty()) return -1;
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        StackA st = new StackA();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
