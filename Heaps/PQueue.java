package Heaps;
import java.util.Comparator;
import java.util.PriorityQueue;
public class PQueue {
    static class Student implements Comparable<Student>{
        // class get ability to compare its two objects after this
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        // Since the class implements the Interface Comparable , It should implement the absract function CompareTo()
        // Compulsory to implement function after implementing Interface
        public int compareTo(Student S2){
            return this.rank - S2.rank;
        }
    }
    public static void main(String[] args) {
//        PriorityQueue<> pq = new PriorityQueue<>();
//        pq.add(1); // add function takes O(logn) time
//        pq.add(6);
//        pq.add(3);
//        pq.add(2);
//
//        while(!pq.isEmpty()){
//            System.out.print(pq.peek() + " "); // O(1)
//            pq.remove(); // O(logn)
//        }
        PriorityQueue<Student> pq = new PriorityQueue<>();
        // "Comparator.reverseOrder()" function can be used to make the PQueue work in the reverse order
        pq.add(new Student("T", 6));
        pq.add(new Student("H", 2));
        pq.add(new Student("C", 1));
        pq.add(new Student("U", 3));
        pq.add(new Student("Y", 15));
        pq.add(new Student("A", 23));
        pq.add(new Student("I", 12));



        while (!pq.isEmpty()){
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }

    }
}
