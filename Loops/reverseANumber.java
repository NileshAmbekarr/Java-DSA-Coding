package Loops;
import java.util.Scanner;
public class reverseANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any nmber ");
        int num = sc.nextInt();
        int org_num = num ;
        int ans = 0;
        while(num>0){
            ans = ans*10 + num%10;
            num /= 10 ;

        }
        System.out.println("The reverse of the number "+ org_num+" is "+ans );

    }
}
