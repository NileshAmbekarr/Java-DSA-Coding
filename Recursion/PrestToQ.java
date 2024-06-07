package Recursion;

import java.util.Scanner;
// Given two numbers P & Q , find[ p^q ]
public class PrestToQ {
    static int power(int p , int q){
        if (q == 1) return p;
        if(q % 2 == 0){
            int pow = power(p, q/2);
            return pow*pow;
        }
        int pow = power(p , q/2);
        return pow*pow*p;

    }
    static int PowerToQ(int p, int q){
        // base case
        if (q == 1) return p;
        return p * PowerToQ(p,q-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers ");
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.print(p + " rest to the power "+ q + " is : ");
        System.out.println(power(p,q));
        System.out.println(PowerToQ(p,q));
    }
}
