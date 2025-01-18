package TCS_Codevita;
import java.util.*;

public class Problem9x9 {

    private static final int SIZE = 9;

    // Function to check if the Sudoku grid is valid and count modifications needed
    public static boolean isValidSudoku(int[][] grid, List<Integer> allowedNumbers, int K, List<int[]> wrongCells) {
        Set<Integer>[] rowSets = new HashSet[SIZE];
        Set<Integer>[] colSets = new HashSet[SIZE];
        Set<Integer>[] boxSets = new HashSet[SIZE];
        int modifications = 0;

        // Initialize sets for rows, columns, and boxes
        for (int i = 0; i < SIZE; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                int num = grid[i][j];
                if (num == 0) continue; // Skip empty cells

                // Check for leading zeros (filled by Tina)
                boolean isHinted = (num % 10 == 0);
                if (isHinted) {
                    num /= 10; // Remove trailing zero for hint
                }

                // Check for duplicates in rows, columns, and boxes
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rowSets[i].contains(num) || colSets[j].contains(num) || boxSets[boxIndex].contains(num)) {
                    if (!isHinted) {
                        modifications++;
                        wrongCells.add(new int[]{i, j}); // Collect the position of wrong cells
                    }
                } else {
                    if (!isHinted) {
                        rowSets[i].add(num);
                        colSets[j].add(num);
                        boxSets[boxIndex].add(num);
                    }
                }
            }
        }

        // Check hinted cells for allowed values
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (grid[i][j] % 10 == 0) { // Hinted cell
                    int hintNum = grid[i][j] / 10;
                    if (!allowedNumbers.contains(hintNum)) {
                        modifications++;
                        wrongCells.add(new int[]{i, j});
                    }
                }
            }
        }

        return modifications <= K; // Return whether modifications are within limits
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[SIZE][SIZE];
        List<Integer> allowedNumbers = new ArrayList<>();
        List<int[]> wrongCells = new ArrayList<>();

        // Read the grid
        for (int i = 0; i < SIZE; ++i) {
            String line = sc.nextLine();
            String[] values = line.split(" ");
            for (int j = 0; j < SIZE; ++j) {
                grid[i][j] = Integer.parseInt(values[j]);
            }
        }

        // Read allowed numbers
        String[] allowedNumsInput = sc.nextLine().split(" ");
        for (String s : allowedNumsInput) {
            allowedNumbers.add(Integer.parseInt(s));
        }

        int K = sc.nextInt();

        if (isValidSudoku(grid, allowedNumbers, K, wrongCells)) {
            if (wrongCells.isEmpty()) {
                System.out.println("Won"); // Case where no wrong cells
            } else {
                // Output the indices of the wrongly placed cells
                for (int i = 0; i < wrongCells.size(); ++i) {
                    System.out.print(wrongCells.get(i)[0] + " " + wrongCells.get(i)[1]);
                    if (i < wrongCells.size() - 1) System.out.println(); // Print newline only for preceding elements
                }
            }
        } else {
            System.out.println("Impossible"); // Print exactly "Impossible"
        }

        sc.close();
    }
}
