package Heaps;

import java.util.PriorityQueue;

public class SlidingWindow {
    public static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val , int idx){
            this.val = val ;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            // ascending => return this.val - p2.val;
            // we have to sort in descending order so..
            return p2.val - this.val;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = new int[arr.length - k + 1];

        // priority queue for Storing pairs
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // add first k elements
        for (int i = 0; i < k ; i++){
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val; // store the largest of the first window un the res array

        for (int i = k; i < arr.length ; i++){ // processing further elements
            while(pq.size() > 0 && pq.peek().idx <= i-k){
                pq.remove();
                // removing the elements which are not in the current window , that is... the elements with index equal to or less than i-k
                // i > current index , k > window size
            }
            pq.add(new Pair(arr[i], i)); // add the current element in the PQueue
            res[i-k+1] = pq.peek().val; // as the elements are sorted in the descending order , peek the largest (first) element form the PQueue add it to 'res'
        }

        for (int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
