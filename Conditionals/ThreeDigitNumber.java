package Conditionals;
import java.util.Scanner;
public class ThreeDigitNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number : ");
        int n = sc.nextInt();
        if (n>99 && n< 1000)
            System.out.println("The number is a three digit number ");
        else
            System.out.println("It is not an Three digit number ");
    }
}
