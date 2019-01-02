package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3344
 * Grapevine
 */
public class P12192 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer nm = new StringTokenizer(line);
                int n = parseInt(nm.nextToken());
                int m = parseInt(nm.nextToken());
                int[][] data = new int[n][m];
                for (int i = 0; i < n; i++) {
                    StringTokenizer row = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < m; j++) {
                        data[i][j] = parseInt(row.nextToken());
                    }
                }
                int q = parseInt(reader.readLine());
                while (q-- > 0) {
                    StringTokenizer query = new StringTokenizer(reader.readLine());
                    int low = parseInt(query.nextToken());
                    int upper = parseInt(query.nextToken());

                    int resSize = 0;
                    for (int i = 0; i < data.length; i++) {
                        int[] row = data[i];
                        int col = binSearch(row, low);
                        if (col >= 0) {
                            for (int size = resSize; size < data.length; size++) {
                                int lastRow = i + size;
                                int lastCol = col + size;
                                if (lastRow >= n || lastCol >= m || data[lastRow][lastCol] > upper) {
                                    break;
                                }
                                if (size >= resSize) {
                                    resSize = size + 1;
                                }
                            }
                        }
                    }
                    result.append(resSize).append("\n");
                }
                result.append("-\n");
            }
            System.out.print(result);
        }

    }

    private static int binSearch(int[] array, int val) {
        int l = 0;
        int r = array.length - 1;
        if (array[r] < val) {
            return -1;
        }
        if (array[l] >= val) {
            return l;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = array[mid];
            if (midValue >= val && array[mid - 1] < val) {
                return mid;
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
