package com.dlopatin.codeforce.div2.r294;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/519/problem/D
 */
public class D {

    private static final int LETTERS = 26;

    public static void main(String[] args) {
        new D().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] weights = new int[LETTERS];
            for (int i = 0; i < LETTERS; i++) {
                weights[i] = scanner.nextInt();
            }
            char[] input = scanner.next().toCharArray();

            long[] sum = new long[input.length + 1];
            for (int i = 1; i <= input.length; i++) {
                sum[i] = weights[input[i - 1] - 'a'];
                sum[i] += sum[i - 1];
            }

            long ans = 0;
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            for (int i = 0; i < LETTERS; i++) {
                map.clear();
                for (int j = 1; j <= input.length; j++) {
                    if (input[j - 1] - 'a' == i) {
                        if (map.containsKey(sum[j - 1])) {
                            ans += map.get(sum[j - 1]);
                        }
                        if (map.containsKey(sum[j])) {
                            map.put(sum[j], map.get(sum[j]) + 1);
                        } else {
                            map.put(sum[j], 1);
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
