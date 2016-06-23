package com.dlopatin.codeforce.r358;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/682/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Integer[] array = new Integer[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}
			Arrays.parallelSort(array);
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += array[i] > sum ? 1 : 0;
			}
			System.out.println(sum + 1);
		}
	}
}