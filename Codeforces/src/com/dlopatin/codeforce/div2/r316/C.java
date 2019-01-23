package com.dlopatin.codeforce.div2.r316;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/570/problem/B
 */
public class C {

    public static void main(String[] args) {
        new C().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[] line = scanner.next().toCharArray();
            int[] res = new int[m];
            int initialRepCnt = countReplacements(line, 0, line.length - 1);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int idx = scanner.nextInt() - 1;
                char replacement = scanner.next().charAt(0);
                if (line[idx] != replacement) {
                    int leftIdx = findLeftStop(line, idx);
                    int rightIdx = findRightStop(line, idx);
                    int currentCnt = countReplacements(line, leftIdx, rightIdx);
                    line[idx] = replacement;
                    int newCnt = countReplacements(line, leftIdx, rightIdx);
                    int diff = newCnt - currentCnt;
                    if (i == 0) {
                        res[i] = initialRepCnt + diff;
                    } else {
                        res[i] = res[i - 1] + diff;
                    }
                } else {
                    if (i == 0) {
                        res[i] = initialRepCnt;
                    } else {
                        res[i] = res[i - 1];
                    }
                }
                builder.append(res[i]).append("\n");
            }
            System.out.println(builder);
        }
    }

    private int countReplacements(char[] line, int start, int end) {
        int counter = 0;
        int subcounter = 0;
        for (int i = start; i <= end; i++) {
            if ('.' == line[i]) {
                subcounter++;
            } else {
                counter += subcounter > 1 ? subcounter - 1 : 0;
                subcounter = 0;
            }
        }
        counter += subcounter > 1 ? subcounter - 1 : 0;
        return counter;
    }

    private int findLeftStop(char[] line, int idx) {
        int i = idx;
        while (i - 1 >= 0 && '.' == line[i - 1]) {
            i--;
        }
        return i > 0 ? i : 0;
    }

    private int findRightStop(char[] line, int idx) {
        int i = idx;
        while (i + 1 < line.length && '.' == line[i + 1]) {
            i++;
        }
        return i;
    }

}