package Conditionals;
import java.util.Scanner;
public class AreaPerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length , breadth , area , perimeter ;
        System.out.println("enter the lenght of rectangle : ");
        length = sc.nextInt();
        System.out.println("enter breadth of the reactangle : ");
        breadth = sc.nextInt();
        area = length * breadth ;
        perimeter = 2* (length+breadth);
        if (area> perimeter){
            System.out.println("area is greater than perimetr ");
        }
        else if (area < perimeter){
            System.out.println("perimeter is greater than area");
        }
        else
            System.out.println("area and perimeter are equal");

    }
}
