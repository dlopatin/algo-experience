package com.dlopatin.codeforce.educational.r59;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1107/problem/C
 */
public class C {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nk = new StringTokenizer(reader.readLine());
            int n = parseInt(nk.nextToken());
            int k = parseInt(nk.nextToken());
            StringTokenizer aTokens = new StringTokenizer(reader.readLine());
            char[] s = reader.readLine().toCharArray();
            long sum = 0;
            PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
            char prev = 0;
            for (char c : s) {
                long ai = Long.parseLong(aTokens.nextToken());
                if (c == prev) {
                    queue.add(ai);
                } else {
                    for (int j = 0; j < k && !queue.isEmpty(); j++) {
                        sum += queue.remove();
                    }
                    queue.clear();
                    queue.add(ai);
                }
                prev = c;
            }
            for (int j = 0; j < k && !queue.isEmpty(); j++) {
                sum += queue.remove();
            }
            System.out.println(sum);
        }
    }
}