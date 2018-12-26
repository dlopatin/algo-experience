package com.dlopatin.uva.comletesearch.backtracking.harder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3703
 * Password
 */
public class P1262 {

    private static StringBuilder sol = new StringBuilder();
    private static int foundIdx = 0;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int k = parseInt(reader.readLine());
                char[][] first = readArray(reader);
                char[][] second = readArray(reader);

                char[][] merged = new char[5][6];
                int possibleCases = 1;
                for (int i = 0; i < merged.length; i++) {
                    int f = 0;
                    int s = 0;
                    int m = 0;
                    while (f < merged[i].length && s < merged[i].length) {
                        if (first[i][f] == second[i][s]) {
                            if (m == 0 || m > 0 && merged[i][m - 1] != first[i][f]) {
                                merged[i][m++] = first[i][f];
                            }
                            f++;
                            s++;
                        } else if (first[i][f] > second[i][s]) {
                            s++;
                        } else {
                            f++;
                        }
                    }
                    possibleCases *= m;
                }

                if (possibleCases < k) {
                    result.append("NO");
                } else {
                    sol = new StringBuilder();
                    foundIdx = 0;
                    backtrack(0, new StringBuilder("     "), k, merged);
                    result.append(sol);
                }
                result.append("\n");
            }
            System.out.print(result);
        }

    }

    private static void backtrack(int iIdx, StringBuilder result, int targetOccur, char[][] data) {
        for (int j = 0; j < data[iIdx].length && foundIdx != targetOccur; j++) {
            if (data[iIdx][j] == 0) {
                return;
            }
            result.setCharAt(iIdx, data[iIdx][j]);
            if (iIdx == data.length - 1) {
                foundIdx++;
                if (foundIdx == targetOccur) {
                    sol = result;
                    return;
                }
            } else {
                backtrack(iIdx + 1, result, targetOccur, data);
            }
        }
    }

    private static char[][] readArray(BufferedReader reader) throws IOException {
        char[][] data = new char[6][5];
        for (int i = 0; i < 6; i++) {
            data[i] = reader.readLine().toCharArray();
        }
        data = transposeMatrix(data);
        for (char[] chars : data) {
            Arrays.sort(chars);
        }
        return data;
    }

    private static char[][] transposeMatrix(char[][] m) {
        char[][] temp = new char[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                temp[j][i] = m[i][j];
            }
        }
        return temp;
    }
}
