package com.dlopatin.codeforce.r296;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/527/problem/A?locale=en
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long counter = 0;
			while (a != b && a > 0 && b > 0) {
				if (a / b > 0) {
					counter += a / b;
					a = a % b;
				} else if (b / a > 0) {
					counter += b / a;
					b = b % a;
				} else {
					if (a > b) {
						a -= b;
					} else {
						b -= a;
					}
					counter++;
					if (a == b) {
						counter++;
					}
				}
			}
			System.out.println(counter);
		}
	}
}