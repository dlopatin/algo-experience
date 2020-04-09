package com.dlopatin.numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongFlowOddDetector {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                long num = Long.parseLong(line);
                int key1 = (int) (num >>> 32);
                int key2 = (int) num;
//                System.out.println(longToString(num, 4));
//                System.out.println(intToString(key1, 4));
//                System.out.println(intToString(key2, 4));
                Set<Integer> set = map.computeIfAbsent(key1, dummy -> new HashSet<>());
                if (!set.remove(key2)) {
                    set.add(key2);
                } else if (set.isEmpty()) {
                    map.remove(key1);
                }
            }
            map.forEach((k1, k2Set) -> k2Set.forEach(k2 -> System.out.println((long) k1 << 32 | k2)));

        }

    }

    public static String longToString(long number, int groupSize) {
        StringBuilder result = new StringBuilder();

        for (int i = 63; i >= 0; i--) {
            long mask = 1L << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0) {
                result.append(" ");
            }
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }

    public static String intToString(int number, int groupSize) {
        StringBuilder result = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0) {
                result.append(" ");
            }
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }
}
