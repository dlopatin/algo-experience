package com.dlopatin.uva.datastructures.nonlineards.p00978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=11&page=show_problem&problem=919
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());
            PriorityQueue<Integer> green = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> blue = new PriorityQueue<>(Comparator.reverseOrder());
            while (t-- > 0) {
                green.clear();
                blue.clear();
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int b = Integer.parseInt(tokenizer.nextToken());
                int sg = Integer.parseInt(tokenizer.nextToken());
                int sb = Integer.parseInt(tokenizer.nextToken());
                while (sg-- > 0) {
                    green.add(Integer.parseInt(reader.readLine()));
                }
                while (sb-- > 0) {
                    blue.add(Integer.parseInt(reader.readLine()));
                }
                int peopleInRound = Math.min(b, Math.min(green.size(), blue.size()));
                List<Integer> greenSurvived = new ArrayList<>(peopleInRound);
                List<Integer> blueSurvived = new ArrayList<>(peopleInRound);
                while (peopleInRound > 0) {
                    greenSurvived.clear();
                    blueSurvived.clear();
                    for (int i = 0; i < peopleInRound; i++) {
                        int result = green.poll() - blue.poll();
                        if (result > 0) {
                            greenSurvived.add(result);
                        } else if (result < 0) {
                            blueSurvived.add(-result);
                        }
                    }
                    blue.addAll(blueSurvived);
                    green.addAll(greenSurvived);
                    peopleInRound = Math.min(b, Math.min(green.size(), blue.size()));
                }
                StringBuilder res = new StringBuilder();
                if (green.size() == 0 && blue.size() == 0) {
                    res.append("green and blue died");
                } else if (green.size() > 0) {
                    res.append("green wins\n");
                    print(green, res);
                } else {
                    res.append("blue wins\n");
                    print(blue, res);
                }
                System.out.println(res.toString().trim() + (t > 0 ? "\n" : ""));
            }
        }
    }

    private static void print(PriorityQueue<?> priorityQueue, StringBuilder builder) {
        while (!priorityQueue.isEmpty()) {
            builder.append(priorityQueue.poll()).append("\n");
        }
    }
}
