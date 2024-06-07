package Heaps;
import java.util.*;
public class Classroom {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data); // add the element to the last position

            int x = arr.size() -1 ;// child node
            int par = (x - 1) / 2; // parent element

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        private void heapify(int i) { // Time Complexity = O(logN)
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }
            if (minIdx != i){
                // swap minIdx & i
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            // get data of min Element i.e, first element
            int data = arr.get(0);

            // swap first and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);

            // delete last node
            arr.remove(arr.size()-1 );

            // call heapify
            heapify(0);
            return data;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(2);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
