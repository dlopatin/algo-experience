package com.dlopatin.codeforce.r335;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/606/problem/B
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] sequence = new int[n + 1];
			for (int i = 1; i < sequence.length; i++) {
				int id = scanner.nextInt();
				sequence[id] = sequence[id - 1] + 1;
			}
			int max = sequence[0];
			for (int i = 1; i < sequence.length; i++) {
				max = Math.max(max, sequence[i]);
			}
			System.out.println(n - max);
		}
	}

}