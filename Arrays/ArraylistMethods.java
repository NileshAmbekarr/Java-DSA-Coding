package Arrays;

import java.util.ArrayList;

public class ArraylistMethods {
    public static void main(String[] args) {
        //Wrapper class
//        Integer i = Integer.valueOf(4);
//        System.out.println(i);
//        Float f = Float.valueOf(5.6f);
//        System.out.println(f);
        ArrayList<Integer> l1 = new ArrayList<>();
        // add new element
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);
        //get an element for arraylist
        System.out.println(l1.get(0)); //6

        // Print with for loop arraylist
//        for (int i =0 ; i < l1.size(); i++ ){
//            System.out.print(l1.get(i)+ "  ");
//        }
//        System.out.println();

        // But we can print the Arraylist Directly without For loop
        System.out.println(l1);

        // adding some element at some index //[5 100 6 7 8 ]
        l1.add(1,100);
        System.out.println(l1);

        // changing value or modifying value of any element
        l1.set(1,10);
        System.out.println(l1);

        // removing element of arraylist at index i
        l1.remove(1);
        System.out.println(l1);

        // removing an element
        l1.remove(Integer.valueOf(7));
        System.out.println(l1);

        // Checking if an element exist in the arraylist
        boolean ans = l1.contains(Integer.valueOf(8));
        System.out.println("Element 8 Exist in the Arraylist :" + ans );
    }

}
