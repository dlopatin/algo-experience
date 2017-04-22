package com.dlopatin.codeforce.intel;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/722/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int f = scanner.nextInt();
			String time = scanner.next();
			int h = Integer.parseInt(time.substring(0, 2));
			int m = Integer.parseInt(time.substring(3, 5));
			if (f == 12) {
				if (h > 12) {
					h = h % 10;
				}
				if (h == 0) {
					h = 10;
				}
			} else {
				if (h > 23) {
					h = h % 10;
				}
			}
			if (m > 59) {
				m = m % 10;
			}
			System.out.printf("%02d:%02d", h, m);
		}
	}
}