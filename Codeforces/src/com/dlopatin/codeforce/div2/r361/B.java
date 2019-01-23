package com.dlopatin.codeforce.div2.r361;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/689/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            String n = scanner.next();
            System.out.println(n + new StringBuilder(n).reverse());
        }
    }
}