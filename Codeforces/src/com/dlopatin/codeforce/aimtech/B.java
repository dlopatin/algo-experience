package com.dlopatin.codeforce.aimtech;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/624/problem/C
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] res = new int[n];
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;
				res[u]++;
				res[v]++;
				if (res[u] > 2 || res[v] > 2) {
					System.out.println("No");
					return;
				}
			}
			for (int vertCnt : res) {
				if (vertCnt < 1) {
					System.out.println("No");
					return;
				}
			}
			System.out.println("Yes");
			System.out.println(new String(new char[n]).replace("\0", "b"));
		}
	}
}