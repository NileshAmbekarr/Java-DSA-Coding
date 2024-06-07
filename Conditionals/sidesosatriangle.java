package Conditionals;
import java.util.Scanner;
public class sidesosatriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first side :");
        int a = sc.nextInt();
        System.out.println("EnterSacond side :");
        int b = sc.nextInt();
        System.out.println("Enter Third side :");
        int c= sc.nextInt();
        if (a + b > c && b + c > a && a + c> a)
            System.out.println("These numbers can be the sides of the triangle ");
        else
            System.out.println("invalid traiangle ");
    }
}
