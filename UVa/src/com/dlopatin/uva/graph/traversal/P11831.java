package com.dlopatin.uva.graph.traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2931
 * Sticker Collector Robots
 */
public class P11831 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            List<Character> startPos = Arrays.asList('N', 'S', 'L', 'O');
            int[] di = {-1, 0, 1, 0};
            int[] dj = {0, -1, 0, 1};
            String line;
            while ((line = reader.readLine()) != null && !"0 0 0".equals(line)) {
                StringTokenizer nms = new StringTokenizer(line);
                int n = parseInt(nms.nextToken());
                int m = parseInt(nms.nextToken());
                int s = parseInt(nms.nextToken());
                char[][] data = new char[n][m];
                int si = 0;
                int sj = 0;
                int dir = 0;
                for (int i = 0; i < n; i++) {
                    char[] chars = reader.readLine().toCharArray();
                    for (int j = 0; j < m; j++) {
                        char in = chars[j];
                        if (startPos.contains(in)) {
                            si = i;
                            sj = j;
                            dir = in == 'N' ? 0 : in == 'L' ? 3 : in == 'S' ? 2 : 1;
                        }
                        data[i][j] = in;
                    }
                }
                String cmds = reader.readLine();
                int cnt = 0;
                for (char cmd : cmds.toCharArray()) {
                    if (cmd == 'D') {
                        dir = (dir + 4 - 1) % 4;
                    } else if (cmd == 'E') {
                        dir = (dir + 1) % 4;
                    } else {
                        int y = si + di[dir];
                        int x = sj + dj[dir];
                        if (x >= 0 && x < m && y >= 0 && y < n && data[y][x] != '#') {
                            si = y;
                            sj = x;
                            if (data[si][sj] == '*') {
                                cnt++;
                                data[si][sj] = '.';
                            }
                        }
                    }
                }
                result.append(cnt).append("\n");
            }
            System.out.print(result);
        }

    }

}

