package com.dlopatin.codeforce.div2.r297;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/525/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            char[] line = scanner.next().toLowerCase().toCharArray();
            int counter = 0;
            char[] keys = new char['z' + 1];
            for (int i = 0; i < line.length; i += 2) {
                keys[line[i]]++;
                if (keys[line[i + 1]] > 0) {
                    keys[line[i + 1]]--;
                } else {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}