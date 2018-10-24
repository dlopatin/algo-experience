package com.dlopatin.uva.datastructures.nonlineards.p11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2261
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Main.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n;
            Map<String, Integer> map = new HashMap<>();
            while ((n = Integer.parseInt(reader.readLine())) != 0) {
                map.clear();
                while (n-- > 0) {
                    StringTokenizer token = new StringTokenizer(reader.readLine());
                    String n1 = token.nextToken();
                    String n2 = token.nextToken();
                    String n3 = token.nextToken();
                    String n4 = token.nextToken();
                    String n5 = token.nextToken();
                    String collect = Stream.of(n1, n2, n3, n4, n5).sorted().collect(Collectors.joining());
                    map.compute(collect, (k, v) -> v == null ? 1 : v + 1);
                }
                int[] ints = map.entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(v -> v)
                        .toArray();

                long counter = 0;
                int max = ints[0];
                for (int cnt : ints) {
                    if (cnt < max) {
                        break;
                    }
                    counter += cnt;
                }
                System.out.println(counter);
            }
        }
    }
}
