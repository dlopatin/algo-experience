package com.dlopatin.codeforce.r335;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/606/problem/A
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

			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int z = scanner.nextInt();

			boolean res = parse(a, x) + parse(b, y) + parse(c, z) >= 0;
			System.out.println(res ? "Yes" : "No");
		}
	}

	private int parse(int a, int b) {
		return (a - b) > 0 ? (a - b) / 2 : (a - b);
	}
}