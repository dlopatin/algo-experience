package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=18&page=show_problem&problem=1626
 * Union find
 */
public class P10685 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String cr;
            while ((cr = reader.readLine()) != null && !"0 0".equals(cr)) {
                StringTokenizer crTokens = new StringTokenizer(cr);
                int c = Integer.parseInt(crTokens.nextToken());
                int r = Integer.parseInt(crTokens.nextToken());
                DisjointSet disjointSet = new DisjointSet(c);
                while (c-- > 0) {
                    reader.readLine(); // don't need those data
                }
                while (r-- > 0) {
                    StringTokenizer relation = new StringTokenizer(reader.readLine());
                    disjointSet.unionSet(relation.nextToken(), relation.nextToken());
                }
                System.out.println(disjointSet.findLargestCnt());
                reader.readLine();
            }
        }
    }

    public static class DisjointSet {
        private final int[] p;
        private final int[] rank;
        private final int size[];
        private final Map<String, Integer> ids;

        private int id = 0;

        public DisjointSet(int n) {
            p = new int[n];
            rank = new int[n];
            size = new int[n];
            ids = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int findSet(int i) {
            return p[i] == i ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(String creature1, String creature2) {
            int i = getCreature(creature1);
            int j = getCreature(creature2);
            if (!isSameSet(i, j)) {
                int ri = findSet(i);
                int rj = findSet(j);
                if (rank[ri] > rank[rj]) {
                    p[rj] = ri;
                    size[ri] += size[rj];
                } else {
                    p[ri] = rj;
                    if (rank[ri] == rank[rj]) {
                        rank[rj]++;
                    }
                    size[rj] += size[ri];
                }
            }
        }

        public int findLargestCnt() {
            int largest = 0;
            for (int i = 0; i < p.length; i++) {
                if (p[i] == i) {
                    largest = Math.max(largest, size[i]);
                }
            }
            return largest;
        }

        private int getCreature(String name) {
            return ids.compute(name, (k, storedId) -> storedId == null ? id++ : storedId);
        }
    }

}
