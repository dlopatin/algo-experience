package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=78&page=show_problem&problem=2737
 * Union find
 */
public class P11690 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                StringTokenizer nm = new StringTokenizer(reader.readLine());
                int n = parseInt(nm.nextToken());
                int m = parseInt(nm.nextToken());
                DisjointSet disjointSet = new DisjointSet(n);
                for (int i = 0; i < n; i++) {
                    disjointSet.addOwe(i, parseInt(reader.readLine()));
                }
                while (m-- > 0) {
                    StringTokenizer owes = new StringTokenizer(reader.readLine());
                    disjointSet.unionSet(parseInt(owes.nextToken()), parseInt(owes.nextToken()));
                }
                System.out.println(disjointSet.isSumZero() ? "POSSIBLE" : "IMPOSSIBLE");
            }

        }
    }

    public static class DisjointSet {
        private final int[] p;
        private final int[] rank;
        private final int[] sum;

        public DisjointSet(int n) {
            p = new int[n];
            rank = new int[n];
            sum = new int[n];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
        }

        public void addOwe(int i, int owe) {
            sum[i] = owe;
        }

        public int findSet(int i) {
            return p[i] == i ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public int unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                int ri = findSet(i);
                int rj = findSet(j);
                if (rank[ri] > rank[rj]) {
                    p[rj] = ri;
                    sum[ri] += sum[rj];
                    return ri;
                } else {
                    p[ri] = rj;
                    if (rank[ri] == rank[rj]) {
                        rank[rj]++;
                    }
                    sum[rj] += sum[ri];
                    return rj;
                }
            }
            return findSet(i);
        }

        public List<Integer> findAllRoots() {
            List<Integer> roots = new ArrayList<>();
            for (int i = 0; i < p.length; i++) {
                if (p[i] == i) {
                    roots.add(i);
                }
            }
            return roots;
        }

        public boolean isSumZero() {
            for (int i = 0; i < p.length; i++) {
                if (p[i] == i) {
                    if (sum[i] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
