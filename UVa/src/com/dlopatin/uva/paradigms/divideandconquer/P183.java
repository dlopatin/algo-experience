package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=119
 * Bit Maps
 */
public class P183 {

    private static char[][] matrix;


    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            DataProvider dataProvider = new DataProvider(reader);
            while ((line = reader.readLine()) != null && !"#".equals(line)) {
                StringTokenizer typeTokens = new StringTokenizer(line);
                String type = typeTokens.nextToken();
                int n = parseInt(typeTokens.nextToken());
                int m = parseInt(typeTokens.nextToken());
                matrix = new char[n][m];
                if ("B".equals(type)) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            matrix[i][j] = dataProvider.nextChar();
                        }
                    }
                    result.append("D").append(String.format("%4d%4d\n", n, m));
                    StringBuilder d = new StringBuilder();
                    printD(0, 0, n, m, d);
                    for (int i = 50; i < d.length(); i += 50) {
                        d.insert(i, "\n");
                        i++;
                    }
                    result.append(d);
                } else {
                    result.append("B").append(String.format("%4d%4d\n", n, m));
                    readD(0, 0, n, m, dataProvider);
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i + j > 0 && (i * m + j) % 50 == 0) {
                                // each line contains 50 symbols in output
                                result.append("\n");
                            }
                            result.append(matrix[i][j]);
                        }
                    }
                }
                result.append("\n");
            }
            System.out.print(result);
        }

    }

    private static void readD(int rowFrom, int colFrom, int rowTo, int colTo, DataProvider dataProvider)
            throws IOException {
        if (rowFrom == rowTo || colFrom == colTo) {
            return;
        }
        char inputChar = dataProvider.nextChar();
        if (inputChar == 'D') {
            int rowMid = (rowFrom + rowTo + 1) / 2;
            int colMid = (colFrom + colTo + 1) / 2;
            readD(rowFrom, colFrom, rowMid, colMid, dataProvider); // nw
            readD(rowFrom, colMid, rowMid, colTo, dataProvider); // ne
            readD(rowMid, colFrom, rowTo, colMid, dataProvider); // sw
            readD(rowMid, colMid, rowTo, colTo, dataProvider); // se
        } else {
            for (int i = rowFrom; i < rowTo; i++) {
                for (int j = colFrom; j < colTo; j++) {
                    matrix[i][j] = inputChar;
                }
            }
        }
    }

    private static void printD(int rowFrom, int colFrom, int rowTo, int colTo, StringBuilder res) {
        if (rowFrom == rowTo || colFrom == colTo) {
            return;
        }
        boolean same = true;
        for (int i = rowFrom; i < rowTo && same; i++) {
            for (int j = colFrom; j < colTo && same; j++) {
                same = matrix[rowFrom][colFrom] == matrix[i][j];
            }
        }
        if (same) {
            res.append(matrix[rowFrom][colFrom]);
        } else {
            res.append("D");
            int rowMid = (rowFrom + rowTo + 1) / 2;
            int colMid = (colFrom + colTo + 1) / 2;
            printD(rowFrom, colFrom, rowMid, colMid, res); // nw
            printD(rowFrom, colMid, rowMid, colTo, res); // ne
            printD(rowMid, colFrom, rowTo, colMid, res); // sw
            printD(rowMid, colMid, rowTo, colTo, res); // se
        }

    }

    private static class DataProvider {
        private final BufferedReader bufferedReader;
        private char[] chars = new char[0];
        private int idx = 0;

        DataProvider(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
        }

        private char nextChar() throws IOException {
            if (idx >= chars.length) {
                chars = bufferedReader.readLine().trim().toCharArray();
                idx = 0;
            }
            return chars[idx++];
        }
    }
}
