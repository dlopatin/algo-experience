package com.dlopatin.uva.datastructures.c2_4ownlibraries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=229&page=show_problem&problem=3142
 */
public class P11991 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                int n = Integer.parseInt(tokenizer.nextToken());
                int m = Integer.parseInt(tokenizer.nextToken());
                Map<Integer, List<Integer>> graph = new HashMap<>(n);
                StringTokenizer numbers = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    graph.computeIfAbsent(Integer.parseInt(numbers.nextToken()), ignore -> new ArrayList<>()).add(i);
                }

                StringBuilder builder = new StringBuilder();
                while (m-- > 0) {
                    StringTokenizer task = new StringTokenizer(reader.readLine());
                    int occur = Integer.parseInt(task.nextToken());
                    int number = Integer.parseInt(task.nextToken());
                    List<Integer> idxs = graph.get(number);
                    if (idxs != null && idxs.size() >= occur) {
                        builder.append(idxs.get(occur - 1) + 1);
                    } else {
                        builder.append(0);
                    }
                    builder.append("\n");
                }
                System.out.print(builder);
            }
        }
    }

}
