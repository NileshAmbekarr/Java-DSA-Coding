package HashMap;
import java.util.*;
public class Classroom {
    public static void main(String[] args) {
        // HashMap is a data Structure which contains various nodes which contain a key and a value
        // The nodes are stored randomly in the map
        HashMap<String, Integer> hm = new HashMap<>();

        // HashMap has mainly four functions
        // 1. put   2. get  3. contains  4. remove

        // how to store a key value pair in the hashmap
        hm.put("India", 100);
        hm.put("USA", 90);
        hm.put("China", 150);
        hm.put("Indonesia", 5);
        hm.put("Nepal", 10);
        hm.put("UK", 100);
//        // how to get an element from the Hashmap, or the value of the element
//        System.out.println(hm.get("USA"));
//
//        // how to check if some key exist in the map <= returns true if contains else returns null
//        System.out.println(hm.containsKey("India"));
//
//        // printing hashmap ==> elements in the hashmap are unordered , they are stored randomly in the hashmap
//        System.out.println(hm);
//
//        // removing an element from the hashmap
//        hm.remove("China");
//        System.out.println(hm);
//
//        // some other functions are
//        System.out.println(hm.size());
//        hm.clear();  // This function clears all the elements from the hashmap
//        System.out.println(hm.isEmpty());
//
//        // All this functions of Hashmap, they require constant time =>  O(1);

        // Iteration in Hashmap
        // As we cannot directly perform iteration on hashmap . we use a data structure called SET , we extract all the keys of the hashmap into the set and then iterate over it

        Set<String> keys = hm.keySet();
        int max = 0;
        for (String k: keys
             ) {
            if(hm.get(k) > max){
                max = hm.get(k);
            }
            System.out.println("key -> " + k + ", value ->" + hm.get(k));
        }

        System.out.println(max + " is the highest number of population");

    }
}
