package JavaInput;
import java.util.Scanner;
public class findRemaindder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter divedent :");
        int a = sc.nextInt();
        System.out.println("Enter divisor :");
        int b = sc.nextInt();
        int quotiant = a / b ;
        int remainder = a - b*quotiant;
        // OR remainder = a%b ; => modulus operetor 
        System.out.println("The quotiant is :"+quotiant
        );
        System.out.println("The ramainder is :"+ remainder);
    }
}
