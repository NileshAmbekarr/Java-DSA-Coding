package Loops;
import java.util.Scanner;
public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Binary number ");
        int Binary = sc.nextInt();
        int ans = 0;
        int power = 1; // representing power of 2 '0

        while (Binary > 0 ){
            int unit_digit = Binary % 10 ;
            ans += ( unit_digit * power );//
            Binary /= 10;
            power *= 2 ;
        }
        System.out.println("The answer is "+ ans);
    }
}
