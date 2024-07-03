package HashMap;

import java.util.HashSet;

public class UnionIntersection {
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 4, 5, 9};

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1
             ) {
            set.add(i);
        }

        for (int i : arr2
             ) {
            set.add(i);
        }

        System.out.println("Union of Both Arrays is " + set);
        System.out.println("Union elements => " + set.size());

        // TO FIND INTERSECTION
        set.clear();
        for (int i : arr1
             ) {
            set.add(i);
        }

        int count = 0;
        System.out.print("Intersection is => ");
        for (int i :arr2
             ) {
            if (set.contains(i)){
                count++;
                System.out.print(i + ", ");
                set.remove(i);
            }
        }
        System.out.println();
        System.out.println("Intersection Elements => "+ count);

    }
}
