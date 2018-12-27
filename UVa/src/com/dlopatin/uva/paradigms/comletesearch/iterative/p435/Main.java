package com.dlopatin.uva.paradigms.comletesearch.iterative.p435;

import java.io.IOException;
import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=376
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().doJob();
    }

    private void doJob() throws NumberFormatException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            while (n-- != 0) {
                int number = scanner.nextInt();
                int[] votes = new int[number];
                int max = 0;
                for (int i = 0; i < number; i++) {
                    votes[i] = scanner.nextInt();
                    max += votes[i];
                }
                int half = max / 2;
                int[] power = new int[number];
                for (int i = 0; i < (1 << number); i++) {
                    int sum = 0;
                    for (int j = 0; j < number; j++) {
                        if ((i & (1 << j)) != 0) {
                            sum += votes[j];
                        }
                    }
                    if (sum > half) {
                        for (int j = 0; j < number; j++) {
                            if ((i & (1 << j)) != 0 && sum - votes[j] <= half) {
                                power[j]++;
                            }
                        }
                    }
                }

                for (int i = 0; i < number; i++) {
                    System.out.printf("party %d has power index %d\n", i + 1, power[i]);
                }
                System.out.println();
            }
        }

    }

}
