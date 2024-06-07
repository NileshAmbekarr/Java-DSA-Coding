package Recursion;
import java.util.ArrayList;
import java.util.Collections;
public class FindAllIndices {
    static void findFirstIndex(int[] arr , int idx , int target ){
        if (idx >= arr.length) {
            System.out.println("Number not Found ");
            return ;
        }
        if (arr[idx] == target ){
            System.out.println("First index is " + idx);
            return ;
        }
        findFirstIndex(arr,idx+1, target);
    }
    static void findLastIndex(int[] arr, int idx, int target ){
        if (idx <= 0) {
            System.out.println("Number not found ");
            return;
        }
        if (arr[idx] == target) {
            System.out.println("Last index found of " + target + " at index " + idx);
            return;
        }

        findLastIndex(arr, idx-1, target);
    }
    static ArrayList<Integer> allIndices(int[] arr , int idx , int target , ArrayList<Integer> list){
        if (idx >= arr.length) return null;
        if (arr[idx] == target ) list.add(idx);
        allIndices(arr,idx+1, target, list);
        return list;
    }
    static void findAllIndices(int[] arr , int idx, int target  ){
        if (idx >= arr.length) return;
        if (arr[idx] == target) {
            System.out.print(idx + " ");
        }
        findAllIndices(arr, idx+1, target);
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 5, 6, 5, 8, 9};
        findAllIndices(array, 0, 5);
        ArrayList<Integer> list = allIndices(array,0,5,new ArrayList<>());
        System.out.println();
        System.out.println(list);
        findLastIndex(array , array.length -1, 5);
        findFirstIndex(array , 0 , 5);
    }
}
