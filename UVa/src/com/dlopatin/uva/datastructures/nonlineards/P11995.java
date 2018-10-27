package com.dlopatin.uva.datastructures.nonlineards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=229&page=show_problem&problem=3146
 */
public class P11995 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Deque<Integer> stack = new LinkedList<>();
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            String cases;
            while ((cases = reader.readLine()) != null && !cases.isEmpty()) {
                stack.clear();
                queue.clear();
                priorityQueue.clear();

                int n = Integer.parseInt(cases);
                boolean isQ = true;
                boolean isS = true;
                boolean isPQ = true;
                while (n-- > 0) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    String command = tokenizer.nextToken();
                    int val = Integer.parseInt(tokenizer.nextToken());
                    if ("1".equals(command)) {
                        if (isS) {
                            stack.push(val);
                        }
                        if (isQ) {
                            queue.add(val);
                        }
                        if (isPQ) {
                            priorityQueue.add(val);
                        }
                    } else if (stack.isEmpty() && queue.isEmpty() && priorityQueue.isEmpty()) {
                        isPQ = false;
                        isQ = false;
                        isS = false;
                    } else {
                        isS = isS && stack.pop() == val;
                        isQ = isQ && queue.remove() == val;
                        isPQ = isPQ && priorityQueue.remove() == val;
                    }
                }
                String res;
                if (isS == isQ ? isS : isPQ) { // at least two from three
                    res = "not sure";
                } else if (!isPQ && !isQ && !isS) {
                    res = "impossible";
                } else if (isPQ) {
                    res = "priority queue";
                } else if (isQ) {
                    res = "queue";
                } else {
                    res = "stack";
                }
                System.out.println(res);
            }
        }
    }

}
