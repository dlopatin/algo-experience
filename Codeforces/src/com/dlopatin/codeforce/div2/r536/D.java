package com.dlopatin.codeforce.div2.r536;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1106/problem/D
 */
public class D {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nm = new StringTokenizer(reader.readLine());
            int n = parseInt(nm.nextToken());
            int m = parseInt(nm.nextToken());
            Map<Integer, Set<Integer>> edges = new HashMap<>(n);
            for (int i = 0; i < m; i++) {
                StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
                int f = parseInt(edgeToken.nextToken());
                int s = parseInt(edgeToken.nextToken());
                edges.computeIfAbsent(f, key -> new TreeSet<>()).add(s);
                edges.computeIfAbsent(s, key -> new TreeSet<>()).add(f);
            }

            List<Integer> bfs = bfs(1, edges, n);
            StringBuilder result = new StringBuilder();
            for (int i : bfs) {
                result.append(i).append(" ");
            }
            System.out.println(result.deleteCharAt(result.length() - 1));

        }
    }

    private static List<Integer> bfs(int start, Map<Integer, Set<Integer>> edges, int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            ans.add(node);
            for (int child : edges.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
        return ans;
    }


}