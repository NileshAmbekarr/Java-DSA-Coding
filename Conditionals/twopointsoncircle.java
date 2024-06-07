package Conditionals;
import java.util.Scanner;
public class twopointsoncircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int  x = 0 , y = 0 ;
        System.out.println("Enter radius of the circle : ");
        int radius = sc.nextInt();
        System.out.println("Enter coordinates os point => x & y");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        double dOA  = (x-x1)*(x-x1) +(y-y1)*(y-y1);
        System.out.println(dOA);
        if (dOA*dOA> radius*radius){
            System.out.println("The point lies ouutside the circle ");
        }
        else if (dOA*dOA< radius*radius) {
            System.out.println("The point lies  inside the circle ");
        }
        else
            System.out.println("The point lies on the circle ");


    }
}
