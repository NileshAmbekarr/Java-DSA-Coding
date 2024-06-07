package Loops ;
import java.sql.SQLOutput;
import java.util.Scanner;
// Find the sum of givrn series : 1 -2+3-4+5....n
public class SumOfSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n ");
        int n = sc.nextInt();
        int sum = 0 ;
        for(int i = 1 ; i <= n ; i++){
            if(i%2==0)
                sum -= i ;
            else
                sum += i ;

        }
        System.out.println("The totall sum is "+ sum);

    }
}
