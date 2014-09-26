package com.dlopatin.codeforce.r269;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/471/A
 *
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			Integer n[] = new Integer[9];
			Arrays.fill(n, 0);
			for (int i = 0; i < 6; i++) {
				int val = scanner.nextInt();
				n[val - 1]++;
			}
			Arrays.sort(n, Collections.reverseOrder());
			String res = "Alien";
			if (n[0] == 4) {
				if (n[1] == 2) {
					res = "Elephant";
				} else {
					res = "Bear";
				}
			} else if (n[0] == 5) {
				res = "Bear";
			} else if (n[0] == 6) {
				res = "Elephant";
			}
			System.out.println(res);
		}
	}
}
