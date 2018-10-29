package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=17&page=show_problem&problem=1524
 * Union find
 */
public class P10583 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            StringBuilder sb = new StringBuilder();
            int caseId = 1;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer nm = new StringTokenizer(line);
                int n = Integer.parseInt(nm.nextToken());
                int m = Integer.parseInt(nm.nextToken());
                DisjointSet disjointSet = new DisjointSet(n);
                while (m-- > 0) {
                    StringTokenizer pair = new StringTokenizer(reader.readLine());
                    disjointSet.unionSets(parseInt(pair.nextToken()) - 1, parseInt(pair.nextToken()) - 1);
                }
                sb.append(String.format("Case %d: %d", caseId, disjointSet.findSetsCnt())).append("\n");
                caseId++;
            }
            System.out.print(sb);
        }
    }

    public static class DisjointSet {
        private final int p[];
        private final int rank[];

        public DisjointSet(int n) {
            p = new int[n];
            rank = new int[n];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
        }

        public int findSet(int i) {
            return p[i] == i ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSets(int i, int j) {
            if (!isSameSet(i, j)) {
                int ri = findSet(i);
                int rj = findSet(j);
                if (rank[ri] > rank[rj]) {
                    p[rj] = ri;
                } else {
                    p[ri] = rj;
                    if (rank[ri] == rank[rj]) {
                        rank[rj]++;
                    }
                }
            }
        }

        public int findSetsCnt() {
            int cnt = 0;
            for (int i = 0; i < p.length; i++) {
                if (p[i] == i) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
