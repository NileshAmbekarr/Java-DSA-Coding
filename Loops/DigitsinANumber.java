package Loops;
import java.util.Scanner;
public class DigitsinANumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number ");
        int n = sc.nextInt();
        int count = 0;
        while (n>0){
            n = n/10;
            count++;

        }
        System.out.println("The number of digits in the number is "+count);

    }
}

