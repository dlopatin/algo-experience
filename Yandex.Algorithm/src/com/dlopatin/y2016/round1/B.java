package com.dlopatin.y2016.round1;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] src = new int[3][3];
            for (int i = 0; i < 3; i++) {
                final char[] line = scanner.nextLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    if (line[j] != '?') {
                        src[i][j] = Integer.parseInt(Character.toString(line[j]));
                    }
                }
            }
            for (int var = 2; var <= 8; var++) {
                int[][] array = new int[3][3];
                array[1][1] = 1;
                // right
                int temp = var;
                for (int i = 0; i < 3; i++) {
                    // 0, x
                    array[0][i] = temp;
                    temp = inc(temp);
                }
                for (int i = 1; i < 3; i++) {
                    // x, 2
                    array[i][2] = temp;
                    temp = inc(temp);
                }
                for (int i = 1; i >= 0; i--) {
                    // 2, x
                    array[2][i] = temp;
                    temp = inc(temp);
                }
                for (int i = 1; i >= 0; i--) {
                    // x, 0
                    array[i][0] = temp;
                    temp = inc(temp);
                }
                if (isSolution(array, src)) {
                    printArray(array);
                    return;
                }

                //left
                temp = var;
                for (int i = 0; i < 3; i++) {
                    // x, 0
                    array[i][0] = temp;
                    temp = inc(temp);
                }
                for (int i = 1; i < 3; i++) {
                    // 2, x
                    array[2][i] = temp;
                    temp = inc(temp);
                }
                for (int i = 1; i >= 0; i--) {
                    // x, 2
                    array[i][2] = temp;
                    temp = inc(temp);
                }

                for (int i = 1; i >= 0; i--) {
                    // 0, x
                    array[0][i] = temp;
                    temp = inc(temp);
                }
                if (isSolution(array, src)) {
                    printArray(array);
                    return;
                }
            }

        }
    }

    private int inc(int var) {
        var = (var + 1) % 10;
        return var < 2 ? 2 : var;
    }

    private boolean isSolution(int[][] result, int[][] src) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (src[i][j] != 0) {
                    if (src[i][j] != result[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void printArray(int[][] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

}