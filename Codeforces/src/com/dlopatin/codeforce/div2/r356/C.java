package com.dlopatin.codeforce.div2.r356;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/680/problem/C
 */
public class C {

    public static void main(String[] args) {
        new C().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] primes = new int[]{2, 3, 5, 7};
            int[] multiplyPrimes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

            int count = 0;
            int[] primesRes = new int[primes.length];
            for (int i = 0; i < primes.length; i++) {
                print(primes[i]);
                int accept = "yes".equals(scanner.next()) ? 1 : 0;
                primesRes[i] = accept;
                count += accept;
                if (count > 1) {
                    print("composite");
                    return;
                }
            }
            for (int i = 0; i < primesRes.length; i++) {
                if (primesRes[i] == 1) {
                    int primeNum = primes[i];
                    for (int j = 0; j < multiplyPrimes.length && primeNum * multiplyPrimes[j] <= 100; j++) {
                        print(primeNum * multiplyPrimes[j]);
                        if ("yes".equals(scanner.next())) {
                            print("composite");
                            return;
                        }
                    }
                }
            }
            print("prime");
            return;
        }
    }

    private <T> void print(T value) {
        System.out.println(value);
        System.out.flush();
    }
}