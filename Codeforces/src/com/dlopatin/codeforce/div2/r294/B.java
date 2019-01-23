package com.dlopatin.codeforce.div2.r294;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/519/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            List<Integer> init = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int nextInt = scanner.nextInt();
                init.add(nextInt);
            }
            for (int i = 0; i < n - 1; i++) {
                int nextInt = scanner.nextInt();
                first.add(nextInt);
            }
            for (int i = 0; i < n - 2; i++) {
                int nextInt = scanner.nextInt();
                second.add(nextInt);
            }

            Collections.sort(init);
            Collections.sort(first);
            Collections.sort(second);

            int res = init.get(init.size() - 1);
            for (int i = 0; i < first.size(); i++) {
                if (!first.get(i).equals(init.get(i))) {
                    res = init.get(i);
                    break;
                }
            }
            System.out.println(res);

            res = first.get(first.size() - 1);
            for (int i = 0; i < second.size(); i++) {
                if (!second.get(i).equals(first.get(i))) {
                    res = first.get(i);
                    break;
                }
            }
            System.out.println(res);
        }
    }

}
