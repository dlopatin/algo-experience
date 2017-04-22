package com.dlopatin.codeforce.intel;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/722/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = scanner.nextInt();
			}
			scanner.nextLine();
			boolean[] mathch = new boolean['z' + 1];
			"aeiouy".chars().forEach(c -> mathch[c] = true);
			for (int i = 0; i < n; i++) {
				String line = scanner.nextLine();
				String[] words = line.split(" ");
				int counter = 0;
				for (String w : words) {
					for (char ch : w.toCharArray()) {
						if (mathch[ch]) {
							counter++;
						}
					}
				}
				if (counter != p[i]) {
					System.out.println("NO");
					return;
				}
			}
			System.out.println("YES");
		}
	}

}