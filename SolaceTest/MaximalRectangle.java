package SolaceTest;

public class MaximalRectangle {
    int result = 0;

    // Helper function to calculate the maximal rectangle
    private void helper(int[] row, int start, int maxWidth){
        int minHeight = row[start];
        for(int j = start; j < row.length; j++){
            if(row[j] == 0) return;
            if(row[j] < minHeight) minHeight = row[j];
            if(result >= minHeight * maxWidth)
                // pruning
                return;
            int newArea = (j - start + 1) * minHeight;
            if(result < newArea) result = newArea;
        }
    }
    public int maximalRectangle(char[][] Mat) {
        int n = Mat.length;
        int m = Mat[0].length;
        result = 0;
        int[][] M = new int[n][m];
        int[] prev = M[n - 1];
        // preparing DP array
        for(int j = 0; j < m; j++)
            if(Mat[n - 1][j] == '1')
                prev[j] = 1;
        for(int i = n - 2; i > -1; i--){
            for(int j = m - 1; j > -1; j--)
                if(Mat[i][j] != '0')
                    M[i][j] = prev[j] + 1;
            prev = M[i];
        }
        for(int i = 0; i < n; i++){
            int maxHeight = n - i;
            for(int j = 0; j < m; j++){
                int maxWidth =  m - j;
                if(result >= maxHeight * maxWidth)
                    // pruning
                    continue;
                helper(M[i], j, maxWidth);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximalRectangle Solution = new MaximalRectangle();
        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(Solution.maximalRectangle(matrix1));

        char[][] matrix2 = {{'0'}};
        System.out.println(Solution.maximalRectangle(matrix2));

        char[][] matrix3 = {{'1'}};
        System.out.println(Solution.maximalRectangle(matrix3));
    }
}