package com.dlopatin.codeforce.div2.r327;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/591/problem/0
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int s = scanner.nextInt();
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            double t = (double) s / (v1 + v2);
            double sd = t * v1;
            System.out.println(sd);
        }
    }
}