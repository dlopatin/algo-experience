package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=17&page=show_problem&problem=1448
 * Union find
 */
public class P10507 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int n = Integer.parseInt(line);
                int m = Integer.parseInt(reader.readLine());
                UnionFind unionFind = new UnionFind(27);
                char[] init = reader.readLine().toCharArray();
                unionFind.unionSet(init[0] - 'A', init[1] - 'A');
                unionFind.unionSet(init[1] - 'A', init[2] - 'A');
                int activeRoot = unionFind.findSet(init[0] - 'A');
                Map<Integer, List<Integer>> connections = new HashMap<>(n);
                while (m-- > 0) {
                    String connection = reader.readLine();
                    int first = connection.charAt(0) - 'A';
                    int second = connection.charAt(1) - 'A';
                    connections.computeIfAbsent(first, stub -> new ArrayList<>()).add(second);
                    connections.computeIfAbsent(second, stub -> new ArrayList<>()).add(first);
                }

                int years = 0;
                int active = 3;
                while (true) {
                    List<Integer> toActivate = new ArrayList<>();
                    connections.forEach((id, edges) -> {
                        if (!unionFind.isSameSet(activeRoot, id)) {
                            long numOfConnections = edges.stream()
                                    .filter(node -> unionFind.isSameSet(activeRoot, node))
                                    .count();
                            if (numOfConnections >= 3) {
                                toActivate.add(id);
                            }
                        }
                    });
                    if (!toActivate.isEmpty()) {
                        toActivate.forEach(node -> unionFind.unionSet(activeRoot, node));
                        years++;
                        active += toActivate.size();
                    } else {
                        break;
                    }
                }
                System.out.println(active == n
                        ? String.format("WAKE UP IN, %d, YEARS", years)
                        : "THIS BRAIN NEVER WAKES UP");
                reader.readLine();
            }
        }
    }

    public static class UnionFind {
        private final int p[];
        private final int rank[];

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
            rank = new int[n];
        }

        public int findSet(int i) {
            return p[i] == i ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                int rootI = findSet(i);
                int rootJ = findSet(j);
                if (rank[rootI] > rank[rootJ]) {
                    p[rootJ] = rootI;
                } else {
                    p[rootI] = rootJ;
                    if (rank[rootI] == rank[rootJ]) {
                        rank[rootJ]++;
                    }
                }
            }
        }
    }
}
