package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2231
 * Coin Collector
 */
public class P11264 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int n = parseInt(reader.readLine());
                StringTokenizer coinTokens = new StringTokenizer(reader.readLine());
                int money = 0;
                int cnt = 0;
                int prev = 0;
                for (int i = 0; i < n; i++) {
                    int coin = parseInt(coinTokens.nextToken());
                    if (money + prev < coin) {
                        cnt++;
                        money += prev;
                    }
                    prev = coin;
                }
                result.append(cnt).append("\n");
            }
            System.out.print(result);
        }

    }

}
