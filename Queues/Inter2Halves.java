package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Inter2Halves {
    public static void main(String[] args) {
        Queue<Integer>  q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println(q.size());
        System.out.println(q);
        int size = q.size();
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 1; i <= size/2; i++){
            temp.add(q.remove());
        }
        System.out.println(temp);
        System.out.println(q);
        while(!temp.isEmpty()){
            q.add(temp.remove());
            q.add(q.remove());
        }

        System.out.println("Two halves interleaved : " + q);
    }
}
