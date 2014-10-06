package com.dlopatin.codeforce.r271;

import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/474/A
 *
 */
public class A {

	private static char[] chars = "qwertyuiopasdfghjkl;zxcvbnm,./".toCharArray();

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			String direction = scanner.next();
			char[] input = scanner.next().toCharArray();
			int correction = "R".equals(direction) ? -1 : 1;
			StringBuilder out = new StringBuilder();
			for (char ch : input) {
				out.append(chars[findPos(chars, ch) + correction]);
			}
			System.out.println(out.toString());
		}
	}

	private int findPos(char[] chars, char ch) {
		int i = 0;
		for (i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				return i;
			}
		}
		return i;
	}

}
