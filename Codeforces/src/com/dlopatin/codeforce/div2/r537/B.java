package com.dlopatin.codeforce.div2.r537;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1111/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nkm = new StringTokenizer(reader.readLine());
            int n = parseInt(nkm.nextToken());
            int k = parseInt(nkm.nextToken());
            int m = parseInt(nkm.nextToken());
            int[] data = new int[n];
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            long sum = 0;
            for (int i = 0; i < data.length; i++) {
                int val = parseInt(tokens.nextToken());
                data[i] = val;
                sum += val;
            }

            Arrays.sort(data);
            Deque<Integer> added = new ArrayDeque<>(n);
            int lastAddedIdx = 0;
            for (int i = n - 1; i >= 0 && m > 0; i--) {
                int add = (m >= k) ? k : m;
                m = add == k ? m - k : 0;
                added.push(add);
                data[i] += add;
                sum += add;
                lastAddedIdx = i;
            }
            double mean = sum / (double) n;
            int idx = 0;
            while (!added.isEmpty() && idx < n - 1 && lastAddedIdx < n) {
                Integer remove = added.pop();
                while (remove-- > 0 && idx < n - 1) {
                    if (idx < lastAddedIdx) {
                        data[lastAddedIdx]--;
                        sum -= data[idx] + 1;
                    } else {
                        sum -= data[idx];
                    }
                    idx++;
                    double newMean = sum / (double) (n - idx);
                    mean = Math.max(mean, newMean);
                }
                lastAddedIdx++;
            }
            System.out.printf("%.20f", mean);
        }
    }

}