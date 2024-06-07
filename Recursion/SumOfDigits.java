package Recursion;

import java.util.Scanner;

public class SumOfDigits {
    static int countDigits(int n ){
        if(n < 10 ) return 1;
        int count = 1 + countDigits(n/10);
        return count ;
    }
    static int sumOfDigits(int n ){
        if(n < 10 ){
            return n;
        }
        return n%10 + sumOfDigits(n/10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any Number :");
        int x = sc.nextInt();
        System.out.print("The sum of All Digits in the Number is : ");
        System.out.println(sumOfDigits(x));
        System.out.print("The total number of digits in the number is :");
        System.out.println(countDigits(x));
    }
}
