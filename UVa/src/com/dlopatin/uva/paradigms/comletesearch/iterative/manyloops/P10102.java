package com.dlopatin.uva.paradigms.comletesearch.iterative.manyloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1043
 * The path in the colored field
 */
public class P10102 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int n = Integer.parseInt(line);
                Map<Integer, List<Integer>> ones = new HashMap<>();
                Map<Integer, List<Integer>> threes = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    String matrixLine = reader.readLine();
                    for (int j = 0; j < n; j++) {
                        char element = matrixLine.charAt(j);
                        if ('1' == element) {
                            ones.computeIfAbsent(i, stub -> new ArrayList<>()).add(j);
                        } else if ('3' == element) {
                            threes.computeIfAbsent(i, stub -> new ArrayList<>()).add(j);
                        }
                    }
                }
                AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
                ones.forEach((i1, j1List) ->
                        j1List.forEach(j1 -> {
                            AtomicInteger dist = new AtomicInteger(Integer.MAX_VALUE);
                            threes.forEach((i3, j3List) ->
                                    j3List.forEach(j3 ->
                                            dist.set(Math.min(dist.get(), Math.abs(i1 - i3) + Math.abs(j1 - j3)))));
                            max.set(Math.max(max.get(), dist.get()));
                        }));

                result.append(max.get()).append("\n");
            }
            System.out.print(result);
        }
    }


}
