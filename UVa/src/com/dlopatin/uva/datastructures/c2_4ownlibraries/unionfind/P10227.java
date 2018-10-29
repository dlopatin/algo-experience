package com.dlopatin.uva.datastructures.c2_4ownlibraries.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=14&page=show_problem&problem=1168
 * Union find
 */
public class P10227 {

    public static void main(String[] args) throws IOException {
        // solution without disjoint set
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            reader.readLine();
            while (n-- > 0) {
                StringTokenizer pt = new StringTokenizer(reader.readLine());
                int p = parseInt(pt.nextToken());
                int t = parseInt(pt.nextToken());
                Map<Integer, Set<String>> map = new HashMap<>(p);
                String connection;
                while ((connection = reader.readLine()) != null && !connection.isEmpty()) {
                    StringTokenizer pair = new StringTokenizer(connection);
                    map.computeIfAbsent(parseInt(pair.nextToken()) - 1, stub -> new TreeSet<>()).add(pair.nextToken());
                }
                long distinct = map.values().stream().map(Set::hashCode).distinct().count();
                distinct += (p - map.keySet().size()) > 0 ? 1 : 0; // for those who are deaf
                builder.append(distinct).append("\n");
                if (n > 0) {
                    builder.append("\n");
                }
            }
            System.out.print(builder);
        }
    }


}
