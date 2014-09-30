package com.dlopatin.codeforce.r270;

import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/472/A
 *
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			for (int i = 4; i <= n / 2; i++) {
				int first = i;
				int second = n - first;
				if (isComposite(first) && isComposite(second)) {
					System.out.println(first + " " + second);
					break;
				}
			}
		}
	}

	private boolean isComposite(int val) {
		return val % 2 == 0 || val % 3 == 0;
	}
}
