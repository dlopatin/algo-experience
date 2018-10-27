package com.dlopatin.uva.datastructures.nonlineards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=226&page=show_problem&problem=2949
 */
public class P11849 {

    public static void main(String[] args) throws IOException {
        P11849.doJob();
    }

    private static void doJob() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = 0;
            Set<String> disks = new HashSet<>();
            String cases;
            while (!(cases = reader.readLine()).equals("0 0")) {
                disks.clear();
                int cnt = 0;
                StringTokenizer tokenizer = new StringTokenizer(cases);
                int one = Integer.parseInt(tokenizer.nextToken());
                int two = Integer.parseInt(tokenizer.nextToken());
                while (one-- > 0) {
                    disks.add(reader.readLine());
                }
                while (two-- > 0) {
                    if (disks.contains(reader.readLine())) {
                        cnt++;
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}
