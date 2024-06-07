package Conditionals;
import java.util.Scanner;
public class GreatestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number :");
        int a = sc.nextInt();
        System.out.println("EnterSacond number :");
        int b = sc.nextInt();
        System.out.println("Enter Third number :");
        int c= sc.nextInt();
        if (a> b && a>c)
            System.out.println(a+" is largest");
        else if (b> a && b>c)
            System.out.println(b+" is largest");
        else
            System.out.println(c+" is largest");


    }
}
