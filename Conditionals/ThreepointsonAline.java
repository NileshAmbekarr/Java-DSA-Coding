package Conditionals;
import java.util.Scanner;
public class ThreepointsonAline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x1");
        double  x1 = sc.nextInt();
        System.out.println("Enter x2");
        double x2 = sc.nextInt();
        System.out.println("Enter x3");
        double x3 = sc.nextInt();
        System.out.println("Enter y1");
        double y1 = sc.nextInt();
        System.out.println("Enter y2");
        double y2 = sc.nextInt();
        System.out.println("Enter y3");
        double y3 = sc.nextInt();
        double slope1 = ((y2-y1)/(x2-x1));
        double slope2 = ((y3-y2)/(x3-x2));
        if(slope1==slope2)
            System.out.println("point lie on a straight line ");
        else
            System.out.println(" points do not lie on a straight line ");

    }
}
