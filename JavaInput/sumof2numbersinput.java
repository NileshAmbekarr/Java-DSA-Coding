package JavaInput;
import java.util.Scanner;
public class sumof2numbersinput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First number :");
        int x = sc.nextInt();
        System.out.println("Enter second number :");
        int y = sc.nextInt();
        int sum = x + y ;
        System.out.println("the sum is "+ sum);
    }
}
