package com.dlopatin.uva.paradigms.dp.max2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=44
 * Maximum Sum
 * O(n^3) implementation https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
 */
public class P108 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int n = parseInt(line);
                int[][] a = new int[n][n];
                StringTokenizer data = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!data.hasMoreTokens()) {
                            data = new StringTokenizer(reader.readLine());
                        }
                        a[i][j] = parseInt(data.nextToken());
                    }
                }
                result.append(findMax2D(a)).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int findMax2D(int[][] a) {
        int max = Integer.MIN_VALUE;
        int cols = a[0].length;
        for (int topRow = 0; topRow < a.length; topRow++) {
            int[] rowSums = new int[cols];
            for (int bottomRow = topRow; bottomRow < a.length; bottomRow++) {
                for (int i = 0; i < cols; i++) {
                    rowSums[i] += a[bottomRow][i];
                }

                // Kadane's algorithm
                int localMax = 0;
                for (int val : rowSums) {
                    localMax = Math.max(val, val + localMax);
                    max = Math.max(max, localMax);
                }
            }
        }
        return max;
    }

}

