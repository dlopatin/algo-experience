package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1508
 * Helping Fill Bates
 */
public class P10567 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] data = reader.readLine().toCharArray();
            Map<Character, List<Integer>> letterOccur = new HashMap<>();
            for (int i = 0; i < data.length; i++) {
                letterOccur.computeIfAbsent(data[i], stub -> new ArrayList<>()).add(i);
            }
            StringBuilder result = new StringBuilder();
            int q = parseInt(reader.readLine());
            while (q-- > 0) {
                char[] query = reader.readLine().toCharArray();
                int firstIdx = 0;
                int latestIdx = 0;
                boolean ok = true;
                for (int i = 0; i < query.length; i++) {
                    char ch = query[i];
                    int idx = binSearch(letterOccur.get(ch), latestIdx);
                    if (i == 0) {
                        firstIdx = idx;
                    }
                    if (idx >= latestIdx) {
                        latestIdx = idx + 1;
                    } else {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    result.append("Matched ").append(firstIdx).append(" ").append(latestIdx - 1);
                } else {
                    result.append("Not matched");
                }
                result.append("\n");
            }
            System.out.print(result);
        }

    }

    private static int binSearch(List<Integer> array, int minTarget) {
        int l = 0;
        int r = array.size() - 1;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int midValue = array.get(mid);
            if (midValue == minTarget) {
                return midValue;
            }

            if (midValue < minTarget) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }
        }
        return result == -1 ? result : array.get(result);
    }


}
