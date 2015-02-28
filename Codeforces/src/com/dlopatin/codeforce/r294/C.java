package com.dlopatin.codeforce.r294;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/519/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int counter = 0;
			while ((a - 2 >= 0 && b - 1 >= 0) || (b - 2 >= 0 && a - 1 >= 0)) {
				if (a > b) {
					a -= 2;
					b -= 1;
					counter++;
				} else {
					a -= 1;
					b -= 2;
					counter++;
				}
			}
			System.out.println(counter);
		}
	}

}
