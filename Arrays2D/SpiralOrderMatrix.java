package Arrays2D;
import java.util.Scanner;
public class SpiralOrderMatrix {
    static void PrintMatrix(int[][] arr){
        for (int i = 0; i < arr.length ; i++){
            for (int j = 0 ; j < arr[i].length ; j++){
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
    static int[][] spiralMatrix(int n ){
        int[][] matrix = new int[n][n];
        int leftCol = 0, rightCol = n-1;
        int topRow = 0, bottomRow = n-1;
        int element = 1 ;
        while(element <= n*n ){
            for(int j = leftCol ; j <= rightCol && element <= n*n ; j++){
                matrix[topRow][j] = element++;
            }
            topRow++;
            for(int i = topRow ; i <= bottomRow && element <= n*n; i++){
                matrix[i][rightCol] = element++;
            }
            rightCol--;
            for(int j = rightCol ; j >= leftCol && element <= n*n; j--){
                matrix[bottomRow][j] = element++;
            }
            bottomRow--;
            for(int i = bottomRow ; i >= topRow && element <= n*n ; i--){
                matrix[i][leftCol] = element++;
            }
            leftCol++;

        }
        return matrix ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number :");
        int n = sc.nextInt();
        int[][] spiralMatrix = spiralMatrix(n) ;
        PrintMatrix(spiralMatrix);
    }
}
