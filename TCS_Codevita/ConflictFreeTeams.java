package TCS_Codevita;
import java.util.*;

public class ConflictFreeTeams {

    // Function to find the maximum expertise of a conflict-free team using bitmask DP
    public static int maxExpertise(int n, int[][] conflicts, int[] skills) {
        // Create a bitmask where each bit i indicates if employee i conflicts with others
        int[] conflictMask = new int[n];

        // Fill the conflict bitmask array
        for (int[] conflict : conflicts) {
            int u = conflict[0] - 1; // Convert to 0-based index
            int v = conflict[1] - 1;
            conflictMask[u] |= (1 << v); // Mark conflict with v for u
            conflictMask[v] |= (1 << u); // Mark conflict with u for v
        }

        // DP array to store the maximum expertise for each subset
        int[] dp = new int[1 << n]; // There are 2^n subsets

        // Iterate over all possible subsets
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean valid = true;
            int sum = 0;

            // Check if this subset is conflict-free
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // If employee i is in the subset
                    sum += skills[i]; // Add the skill value of employee i
                    if ((mask & conflictMask[i]) != 0) { // Check if i conflicts with anyone in the subset
                        valid = false;
                        break;
                    }
                }
            }

            // If the subset is conflict-free, store the expertise sum
            if (valid) {
                dp[mask] = sum;
            }
        }

        // Now, iterate over all subsets to find the maximum expertise sum
        int maxExpertise = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            maxExpertise = Math.max(maxExpertise, dp[mask]);
        }

        return maxExpertise;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of employees and number of conflict pairs
        int N = sc.nextInt();
        int M = sc.nextInt();

        // Input: Conflict pairs
        int[][] conflicts = new int[M][2];
        for (int i = 0; i < M; i++) {
            conflicts[i][0] = sc.nextInt();
            conflicts[i][1] = sc.nextInt();
        }

        // Input: Skill values of employees
        int[] skills = new int[N];
        for (int i = 0; i < N; i++) {
            skills[i] = sc.nextInt();
        }

        // Output the maximum expertise sum of a conflict-free team
        System.out.println(maxExpertise(N, conflicts, skills));

        sc.close();
    }
}
