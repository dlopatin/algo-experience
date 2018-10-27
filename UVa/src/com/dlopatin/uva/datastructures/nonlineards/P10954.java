package com.dlopatin.uva.datastructures.nonlineards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=21&page=show_problem&problem=1895
 */
public class P10954 {

    public static void main(String[] args) throws IOException {
        P10954.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            while (!"0".equals(reader.readLine())) {
                queue.clear();
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                while (tokenizer.hasMoreTokens()) {
                    queue.add(Long.parseLong(tokenizer.nextToken()));
                }
                long sum = 0;
                while (queue.size() > 1) {
                    long n1 = queue.remove();
                    long n2 = queue.remove();
                    long s = n1 + n2;
                    queue.add(s);
                    sum += s;
                }
                System.out.println(sum);
            }
        }
    }

}
