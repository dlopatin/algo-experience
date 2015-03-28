package com.dlopatin.russiancodecup2015.round1;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int n = scanner.nextInt();
				int l = scanner.nextInt();
				int[] cheater = new int[n];
				for (int i = 0; i < n; i++) {
					cheater[i] = scanner.nextInt();
				}
				int[] player = new int[n];
				for (int i = 0; i < n; i++) {
					player[i] = scanner.nextInt();
				}
				Arrays.sort(cheater);
				Arrays.sort(player);

				System.out.println(sum1(cheater, l) > sum2(player, l) ? "YES" : "NO");
			}
		}
	}

	private int sum1(int[] array, int l) {
		int sum = 0;
		for (int i = 0; i < l; i++) {
			sum += array[i];
		}
		return sum;
	}

	private int sum2(int[] array, int l) {
		int sum = 0;
		for (int i = array.length - 1; i > array.length - 1 - l; i--) {
			sum += array[i];
		}
		return sum;
	}
}