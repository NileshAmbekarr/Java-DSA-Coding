package JavaInput;
import java.util.Scanner;
public class squareofnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        System.out.println("Enter any number :");
        n = sc.nextInt();
        int Square = n*n;
        System.out.println("the square of the given number is :"+Square);
    }
}
