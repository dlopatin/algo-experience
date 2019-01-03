package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2408
 * Fill the Containers
 */
public class P11403 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer nm = new StringTokenizer(line);
                int n = parseInt(nm.nextToken());
                int m = parseInt(nm.nextToken());
                int maxV = 0;
                int sum = 0;
                int[] v = new int[n];
                StringTokenizer vTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    int vi = parseInt(vTokens.nextToken());
                    v[i] = vi;
                    maxV = Math.max(maxV, vi);
                    sum += vi;
                }

                int lo = maxV;
                int hi = sum;
                int sol = 0;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (can(mid, v, m)) {
                        sol = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                result.append(sol).append("\n");
            }
            System.out.print(result);
        }
    }


    private static boolean can(int capacity, int[] v, int totalContainers) {
        int containers = 1;
        int currentContainerCapacity = 0;
        for (int volume : v) {
            if (volume + currentContainerCapacity > capacity) {
                currentContainerCapacity = 0;
                containers++;
            }
            if (containers > totalContainers) {
                return false;
            }
            currentContainerCapacity += volume;
        }
        return true;
    }


}
