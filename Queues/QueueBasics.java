package Queues;

public class QueueBasics {
    static class Queue{
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        Queue(int size){
            arr = new int[size];
            Queue.size = size;
            rear = -1 ;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1)% size == front;
        }

        // add
        public static void add(int n){
            if(isFull() ){
                System.out.println("Queue is full !");
                return;
            }
            if (front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = n;
        }

        // remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty !!");
                return -1;
            }
            int frontVar = arr[front];
            if (front == rear){ // in case of removing the last element, the queue will be empty.
                front = rear = -1;
            }else{
                front = (front + 1)% size;
            }

            return frontVar;
        }
        public static int peek() {
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
