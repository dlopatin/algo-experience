package com.dlopatin.codeforce.div2.r368;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/707/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            if (k == 0 || k == n) {
                System.out.println(-1);
                return;
            }
            List<Vertex> vertexes = new ArrayList<>(n);
            for (int i = 0; i < m; i++) {
                int v1 = scanner.nextInt() - 1;
                int v2 = scanner.nextInt() - 1;
                int l = scanner.nextInt();
                vertexes.add(new Vertex(v1, v2, l));
            }
            Map<Integer, Integer> storages = new HashMap<>(k);
            for (int i = 0; i < k; i++) {
                storages.put(scanner.nextInt() - 1, Integer.MAX_VALUE);
            }
            for (Vertex vertex : vertexes) {
                Integer v1 = storages.get(vertex.getV1());
                Integer v2 = storages.get(vertex.getV2());
                if (v1 == null && v2 != null) {
                    storages.put(vertex.getV2(), Math.min(v2, vertex.getLength()));
                } else if (v1 != null && v2 == null) {
                    storages.put(vertex.getV1(), Math.min(v1, vertex.getLength()));
                }
            }
            Integer min = storages.values().stream().min(Comparator.naturalOrder()).get();
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }

    private static class Vertex {
        private final int v1;
        private final int v2;
        private final int length;

        public Vertex(int v1, int v2, int length) {
            this.v1 = v1;
            this.v2 = v2;
            this.length = length;
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

        public int getLength() {
            return length;
        }

    }

}