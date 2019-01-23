package com.dlopatin.codeforce.div2.r222;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/378/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            Time[] times = new Time[n * 2];
            long[] firstSem = new long[n];
            long[] secSem = new long[n];
            for (int i = 0; i < n; i++) {
                long firstRes = scanner.nextLong();
                firstSem[i] = firstRes;
                long secondRes = scanner.nextLong();
                secSem[i] = secondRes;
                times[i * 2] = new Time(i, firstRes, 1);
                times[i * 2 + 1] = new Time(i, secondRes, 2);
            }
            Arrays.sort(times);
            int[] resFirst = new int[n];
            int[] resSecond = new int[n];
            int finals = n / 2;
            for (int i = 0; i < finals; i++) {
                resFirst[i] = 1;
                resSecond[i] = 1;
            }
            for (int i = 0; i < n; i++) {
                int id = times[i].getId();
                if (times[i].getDiv() == 1) {
                    resFirst[id] = 1;
                } else {
                    resSecond[id] = 1;
                }
            }
            System.out.println(convertToString(resFirst));
            System.out.println(convertToString(resSecond));
        }
    }

    private String convertToString(int array[]) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            res.append(array[i]);
        }
        return res.toString();
    }

    private static class Time implements Comparable<Time> {
        private final long time;
        private final int id;
        private final int div;

        public Time(int id, long time, int div) {
            this.id = id;
            this.time = time;
            this.div = div;
        }

        public long getTime() {
            return time;
        }

        public int getId() {
            return id;
        }

        public int getDiv() {
            return div;
        }

        @Override
        public int compareTo(Time o) {
            return (int) (time - o.time);
        }

    }

}
