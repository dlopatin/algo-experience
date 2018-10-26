package com.dlopatin.uva.datastructures.nonlineards.p11136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=23&page=show_problem&problem=2077
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = 0;
            TreeMap<Integer, Integer> bills = new TreeMap<>();
            while ((t = Integer.parseInt(reader.readLine())) != 0) {
                bills.clear();
                long sum = 0;
                while (t-- > 0) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    int k = Integer.parseInt(tokenizer.nextToken());
                    for (int i = 0; i < k; i++) {
                        int amount = Integer.parseInt(tokenizer.nextToken());
                        bills.compute(amount, (key, v) -> v == null ? 1 : v + 1);
                    }
                    Integer firstKey = bills.firstKey();
                    Integer lastKey = bills.lastKey();
                    sum += lastKey - firstKey;
                    Integer v1 = bills.get(firstKey);
                    if (v1 == 1) {
                        bills.pollFirstEntry();
                    } else {
                        bills.put(firstKey, v1 - 1);
                    }
                    Integer v2 = bills.get(lastKey);
                    if (v2 == 1) {
                        bills.pollLastEntry();
                    } else {
                        bills.put(lastKey, v2 - 1);
                    }
                }
                System.out.println(sum);
            }
        }
    }
}
