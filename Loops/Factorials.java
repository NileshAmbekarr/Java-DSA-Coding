package Loops;
import java.util.Scanner;
public class Factorials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n ");
        int n = sc.nextInt();
        int fact = 1 ;
        for(int i = 1 ; i<=n ; i++){
            fact = fact * i ;
            System.out.println("The Factorial of "+ i + " is => " +fact );

        }

    }
}

