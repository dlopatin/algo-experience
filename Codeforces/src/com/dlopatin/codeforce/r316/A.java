package com.dlopatin.codeforce.r316;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/570/problem/0
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int candidates = scanner.nextInt();
			int cities = scanner.nextInt();
			int[] res = new int[candidates];
			for (int j = 0; j < cities; j++) {
				int max = -1;
				int idx = 0;
				for (int i = 0; i < candidates; i++) {
					int temp = scanner.nextInt();
					if (temp > max) {
						max = temp;
						idx = i;
					}
				}
				res[idx]++;
			}
			int max = -1;
			int idx = -1;
			for (int i = 0; i < candidates; i++) {
				if (res[i] > max) {
					max = res[i];
					idx = i + 1;
				}
			}
			System.out.println(idx);
		}
	}
}