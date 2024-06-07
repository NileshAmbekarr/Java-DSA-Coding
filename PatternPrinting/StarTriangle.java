package PatternPrinting;
import java.util.Scanner;
public class StarTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number ");
        int n = 7;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j<= i ; j++ ){
                System.out.print("*");
            }
            System.out.println(" ");
           // System.out.println(" ");
        }

    }
}
