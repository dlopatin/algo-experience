package com.dlopatin.codeforce.div2.r538;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1114/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nmk = new StringTokenizer(reader.readLine());
            int n = parseInt(nmk.nextToken());
            int m = parseInt(nmk.nextToken());
            int k = parseInt(nmk.nextToken());
            Element[] data = new Element[n];
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            for (int i = 0; i < data.length; i++) {
                data[i] = new Element(parseInt(tokens.nextToken()), i);
            }
            Arrays.sort(data);
            long sum = 0;
            List<Integer> indexes = new ArrayList<>(k * m);
            for (int i = data.length - 1; i >= data.length - m * k; i--) {
                sum += data[i].getValue();
                indexes.add(data[i].getIdx());
            }
            StringBuilder result = new StringBuilder();
            Collections.sort(indexes);
            result.append(sum).append("\n");
            for (int i = 1; i < k; i++) {
                result.append(indexes.get(i * m)).append(" ");
            }
            result.deleteCharAt(result.length() - 1);
            System.out.println(result);
        }
    }

    private static class Element implements Comparable<Element> {

        private final int value;
        private final int idx;

        Element(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        private int getValue() {
            return value;
        }

        protected int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(Element other) {
            return Comparator.comparingInt(Element::getValue)
                    .thenComparing(Element::getIdx)
                    .compare(this, other);
        }

    }

}