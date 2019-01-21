package com.dlopatin.uva.paradigms.dp.max1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1625
 * The jackpot
 */
public class P10684 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0".equals(line.trim())) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                int n = parseInt(line);
                int localSum = 0;
                int globalSum = Integer.MIN_VALUE;
                StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    if (!dataTokens.hasMoreTokens()) {
                        dataTokens = new StringTokenizer(reader.readLine());
                    }
                    int val = parseInt(dataTokens.nextToken());
                    localSum = Math.max(val, localSum + val);
                    globalSum = Math.max(globalSum, localSum);
                }
                result.append(globalSum > 0
                        ? String.format("The maximum winning streak is %d.", globalSum)
                        : "Losing streak."
                ).append("\n");
            }
            System.out.print(result);
        }
    }
}

