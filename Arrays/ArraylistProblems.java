package Arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections; // Collections class has many inbuilt functions to manipulate the Arraylist
public class ArraylistProblems {
    static void reverseArraylist(ArrayList<Integer> list){
        int i = 0 , j = list.size() - 1;
        while(i < j){ // Swapping two elements of the List
           Integer temp = Integer.valueOf(list.get(i));
           list.set(i, list.get(j)); //Giving value of list.j to => list.i .
           list.set(j, temp);
           i++;
           j--;
        }
    }
    public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(5);
            list.add(3);
            list.add(8);
            list.add(4);
            list.add(9);
            list.add(7);
            System.out.println("Original List " + list);
            Collections.reverse(list);
            //reverseArraylist(list);
            System.out.println("Reversed List "+  list);
            // Sorting The list in Ascending Order
            Collections.sort(list);
        System.out.println("Ascending Order "+ list );
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Descending Order " + list );
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("Amol");
        l1.add("Lalit");
        l1.add("Rohan ");
        l1.add("Pankaj");
        l1.add("Aadesh");
        l1.add("Pravin");
        System.out.println("Original List :"+ l1);
        Collections.sort(l1);
        System.out.println("Sorted List : " + l1);

    }
}
