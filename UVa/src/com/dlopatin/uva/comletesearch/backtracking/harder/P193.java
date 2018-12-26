package com.dlopatin.uva.comletesearch.backtracking.harder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=129
 * Graph Coloring
 */
public class P193 {
    private static StringBuilder sol;
    private static int maxSum = 0;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int m = parseInt(reader.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer nk = new StringTokenizer(reader.readLine());
                int nodesCnt = parseInt(nk.nextToken());
                int edgesCnt = parseInt(nk.nextToken());
                Map<Integer, List<Integer>> edges = new HashMap<>(nodesCnt);
                for (int j = 0; j < edgesCnt; j++) {
                    StringTokenizer edgesTokens = new StringTokenizer(reader.readLine());
                    int first = parseInt(edgesTokens.nextToken());
                    int second = parseInt(edgesTokens.nextToken());
                    edges.computeIfAbsent(first, stub -> new ArrayList<>()).add(second);
                    edges.computeIfAbsent(second, stub -> new ArrayList<>()).add(first);
                }

                maxSum = 0;
                sol = new StringBuilder();
                backtrack(1, 0, new boolean[nodesCnt + 1], nodesCnt, edges);
                result.append(maxSum).append("\n");
                result.append(sol).append("\n");
            }
            System.out.print(result);
        }
    }

    private static void backtrack(int idx, int sum, boolean[] black, int nodesCnt, Map<Integer, List<Integer>> edges) {
        if (idx == nodesCnt + 1) {
            if (sum > maxSum) {
                maxSum = sum;
                StringBuilder data = new StringBuilder();
                for (int i = 1; i < black.length; i++) {
                    if (black[i]) {
                        data.append(i).append(" ");
                    }
                }
                data.deleteCharAt(data.length() - 1);
                sol = data;
            }
            return;
        }
        // if can colour node in black
        if (!hasBlackNeighbours(idx, black, edges)) {
            black[idx] = true;
            backtrack(idx + 1, sum + 1, black, nodesCnt, edges);
            black[idx] = false;
        }
        // always check other cases even if node wasn't coloured
        backtrack(idx + 1, sum, black, nodesCnt, edges);
    }

    private static boolean hasBlackNeighbours(int idx, boolean[] black, Map<Integer, List<Integer>> edges) {
        for (int node : edges.getOrDefault(idx, Collections.emptyList())) {
            if (black[node]) {
                return true;
            }
        }
        return false;
    }
}
