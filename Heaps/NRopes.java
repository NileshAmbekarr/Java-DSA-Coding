package Heaps;

import java.util.PriorityQueue;

public class NRopes {
    // Given are n ropes with the different lengths , the task is to join these ropes with one rope with
    // minimum costs such that the cost to connect two ropes is equal to their sum of lengths
    public static void main(String[] args) {
        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length ; i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1){
            int min = pq.remove();
            int min2 = pq.remove();

            cost += min + min2;
            pq.add(min+min2);
        }

        System.out.println("The total cost to join the Ropes is " + cost);
    }
}
