package com.dlopatin.codeforce.div3.r535;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1108/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int n = parseInt(reader.readLine());
            StringTokenizer dataTk = new StringTokenizer(reader.readLine());
            int[] data = new int[n];
            for (int i = 0; i < data.length; i++) {
                data[i] = parseInt(dataTk.nextToken());
            }
            Arrays.sort(data);
            int first = data[n - 1];
            int second = -1;
            for (int i = data.length - 2; i >= 0; i--) {
                if (first % data[i] != 0 || data[i + 1] == data[i]) {
                    second = data[i];
                    break;
                }
            }
            System.out.printf("%d %d\n", first, second);
        }
    }
}