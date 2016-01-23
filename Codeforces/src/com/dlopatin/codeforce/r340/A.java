package com.dlopatin.codeforce.r340;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/617/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt();
			int steps = x / 5;
			steps += x % 5 == 0 ? 0 : 1;
			System.out.println(steps);
		}
	}
}