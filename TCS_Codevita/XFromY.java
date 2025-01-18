package TCS_Codevita;

import java.util.*;

public class XFromY {

    // Function to find the minimum String Factor
    public static int minStringFactor(String X, String Y, int S, int R) {
        int lenX = X.length();
        int lenY = Y.length();

        // Create the reversed version of Y
        String Y_rev = new StringBuilder(Y).reverse().toString();

        // Initialize dp array with a large number (infinity equivalent)
        int[] dp = new int[lenX + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: no cost to form an empty string
        dp[0] = 0;

        // Preprocess KMP tables for Y and Y_rev
        int[] kmpY = buildKMPTable(Y);
        int[] kmpYRev = buildKMPTable(Y_rev);

        // Build the dp array
        for (int i = 0; i < lenX; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;  // Skip unreachable states
            }

            // Try to match substrings from X[i...j] with Y and Y_rev
            for (int j = i + 1; j <= lenX; j++) {
                String substrX = X.substring(i, j);

                // Check if the substring matches any part of Y using KMP
                if (kmpSearch(Y, substrX, kmpY)) {
                    dp[j] = Math.min(dp[j], dp[i] + S);
                }

                // Check if the substring matches any part of reversed Y using KMP
                if (kmpSearch(Y_rev, substrX, kmpYRev)) {
                    dp[j] = Math.min(dp[j], dp[i] + R);
                }
            }
        }

        // If it's impossible to form the string X, return "Impossible"
        if (dp[lenX] == Integer.MAX_VALUE) {
            System.out.println("Impossible");
            return -1;
        } else {
            return dp[lenX];
        }
    }

    // KMP Algorithm: Build the partial match table
    public static int[] buildKMPTable(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP Search Algorithm
    public static boolean kmpSearch(String text, String pattern, int[] lps) {
        int n = text.length();
        int m = pattern.length();
        int i = 0;  // index for text
        int j = 0;  // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                return true;  // Found the pattern
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Read input
            String X = sc.nextLine();
            String Y = sc.nextLine();
            int S = sc.nextInt();
            int R = sc.nextInt();

            // Calculate and print the minimum String Factor
            int result = minStringFactor(X, Y, S, R);
            if (result != -1) {
                System.out.println(result);
            }
        }
    }
}

