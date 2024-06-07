package Recursion;

import java.util.Scanner;

public class FactorialOfN {
    static int fibonacci(int n ){
        // base case
        if(n==1 || n==2){
            return 1 ;
        }
        int fibonacci = fibonacci(n-1) + fibonacci(n-2);
        return fibonacci;
    }
    static int calculateSumOfN(int n ){
        // base case
        if (n == 1){
            return 1;
        }
        int sum = n + calculateSumOfN(n-1);
        return sum ;
    }
    static int calculateFactorial(int n ){
        //base case
        if (n == 1){
            return 1;
        }
        int fact =  n * calculateFactorial(n-1);

        return fact;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any number :");
        int n = sc.nextInt();
        System.out.println("Factorial od the number is " + calculateFactorial(n));
        System.out.println("The sum of first " + n + " Natural numbers is "+ calculateSumOfN(n));
        System.out.println("The " + n + "th" + " Fibonacci number is " + fibonacci(n));

    }
}
