package com.dlopatin.codeforce.div2.r295;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/520/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int counter = 0;
            while (n != m) {
                if (n > m) {
                    counter += n - m;
                    n = m;
                } else if (m % 2 == 0) {
                    m /= 2;
                    counter++;
                } else {
                    m += 1;
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }

}
