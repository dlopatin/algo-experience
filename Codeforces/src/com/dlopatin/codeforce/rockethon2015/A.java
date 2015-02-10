package com.dlopatin.codeforce.rockethon2015;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/513/problem/0
 *
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			int k1 = scanner.nextInt();
			int k2 = scanner.nextInt();
			String res = "First";
			if (n2 >= n1) {
				res = "Second";
			}
			System.out.println(res);
		}
	}

}
