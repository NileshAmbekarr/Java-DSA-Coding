package Conditionals;
import java.util.Scanner;
public class profitLoss {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enttetr cost price :");
        int Cp = sc.nextInt();
        System.out.println("Enter selling price ");
        int Sp = sc.nextInt();

        if (Sp>Cp){
            System.out.println("Congrats !! You made a profit ");
            System.out.print("your profit is : Rs ");
            System.out.println(Sp- Cp);
        }
        else {
            System.out.println("you are in loss");
            System.out.print("Your loss is  : Rs " );
            System.out.println(Cp-Sp);
        }


    }
}
