package Loops;
import java.util.Scanner;
public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any nmber ");
        int num = sc.nextInt();
        int org_num = num ;
        int sum = 0;
        while(num> 0){
            sum += (num%10);
            num = num / 10;
        }
        System.out.println("The sum of the digits  "+org_num+ " is "+sum);
    }
}
