package HashMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HASHSET {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Pune");
        cities.add("Delhi");
        cities.add("Chikhli");
        cities.add("Mumbai");
        System.out.println(cities+ " <= Random Order / Default Order");

//        // How to iterate on a HashSet ?
//        // 1. Using Iterator
//        Iterator<String> it = cities.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next() + " ");
//        }
//        System.out.println();
//        // 2. Using Enhanced for / foreach loop
//
//        for (String city: cities
//             ) {
//            System.out.print(city + " ");
//        }


        // Linked HashSet => They store the elements in sequentially as they are stored
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Pune");
        lhs.add("Delhi");
        lhs.add("Chikhli");
        lhs.add("Mumbai");
        System.out.println(lhs + " <= Sequential Order");

        // TREE SET => They store the elements in sorted order, by Default ascending order
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Pune");
        ts.add("Delhi");
        ts.add("Chikhli");
        ts.add("Mumbai");
        System.out.println(ts + " <= Sorted Order");






    }
}
