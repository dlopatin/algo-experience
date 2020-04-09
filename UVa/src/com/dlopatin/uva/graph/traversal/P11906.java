package com.dlopatin.uva.graph.traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3057
 * Knight in War Grid
 */
public class P11906 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            for (int caseIdx = 1; caseIdx <= t; caseIdx++) {
                StringTokenizer tokens = new StringTokenizer(reader.readLine());
                int r = parseInt(tokens.nextToken());
                int c = parseInt(tokens.nextToken());
                int m = parseInt(tokens.nextToken());
                int n = parseInt(tokens.nextToken());
                int w = parseInt(reader.readLine());
                int[][] water = new int[r][c];
                while (w-- > 0) {
                    StringTokenizer wTokens = new StringTokenizer(reader.readLine());
                    water[parseInt(wTokens.nextToken())][parseInt(wTokens.nextToken())] = 1;
                }

                int odd = 0;
                int even = 0;
                boolean[][] visited = new boolean[r][c];
                Queue<Integer> iQueue = new LinkedList<>();
                Queue<Integer> jQueue = new LinkedList<>();
                visited[0][0] = true;
                iQueue.add(0);
                jQueue.add(0);

                while (!iQueue.isEmpty() && !jQueue.isEmpty()) {
                    int i = iQueue.remove();
                    int j = jQueue.remove();
                    

                }

            }

            System.out.print(result);
        }
    }

}
