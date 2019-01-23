package com.dlopatin.codeforce.div3.r535;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1108/problem/A
 */
public class A {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                StringTokenizer dataTk = new StringTokenizer(reader.readLine());
                int[] data = new int[4];
                for (int i = 0; i < data.length; i++) {
                    data[i] = parseInt(dataTk.nextToken());
                }
                int a = 0;
                int b = 0;
                boolean found = false;
                for (int i = data[0]; i <= data[1] && !found; i++) {
                    for (int j = data[2]; j <= data[3] && !found; j++) {
                        if (i != j) {
                            a = i;
                            b = j;
                            found = true;
                        }
                    }
                }
                result.append(a).append(" ").append(b).append("\n");
            }
            System.out.print(result);
        }
    }
}