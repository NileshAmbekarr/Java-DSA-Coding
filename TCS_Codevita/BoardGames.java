package TCS_Codevita;
import java.util.*;

public class BoardGames {

    // Returns all possible moves
    public static int[][] getMoves(int x, int y) {
        return new int[][] {{x, y}, {y, -x}, {-y, x}, {-x, -y}};
    }

    // Checks if the move is valid
    public static boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
    }

    // Breadth-first search function
    public static int bfs(int[][] grid, int[] source, int[] destination, int x, int y) {
        int M = grid.length, N = grid[0].length;

        // Check for empty grid
        if (M == 0 || N == 0) {
            return -1;
        }

        // Check if source or destination is blocked
        if (grid[source[0]][source[1]] == 1 || grid[destination[0]][destination[1]] == 1) {
            return -1;
        }

        // Check if source or destination is out of bounds
        if (source[0] < 0 || source[0] >= M || source[1] < 0 || source[1] >= N ||
                destination[0] < 0 || destination[0] >= M || destination[1] < 0 || destination[1] >= N) {
            return -1;
        }

        // Check if source and destination are the same
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {source[0], source[1], 0});
        Set<String> visited = new HashSet<>();
        visited.add(source[0] + "," + source[1]);
        int[][] moves = getMoves(x, y);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], steps = current[2];

            if (row == destination[0] && col == destination[1]) {
                return steps;
            }

            for (int[] move : moves) {
                int newRow = row + move[0];
                int newCol = col + move[1];
                if (isValid(grid, newRow, newCol) && !visited.contains(newRow + "," + newCol)) {
                    visited.add(newRow + "," + newCol);
                    queue.add(new int[] {newRow, newCol, steps + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input grid dimensions
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] grid = new int[M][N];

        // Input grid values
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Input source and destination
        int[] source = new int[] {scanner.nextInt(), scanner.nextInt()};
        int[] destination = new int[] {scanner.nextInt(), scanner.nextInt()};

        // Input move parameters x and y
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // Output the result of BFS
        System.out.print(bfs(grid, source, destination, x, y));

        scanner.close();
    }
}

