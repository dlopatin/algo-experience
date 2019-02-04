package com.dlopatin.codeforce.div2.r537;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1111/problem/C
 */
public class C {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nkab = new StringTokenizer(reader.readLine());
            int n = parseInt(nkab.nextToken());
            int k = parseInt(nkab.nextToken());
            int a = parseInt(nkab.nextToken());
            int b = parseInt(nkab.nextToken());
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            int[] data = new int[k];
            for (int i = 0; i < k; i++) {
                int val = parseInt(tokens.nextToken());
                data[i] = val;
            }
            Arrays.sort(data);
            System.out.println(recurse(1, 1 << n, data, a, b));

        }
    }

    private static long recurse(int l, int r, int[] data, int a, int b) {
        int onTheLeft = lowerBoundBinSearch(data, l);
        int onTheRight = upperBoundBinSearch(data, r);
        int total = onTheRight - onTheLeft;
        if (total <= 0) {
            return a;
        }
        if (l == r) {
            return (long) b * total;
        }
        int m = l + (r - l) / 2;
        long cost = (long) b * total * (r - l + 1);
        return Math.min(cost, recurse(l, m, data, a, b) + recurse(m + 1, r, data, a, b));
    }

    private static int lowerBoundBinSearch(int[] data, int key) {
        int l = 0;
        int h = data.length - 1;
        int mid;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (data[mid] < key) { // lower bound <
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    private static int upperBoundBinSearch(int[] data, int key) {
        int l = 0;
        int h = data.length - 1;
        int mid;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (data[mid] <= key) { // upper bound <=
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

}