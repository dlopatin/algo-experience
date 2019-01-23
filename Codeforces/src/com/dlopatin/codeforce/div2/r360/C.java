package com.dlopatin.codeforce.div2.r360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * http://codeforces.com/contest/688/problem/C
 */
public class C {

    public static void main(String[] args) {
        new C().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                edges[i] = new Edge(u, v);
            }
            boolean[] swapped = new boolean[m];
            Set<Integer> a = new HashSet<>();
            Set<Integer> b = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int u = edges[i].u;
                int v = edges[i].v;
                edges[i] = new Edge(u, v);
                if ((a.contains(u) && a.contains(v)) || (b.contains(u) && b.contains(v))) {
                    if (swapped[i]) {
                        System.out.println(-1);
                        return;
                    } else {
                        swapped[i] = true;
                    }
                }
                if (a.contains(u)) {
                    b.add(v);
                } else if (b.contains(u)) {
                    a.add(v);
                } else if (a.contains(v)) {
                    b.add(u);
                } else if (b.contains(v)) {
                    a.add(u);
                } else {
                    a.add(u);
                    b.add(v);
                }
            }
            System.out.println(a.size());
            System.out.println(a.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            System.out.println(b.size());
            System.out.println(b.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    private static class Edge {

        private final int u;
        private final int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

    }

}