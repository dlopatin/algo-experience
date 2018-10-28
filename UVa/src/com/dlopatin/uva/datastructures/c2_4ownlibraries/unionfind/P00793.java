package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=9&page=show_problem&problem=734
 * Union find
 */
public class P00793 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());
            reader.readLine();
            while (t > 0) {
                int n = Integer.parseInt(reader.readLine());
                UnionFind unionFind = new UnionFind(n);
                int cntPositive = 0;
                int cntNegative = 0;
                String command;
                while ((command = reader.readLine()) != null && !command.isEmpty()) {
                    StringTokenizer cmd = new StringTokenizer(command);
                    String action = cmd.nextToken();
                    int i = Integer.parseInt(cmd.nextToken()) - 1;
                    int j = Integer.parseInt(cmd.nextToken()) - 1;
                    if ("c".equals(action)) {
                        unionFind.unionSet(i, j);
                    } else {
                        int dump = unionFind.isSameSet(i, j) ? cntPositive++ : cntNegative++;
                    }
                }
                System.out.printf("%d,%d\n", cntPositive, cntNegative);
                t--;
                if (t > 0) {
                    System.out.println();
                }
            }
        }
    }

    public static class UnionFind {
        private final int[] p;
        private final int[] rank;

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
