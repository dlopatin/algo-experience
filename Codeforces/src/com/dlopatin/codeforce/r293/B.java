package com.dlopatin.codeforce.r293;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/518/problem/B
 *
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] src = new int['z' + 1];
			int[] t = new int['z' + 1];
			char[] s = scanner.next().toCharArray();
			for (char ch : s) {
				src[ch]++;
			}
			char[] b = scanner.next().toCharArray();
			for (char ch : b) {
				t[ch]++;
			}
			int yay = 0;
			int whoops = 0;
			for (char ch = 'A'; ch <= 'z'; ch++) {
				if (src[ch] > 0) {
					if (t[ch] >= src[ch]) {
						yay += src[ch];
						t[ch] -= src[ch];
						src[ch] = 0;
					} else {
						if (t[ch] > 0) {
							yay += t[ch];
							src[ch] -= t[ch];
							t[ch] = 0;
						}
					}
				}
			}

			for (char ch = 'A'; ch <= 'z'; ch++) {
				if (src[ch] > 0) {
					char togged = reverseCase(ch);
					if (t[togged] > 0) {
						whoops += (t[togged] >= src[ch]) ? src[ch] : t[togged];
					}
				}
			}

			System.out.println(String.format("%d %d", yay, whoops));
		}

	}

	private char reverseCase(char ch) {
		if (Character.isUpperCase(ch)) {
			return Character.toLowerCase(ch);
		}
		return Character.toUpperCase(ch);
	}
}
