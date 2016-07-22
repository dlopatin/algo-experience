package com.dlopatin.codeforce.r361;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/689/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] chars = scanner.next().toCharArray();
			boolean[] numbers = new boolean[10];
			for (char ch : chars) {
				numbers[Integer.valueOf(String.valueOf(ch))] = true;
			}
			boolean up = numbers[1] || numbers[2] || numbers[3];
			boolean left = numbers[1] || numbers[4] || numbers[7];
			boolean down = numbers[7] || numbers[0] || numbers[9];
			boolean right = numbers[3] || numbers[6] || numbers[9];
			boolean base = up && left && down && right;
			boolean zero = numbers[0] && numbers[1] || numbers[0] && numbers[2] || numbers[0] && numbers[3];
			boolean unique = base || zero;
			System.out.println(unique ? "YES" : "NO");
		}
	}
}