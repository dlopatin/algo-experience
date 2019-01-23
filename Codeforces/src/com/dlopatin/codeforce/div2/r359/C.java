package com.dlopatin.codeforce.div2.r359;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/686/problem/C
 */
public class C {

    public static void main(String[] args) {
        new C().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Map<String, Integer> parts = new HashMap<>();
            String start = "";
            int d = Integer.toString(n, 7).length();
            for (int i = 0; i < d; i++) {
                start += i;
            }
            for (int i = Integer.valueOf(start, 7); i < n; i++) {
                int[] digits = intToArray(i, d);
            }
        }
    }

    private boolean areUnique(int[] digits) {
        int[] unique = new int[7];
        Arrays.stream(digits).forEach(d -> unique[d]++);
        return Arrays.stream(unique).filter(val -> val > 1).count() > 0;

    }

    private int[] intToArray(int number, int n) {
        int[] res = new int[n];
        int i = 0;
        while (number > 0) {
            res[i++] = number % 7;
            number /= 7;
        }
        int[] copyOf = Arrays.copyOf(res, n);
        Arrays.sort(copyOf);
        return copyOf;
    }

    private int perm(int[] a, int n, int max) {
        int count = 0;
        if (n == 1) {
            String res = "";
            for (int i = 0; i < a.length; i++) {
                res += a[i];
            }
            if (Long.parseLong(res, 7) < max) {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            count += perm(a, n - 1, max);
            swap(a, i, n - 1);
        }
        return count;
    }

//	private long joinDigitsToNumber

    private void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

}