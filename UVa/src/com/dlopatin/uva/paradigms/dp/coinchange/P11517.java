package com.dlopatin.uva.paradigms.dp.coinchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2512
 * Exact Change
 */
public class P11517 {

    private static Result[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int s = parseInt(reader.readLine());
                int n = parseInt(reader.readLine());
                dp = new Result[s + 1][n];
                int[] value = new int[n];
                for (int i = 0; i < n; i++) {
                    value[i] = parseInt(reader.readLine());
                }
                Result sol = change(n - 1, s, value);
                result.append(sol.amount).append(" ").append(sol.coins).append("\n");
            }
            System.out.print(result);
        }
    }

    private static Result change(int idx, int money, int[] value) {
        if (money <= 0) {
            return Result.empty();
        }
        if (idx < 0) {
            return Result.big();
        }
        if (dp[money][idx] != null) {
            return dp[money][idx];
        }
        Result take = change(idx - 1, money - value[idx], value);
        take.amount += value[idx];
        take.coins++;
        Result doNotTake = change(idx - 1, money, value);
        Result min = Result.min(take, doNotTake);
        dp[money][idx] = min;
        return Result.copyOf(min);
    }

    private static class Result {
        private int amount;
        private int coins;

        private static Result empty() {
            return new Result(0, 0);
        }

        private static Result big() {
            return new Result(1000_000, 1000_000);
        }

        private static Result copyOf(Result other) {
            return new Result(other.amount, other.coins);
        }

        public static Result min(Result first, Result second) {
            if (first.amount == second.amount) {
                return first.coins < second.coins ? first : second;
            }
            return first.amount < second.amount ? first : second;
        }

        Result(int amount, int coins) {
            this.amount = amount;
            this.coins = coins;
        }

    }

}

