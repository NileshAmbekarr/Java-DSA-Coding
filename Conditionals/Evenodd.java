package Conditionals;
import java.util.Scanner;

public class Evenodd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a Number :");
        int n = sc.nextInt();
        if(n%2==0){
            System.out.println("is number is even");
        }
        else
            System.out.println("The number os odd");
    }
}
