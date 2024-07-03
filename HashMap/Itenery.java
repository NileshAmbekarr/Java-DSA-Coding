package HashMap;

import java.util.HashMap;

public class Itenery { // Itinerary
    // we have to find the sequence of flights to reach the final destination

    public static String getStart(HashMap<String , String > tickets){
        HashMap<String, String> revMap = new HashMap<>();
        // Store all the values of tickets in revMap
        for (String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }
        // Using this loop, Search for the Unique key , that doesn't exist in the revMap
        for (String key: tickets.keySet()
             ) {
            if (!revMap.containsKey(key)){ // If the key doesn't exist , we got the starting point
                return key;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Delhi", "Goa");
        tickets.put("Goa", "Chennai");

        // first to find the starting point i.e., in this case is "Mumbai"
        String start = getStart(tickets);

        System.out.print( start);
        for (String key : tickets.keySet()){
            System.out.print("-> " + tickets.get(start));
            start = tickets.get(start);
        }


    }
}
