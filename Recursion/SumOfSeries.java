package Recursion;

public class SumOfSeries {
    // Method for  sum of series but for alternate signs
    static int sumOfSeries(int n ){
        if(n == 0 ) return 0 ; // base case
        if(n % 2 == 0) return sumOfSeries(n -1 ) - n ; // recursive work 
        return sumOfSeries(n-1 ) + n;
    }

    // method for Sum Of series upto n Number
    static int sumOfSeries1(int n ){
        if(n == 0 ) return 0 ;
        return sumOfSeries(n-1 ) + n;
    }
    public static void main(String[] args) {

        System.out.println(sumOfSeries(5));
    }
}
