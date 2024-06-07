package Loops;
import java.util.Scanner;
public class AraisedtoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values of  A and B");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 1;
        for(int i = 1 ; i<= b ; i++){
            ans = ans* a ;
        }
        System.out.println(a+" raised to "+b+ " is "+ans);

    }
}
