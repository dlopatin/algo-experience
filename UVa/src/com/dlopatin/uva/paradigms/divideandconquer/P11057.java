package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1998
 * Exact Sum
 */
public class P11057 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int n = parseInt(line);
                StringTokenizer numbers = new StringTokenizer(reader.readLine());
                int[] data = new int[n];
                for (int i = 0; i < n; i++) {
                    data[i] = parseInt(numbers.nextToken());
                }
                int sum = parseInt(reader.readLine());
                reader.readLine();

                Arrays.sort(data);
                int diff = Integer.MAX_VALUE;
                int first = 0;
                int second = 0;
                for (int iVal : data) {
                    int jVal = sum - iVal;
                    int found = binSearch(data, jVal);
                    if (found >= 0 && diff > Math.abs(jVal - iVal)) {
                        diff = Math.abs(jVal - iVal);
                        first = iVal;
                        second = jVal;
                    }
                }
                result.append(String.format("Peter should buy books whose prices are %d and %d.\n", first, second))
                        .append("\n");
            }
            System.out.print(result);
        }

    }

    private static int binSearch(int[] array, int val) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int midValue = array[mid];
            if (midValue == val) {
                return midValue;
            }

            if (midValue < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


}
