package Arrays2D;

import java.util.Scanner;

public class RedctangleSum {
    static void findPrefixSum(int[][] matrix ){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 1; j < matrix[i].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
    }
    static void prefixSumVertical(int[][] matrix ){
        for (int j = 0; j < matrix[j].length ; j++){
            for (int i = 1 ; i < matrix.length; i++){
                matrix[i][j] += matrix[i-1][j];
            }
        }
    }
    static int rectangleSum3(int[][] matrix , int r1, int c1, int r2, int c2){
        // i didnt understand this method.... i need to revise it
        findPrefixSum(matrix);
        prefixSumVertical(matrix);
        int sum = 0, ans = 0 , left = 0, up = 0, leftup = 0;
        if (r1>=1) up = matrix[r1-1][c2];
        if (c1>=1) left = matrix[r2][c1-1];
        if (r1>=1 && c1>=1) leftup = matrix[r1-1][c1-1];
        sum = matrix[r1][c2];
        ans = sum - up - left + leftup ;
        return ans ;

    }
    static int rectangleSum2(int[][] matrix , int r1, int c1, int r2, int c2){
        int sum = 0;
        findPrefixSum(matrix);
        for (int i = r1; i <= r2 ; i++){
            // Calculating sum for ith row from r1 to r2
            if (r1 >= 1)
                sum += matrix[i][r2]- matrix[i][r1-1];
            else
                sum += matrix[i][r2];
        }
        return sum;
    }
    static int rectangleSum(int[][] arr, int r1, int c1, int r2, int c2){
        int TotalSum = 0;
        for (int i = r1; i <= r2; i++ ){
            for (int j = c1 ; j <= c2; j++){
                TotalSum += arr[i][j] ;
            }
        }
        return TotalSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows & columns of the matrix `:");
        int r = sc.nextInt();
        int c  = sc.nextInt();
        int[][] mat = new int[r][c];
        System.out.println("Enter array Elements :");
        for (int i = 0; i < r ; i++){
            for (int j = 0; j < c; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter co-ordinates of rectangle : r1, c1, r2, c2 ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        System.out.println("Sum of rectangle is : " + rectangleSum(mat,r1,c1,r2,c2));
        System.out.println("Sum of rectangle is : " + rectangleSum3(mat,r1,c1,r2,c2));


    }
}
