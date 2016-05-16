package com.dlopatin.codeforce.manthan16;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/633/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			for (int i = 0; i * a <= c; i++) {
				int ai = i * a;
				int diff = c - ai;
				if (diff == ((diff / b) * b)) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
	}

}