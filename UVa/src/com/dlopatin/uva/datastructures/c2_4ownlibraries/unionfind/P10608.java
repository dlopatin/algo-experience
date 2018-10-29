package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=18&page=show_problem&problem=1549
 * Union find
 */
public class P10608 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = parseInt(reader.readLine());
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                StringTokenizer nm = new StringTokenizer(reader.readLine());
                int n = parseInt(nm.nextToken());
                int m = parseInt(nm.nextToken());
                DisjointSet disjointSet = new DisjointSet(n);
                while (m-- > 0) {
                    StringTokenizer pair = new StringTokenizer(reader.readLine());
                    disjointSet.unionSets(parseInt(pair.nextToken()) - 1, parseInt(pair.nextToken()) - 1);
                }
                sb.append(disjointSet.findLargestSetCnt()).append("\n");
            }
            System.out.print(sb);
        }
    }

    public static class DisjointSet {
        private final int p[];
        private final int rank[];
        private final int cnt[];

        public DisjointSet(int n) {
            p = new int[n];
            rank = new int[n];
            cnt = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                cnt[i] = 1;
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
                    cnt[ri] += cnt[rj];
                } else {
                    p[ri] = rj;
                    if (rank[ri] == rank[rj]) {
                        rank[rj]++;
                    }
                    cnt[rj] += cnt[ri];
                }
            }
        }

        public int findLargestSetCnt() {
            int largest = 0;
            for (int i = 0; i < cnt.length; i++) {
                if (p[i] == i) {
                    largest = Math.max(largest, cnt[i]);
                }
            }
            return largest;
        }
    }


}
