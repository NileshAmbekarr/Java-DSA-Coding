package Queues;
import java.util.*;
public class QueueUsingLL {
    static class Node{
        static int data;
        static Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

//    static class Queue{
//        public static Node head;
//        public static Node tail;
//        public static boolean isEmpty(){
//            return head == null && tail == null;
//        }
//
//        public static void add(int data){
//            Node newNode = new Node(data);
//            if(isEmpty()){
//                head = tail = newNode;
//                return;
//            }
//            tail.next = newNode;
//            tail = newNode;
//        }
//        public static int remove(){
//            if (isEmpty()){
//                System.out.println("Empty QUEUE");
//                return -1;
//            }
//            int result = head.data;
//            if (head == tail){
//                head = tail = null;
//            }else {
//                head = head.next;
//            }
//            return result;
//        }
//        public static int peek(){
//            if (isEmpty()) return -1;
//            return head.data;
//        }
//    }

    public static void main(String[] args) {
//        Queue q = new Queue();
        Queue<Integer> q = new LinkedList<>(); // implementation of QUEUE using Java Collections Framework.
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
