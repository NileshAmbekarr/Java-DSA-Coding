package TCS_Codevita;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class WaterResource {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Read number of elements
        int[] A = new int[n]; // Array A
        int[] B = new int[n]; // Array B

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt(); // Read elements of array A
        }

        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt(); // Read elements of array B
        }

        int valleyIndex = findWidestValley(n, A, B);
        System.out.println(valleyIndex);
    }

    public static int findWidestValley(int n, int[] A, int[] B) {
        double twoPi = 2 * Math.PI;
        double step = 0.001; // Smaller step size for better resolution
        List<Double> yValues = new ArrayList<>();

        // Calculate the y-values for x in range 0 to 2*pi with step size
        for (double x = 0; x <= twoPi; x += step) {
            double y = 0;
            // Summing up the sine functions for each i in range [0, n-1]
            for (int i = 0; i < n; i++) {
                y += Math.sin(A[i] * x + B[i]);
            }
            yValues.add(y);
        }

        // Find peaks (local maxima)
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < yValues.size() - 1; i++) {
            if (yValues.get(i) > yValues.get(i - 1) && yValues.get(i) > yValues.get(i + 1)) {
                peaks.add(i);
            }
        }

        // If there are less than 2 peaks, we can't form a valley
        if (peaks.size() < 2) {
            System.out.println("Not enough peaks to form valleys.");
            return -1; // or any indicator for insufficient peaks
        }

        // Find the widest valley
        double maxWidth = 0;
        int valleyIndex = -1;

        for (int i = 1; i < peaks.size(); i++) {
            int leftPeak = peaks.get(i - 1);
            int rightPeak = peaks.get(i);
            double width = rightPeak - leftPeak;

            // Update if this valley is wider
            if (width > maxWidth) {
                maxWidth = width;
                valleyIndex = i; // We are counting valleys from 1
            }
        }

        return valleyIndex; // Returning the index of the widest valley
    }
}
