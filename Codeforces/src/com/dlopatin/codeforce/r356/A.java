package com.dlopatin.codeforce.r356;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/680/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] count = new int[101];
			for (int i = 0; i < 5; i++) {
				count[scanner.nextInt()]++;
			}
			int max = 0;
			int numberToremove = -1;
			int amounttoRemove = 0;
			for (int i = 1; i < count.length; i++) {
				int number = count[i];
				if (number >= 2) {
					number = number > 3 ? 3 : number;
					int val = i * number;
					if (max < val) {
						max = val;
						numberToremove = i;
						amounttoRemove = number;
					}
				}
			}
			if (numberToremove > 0) {
				count[numberToremove] -= amounttoRemove;
			}
			int res = 0;
			for (int i = 1; i < count.length; i++) {
				res += count[i] * i;
			}
			System.out.println(res);
		}
	}
}