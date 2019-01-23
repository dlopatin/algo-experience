package com.dlopatin.codeforce.div2.r269;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/471/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            Pair[] tasks = new Pair[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Pair(scanner.nextInt(), i + 1);
            }
            Arrays.sort(tasks);
            int counter = 1;
            String[] res = new String[3];
            res[0] = toString(tasks);
            for (int i = 1; i < n && counter < 3; i++) {
                if (tasks[i - 1].getPriority() == tasks[i].getPriority()) {
                    Pair temp = tasks[i - 1];
                    tasks[i - 1] = tasks[i];
                    tasks[i] = temp;
                    res[counter++] = toString(tasks);
                }
            }
            if (counter == 3) {
                System.out.println("YES");
                for (int i = 0; i < 3; i++) {
                    System.out.println(res[i]);
                }
            } else {
                System.out.println("NO");
            }

        }
    }

    private String toString(Pair[] tasks) {
        StringBuilder res = new StringBuilder();
        for (Pair task : tasks) {
            res.append(task.getPos()).append(" ");
        }
        return res.toString().trim();
    }

    private class Pair implements Comparable<Pair> {

        private final int priority;
        private final int pos;

        public Pair(int priority, int pos) {
            this.priority = priority;
            this.pos = pos;
        }

        public int getPriority() {
            return priority;
        }

        public int getPos() {
            return pos;
        }

        @Override
        public int compareTo(Pair o) {
            return priority - o.priority;
        }
    }

}
