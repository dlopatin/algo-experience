package com.dlopatin.uva.datastructures.c2_4ownlibraries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&problem=540
 */
public class P00599 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                BitSet bitSet = new BitSet(26);
                int edges = 0;
                String line;
                while (!(line = reader.readLine()).startsWith("*")) {
                    int first = line.charAt(1) - 'A';
                    bitSet.set(first);
                    int second = line.charAt(3) - 'A';
                    bitSet.set(second);
                    edges++;
                }
                int notConnected = 0;
                String[] vert = reader.readLine().split(",");
                for (String v : vert) {
                    notConnected += bitSet.get(v.charAt(0) - 'A') ? 0 : 1;
                }
                int acorns = notConnected;
                int trees = vert.length - edges - acorns;
                System.out.printf("There are %d tree(s) and %d acorn(s).\n", trees, acorns);
            }
        }
    }

}
