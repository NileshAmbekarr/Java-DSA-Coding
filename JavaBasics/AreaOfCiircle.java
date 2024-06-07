package JavaBasics;

import java.util.Scanner;

public class AreaOfCiircle {
    static double CalculateArea(int r){
        double area = 3.14 * r*r ;
        return area ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius of the circle ");
        int rad = sc.nextInt();
        double area = CalculateArea(rad);
        System.out.println("The area of the Circle is " + area );
    }
}
