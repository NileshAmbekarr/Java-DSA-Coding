package Recursion;

import java.util.Scanner;
import java.util.*;
public class GCD {
    // EUCLIDS Algorithm
    static int findGCD3(int x , int y){
        if (y == 0) return x ;
        return findGCD3(y , x % y);
    }
    static int findGCD2(int x , int y ){
        while(x % y != 0){
            int rem = x % y ;
            x = y;
            y =rem;
        }
        return y ;
    }
    static int findGCD(int x , int y){
        int t  = Math.min(x , y );
        for (int i = t ; i > 0 ; i--){
            if (x % i == 0 && y % i == 0){
                return i;
            }

        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two Numbers :");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int gcd = findGCD3(x,y );
        System.out.println(gcd);
    }

}
