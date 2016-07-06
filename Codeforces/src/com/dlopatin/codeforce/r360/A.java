package com.dlopatin.codeforce.r360;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/688/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int d = scanner.nextInt();
			int res = 0;
			int seq = 0;
			for (int i = 0; i < d; i++) {
				char[] array = scanner.next().toCharArray();
				boolean ok = false;
				for (char ch : array) {
					if (ch == '0') {
						seq++;
						ok = true;
						break;
					}
				}
				if (!ok) {
					res = Math.max(res, seq);
					seq = 0;
				}
			}
			res = Math.max(res, seq);
			System.out.println(res);
		}
	}
}