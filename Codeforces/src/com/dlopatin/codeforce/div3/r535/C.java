package com.dlopatin.codeforce.div3.r535;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1108/problem/C
 */
public class C {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            char[] data = reader.readLine().toCharArray();
            String[] cases = new String[]{"RGB", "RBG", "BRG", "BGR", "GRB", "GBR"};
            int minChanges = Integer.MAX_VALUE;
            char[] result = data;
            for (String rgb : cases) {
                int cnt = 0;
                char[] garland = Arrays.copyOf(data, data.length);
                for (int i = 0; i < garland.length; i++) {
                    if (garland[i] != rgb.charAt(i % 3)) {
                        cnt++;
                        garland[i] = rgb.charAt(i % 3);
                    }
                }
                if (cnt < minChanges) {
                    minChanges = cnt;
                    result = garland;
                }
            }
            System.out.printf("%d\n%s", minChanges, new String(result));
        }
    }
}