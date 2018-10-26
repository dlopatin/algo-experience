package com.dlopatin.uva.datastructures.nonlineards.p01203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=247&page=show_problem&problem=3644
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = 0;
            PriorityQueue<Query> queue = new PriorityQueue<>();
            String querySt;
            while (!(querySt = reader.readLine()).equals("#")) {
                StringTokenizer tokenizer = new StringTokenizer(querySt);
                tokenizer.nextToken();
                queue.add(new Query(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
            }
            int k = Integer.parseInt(reader.readLine());
            for (int i = 0; i < k; i++) {
                Query polled = queue.remove();
                System.out.println(polled.id);
                queue.add(new Query(polled));
            }
        }
    }

    private static class Query implements Comparable<Query> {
        final int id;
        final int period;
        final int time;

        private Query(int id, int period) {
            this.id = id;
            this.period = period;
            this.time = period;
        }

        private Query(Query other) {
            id = other.id;
            period = other.period;
            time = period + other.time;
        }

        @Override
        public int compareTo(Query q) {
            return Comparator.comparing((Query q1) -> q1.time)
                    .thenComparing((Query q1) -> q1.id)
                    .compare(this, q);
        }

        @Override
        public String toString() {
            return String.format("[%d, %d, %d]", id, period, time);
        }
    }
}
