package com.dlopatin.codeforce.r299;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/535/problem/A?locale=en
 */
public class A {

	private static final String[] SIMPLE = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	private static final String[] COMBINED = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(write(n));
		}
	}

	private String write(int n) {
		if (n < 20) {
			return SIMPLE[n];
		}
		if (getLastDigit(n) == 0) {
			return COMBINED[getFirstDidgit(n) - 2];
		}
		return COMBINED[getFirstDidgit(n) - 2] + "-" + SIMPLE[getLastDigit(n)];
	}

	private int getFirstDidgit(int n) {
		return n / 10;
	}

	private int getLastDigit(int n) {
		return n % 10;
	}
}