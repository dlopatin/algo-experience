package com.dlopatin.uva.datastructures.c2_4ownlibraries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=20&page=show_problem&problem=1836
 */
public class P10895 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                int m = Integer.parseInt(tokenizer.nextToken());
                int n = Integer.parseInt(tokenizer.nextToken());
                List<List<Edge>> graph = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    graph.add(new ArrayList<>());
                }
                for (int i = 0; i < m; i++) {
                    String l1 = reader.readLine();
                    String l2 = reader.readLine();
                    StringTokenizer idx = new StringTokenizer(l1);
                    int cnt = Integer.parseInt(idx.nextToken());
                    StringTokenizer vals = new StringTokenizer(l2);
                    for (int j = 0; j < cnt; j++) {
                        graph.get(Integer.parseInt(idx.nextToken()) - 1).add(new Edge(i, vals.nextToken()));
                    }
                }

                // print
                StringBuilder builder = new StringBuilder(n + " " + m);
                builder.append("\n");
                for (List<Edge> edges : graph) {
                    builder.append(edges.size());
                    edges.forEach(edge -> builder.append(" ").append(edge.v + 1));
                    builder.append("\n");
                    for (int i = 0; i < edges.size(); i++) {
                        builder.append(edges.get(i).w);
                        if (i < edges.size() - 1) {
                            builder.append(" ");
                        }
                    }
                    builder.append("\n");
                }
                System.out.print(builder.toString());
            }
        }
    }

    private static class Edge {
        int v;
        String w;

        private Edge(int v, String w) {
            this.v = v;
            this.w = w;
        }

    }

}
