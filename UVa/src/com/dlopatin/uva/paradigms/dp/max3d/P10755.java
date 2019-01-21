package com.dlopatin.uva.paradigms.dp.max3d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1696
 * Garbage Heap
 * 3D max sum
 */
public class P10755 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine().trim());
            while (t-- > 0) {
                StringTokenizer abc = new StringTokenizer(readNonEmptyLine(reader));
                int a = parseInt(abc.nextToken());
                int b = parseInt(abc.nextToken());
                int c = parseInt(abc.nextToken());

                long[][][] sums = new long[a][b][c];
                StringTokenizer data = new StringTokenizer(readNonEmptyLine(reader));
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < b; j++) {
                        for (int k = 0; k < c; k++) {
                            if (!data.hasMoreTokens()) {
                                data = new StringTokenizer(readNonEmptyLine(reader));
                            }
                            sums[i][j][k] = parseLong(data.nextToken());
                            if (j > 0) {
                                sums[i][j][k] += sums[i][j - 1][k];
                            }
                            if (k > 0) {
                                sums[i][j][k] += sums[i][j][k - 1];
                            }
                            if (j > 0 && k > 0) {
                                sums[i][j][k] -= sums[i][j - 1][k - 1];
                            }
                        }
                    }
                }

                long max = Long.MIN_VALUE;
                for (int startI = 0; startI < b; startI++) {
                    for (int startJ = 0; startJ < c; startJ++) {
                        for (int endI = startI; endI < b; endI++) {
                            for (int endJ = startJ; endJ < c; endJ++) {
                                long localMax = 0;
                                for (int slice = 0; slice < a; slice++) {// (go over slices)
                                    long sum = sums[slice][endI][endJ];
                                    if (startI > 0) {
                                        sum -= sums[slice][startI - 1][endJ];
                                    }
                                    if (startJ > 0) {
                                        sum -= sums[slice][endI][startJ - 1];
                                    }
                                    if (startI > 0 && startJ > 0) {
                                        sum += sums[slice][startI - 1][startJ - 1];
                                    }

                                    // Kadane's algorithm
                                    localMax = Math.max(sum, localMax + sum);
                                    max = Math.max(localMax, max);
                                }
                            }
                        }
                    }
                }
                result.append(max).append("\n");
                if (t > 0) {
                    result.append("\n");
                }
            }
            System.out.print(result);
        }
    }

    private static String readNonEmptyLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        while (line == null || line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }
}

