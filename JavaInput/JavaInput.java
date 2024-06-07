package JavaInput;
import java.util.Scanner;
public class JavaInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Radius of the Circle :");
        int Radius = sc.nextInt();
        double pi = 3.14;
        double area = pi * Radius*Radius;
        System.out.println("The area of the circle is "+area);
    }

}
