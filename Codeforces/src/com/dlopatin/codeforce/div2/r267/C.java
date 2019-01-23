package com.dlopatin.codeforce.div2.r267;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/467/problem/C
 * <p>
 * Not solved
 */
public class C {

    public static void main(String[] args) throws IOException, ParseException {
        new C().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            List<Integer> p = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int nextInt = scanner.nextInt();
                p.add(nextInt);
            }
            List<Long> sums = new LinkedList<>();
            int[] array = new int[n];
            for (int i = n; i > 0; i--) {
                int r = i;
                int l = findNumber(r, m);
                if (l <= n && l > 0 && array[l - 1] == 0) {
                    long s = 0;
                    for (int z = l; z <= r; z++) {
                        s += p.get(z - 1);
                    }
                    sums.add(s);
                    array[r - 1] = 1;
                    array[l - 1] = 1;
                }
            }
            Collections.sort(sums, Collections.reverseOrder());
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += sums.get(i);
            }
            System.out.println(sum);
        }
    }

    private int findNumber(int p, int m) {
        return p + 1 - m;
    }
}
