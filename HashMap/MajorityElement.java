package HashMap;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 1, 3, 2, 5, 1, 3, 1};

        // Our task is to find the all the elements in the array which appear more than 3 times

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num) + 1);
            }else {
                hm.put(num, 1);
            }
        }


    }
}

