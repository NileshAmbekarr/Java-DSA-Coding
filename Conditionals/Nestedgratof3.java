package Conditionals;
import java.util.Scanner;
public class Nestedgratof3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter first number :");
        int a = sc.nextInt();
        System.out.println("EnterSacond number :");
        int b = sc.nextInt();
        System.out.println("Enter Third number :");
        int c= sc.nextInt();
        if (a>b){
            if(a>c)
                System.out.println(a+ " is Greater");
            else
                System.out.println(c+ " is greater");
        }
        else
            if (b>c)
                System.out.println(b+ " is graeter");
            else
                System.out.println(c+ " is grater");
    }
}
