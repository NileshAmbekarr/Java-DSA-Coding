package Recursion;

import java.util.Scanner;

public class PrintNumbers {
//     Printing numbers n to 1
    static void printNto1(int n ){
        // base case
        if (n == 1 ){
            System.out.println(n);
            return ;
        }
        System.out.print(n + " ");
        printNto1(n-1);
    }
//     The method here is calling itself Again and again and is called recursive method/function
    static void printIntegers(int n ){
//        base case
        if (n == 1){
            System.out.print(n + " ");
            return;
        }
        printIntegers(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number =>");
        int n = sc.nextInt();
        printIntegers(n);
        printNto1(n);

    }
}

