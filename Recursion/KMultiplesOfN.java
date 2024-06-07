package Recursion;

import java.util.Scanner;

public class KMultiplesOfN {
    static void kMultiples(int k , int n ){
        // base case
        if(k == 1){
            System.out.println(n );
            return;
        }
        kMultiples(k-1 , n);
        System.out.println(n * k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two Numbers ");
        int k = sc.nextInt();
        int n = sc.nextInt();
        kMultiples(k,n);
    }
}
