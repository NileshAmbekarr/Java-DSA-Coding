package Loops;
import java.util.Scanner;
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any decimal number :");
        int Dec = sc.nextInt();// decimal no input from user
        int power = 1; // representing the power of 10
        int ans = 0 ;
        while(Dec > 0 ){
            ans += ( Dec % 2 * power);
            power *= 10;
            Dec /= 2;


        }
        System.out.println("The answer is "+ ans);
    }
}
