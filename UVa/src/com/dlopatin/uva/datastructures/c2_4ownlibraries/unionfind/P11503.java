package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=27&page=show_problem&problem=2498
 * Union find
 */
public class P11503 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                StringBuilder builder = new StringBuilder();
                int formers = Integer.parseInt(reader.readLine());
                UnionFind unionFind = new UnionFind(2 * formers);
                while (formers-- > 0) {
                    StringTokenizer names = new StringTokenizer(reader.readLine());
                    int i = unionFind.unionSet(names.nextToken(), names.nextToken());
                    builder.append(unionFind.sizeOfSet(i)).append("\n");
                }
                System.out.println(builder.toString().trim());
            }
        }
    }

    public static class UnionFind {
        private final int p[];
        private final int rank[];
        private final int size[];
        private final Map<String, Integer> idList;
        private int id;

        public UnionFind(int n) {
            p = new int[n];
            rank = new int[n];
            size = new int[n];
            idList = new HashMap<>(n + 1);
            for (int i = 0; i < p.length; i++) {
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

        public int unionSet(String name1, String name2) {
            int i = getIdByName(name1);
            int j = getIdByName(name2);
            if (!isSameSet(i, j)) {
                int rootI = findSet(i);
                int rootJ = findSet(j);
                if (rank[rootI] > rank[rootJ]) {
                    p[rootJ] = rootI;
                    size[rootI] += size[rootJ];
                    return rootI;
                } else {
                    p[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                    if (rank[rootI] == rank[rootJ]) {
                        rank[rootJ]++;
                    }
                    return rootJ;
                }
            }
            return findSet(i);
        }

        private int getIdByName(String name) {
            return idList.compute(name, (n, thisId) -> thisId == null ? id++ : thisId);
        }

        public int sizeOfSet(int i) {
            return size[i];
        }

    }
}
