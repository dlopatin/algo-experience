package com.dlopatin.uva.datastructures.nonlineards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=27&page=show_problem&problem=2619
 */
public class P11572 {

    public static void main(String[] args) throws IOException {
        P11572.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            while (t-- > 0) {
                map.clear();
                int n = Integer.parseInt(reader.readLine());
                int max = 0;
                int idx = 0;
                int lastOccur = 0;
                while (n-- > 0) {
                    int id = Integer.parseInt(reader.readLine());
                    idx++;
                    if (map.containsKey(id)) {
                        int pos = map.get(id);
                        lastOccur = Math.max(pos, lastOccur);
                    }
                    max = Math.max(max, idx - lastOccur);
                    map.put(id, idx);
                }
                System.out.println(max);
            }
        }
    }
}
