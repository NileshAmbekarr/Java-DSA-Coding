package Conditionals;
import java.util.Scanner;
public class divisibleBy5and3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number : ");
        int n = sc.nextInt();
        if (n%5==0 && n%3==0)
            System.out.println("The number is divisible by 5 and 3 ");
        else
            System.out.println("The number is not divisiblee by 5 and 3 both");
    }
}
