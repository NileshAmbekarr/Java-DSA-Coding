package Loops;
import java.util.Scanner;
public class SumOf1stNNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vakue of n :");
        int n = sc.nextInt();
        int x = 0 ;
        int sum = 0;
        while(x <= n ){
            sum += x;
            System.out.println(x);
            x++;
        }
        System.out.println("Sum of this numbers are => " + sum);
    }
}
