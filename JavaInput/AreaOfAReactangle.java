package JavaInput;
import java.sql.SQLOutput;
import java.util.Scanner;
public class AreaOfAReactangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the Rectangle :");
        double Length = sc.nextInt();
        System.out.println("Enter breadth of the Reactangle");
        double breadth = sc.nextInt();
        double Area = Length*breadth;
        if(Length==breadth){
            System.out.println("The shape is a square ");
            System.out.println("The area of the square is :"+Area
            );
        }
        else
        System.out.println("The area of the rectangle  is :"+Area);
    }
}
