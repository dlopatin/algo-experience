package com.dlopatin.codeforce.rockethon2015;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/513/problem/B1
 *
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = i + 1;
			}
			permut(array, m);
//			for (int i=0; i<n;i++){
//				for (int j=i; j<n; j++){
//
//				}
//			}

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < n; i++) {
				builder.append(array[i]).append(" ");
			}
			System.out.println(builder.toString().trim());
		}
	}

	private void permut(int[] n, int p) {
		int end = n.length - 1;
		int counter = 1;
		while (counter < p) {
			for (int i = end - 1; i >= 0; i--) {
				if (n[i] < n[i + 1]) {
					for (int m = end; m > i; m--) {
						if (n[m] > n[i]) {
							// swap
							swap(n, i, m);

							// reorder
							reverse(n, i + 1);

							counter++;
							if (counter >= p) {
								return;
							}
//							System.out.println(Arrays.toString(n));
						}
					}
				}
			}

		}
	}

	private void swap(int[] n, int i, int m) {
		int temp = n[m];
		n[m] = n[i];
		n[i] = temp;
	}

	private void reverse(int[] a, int l) {
		int i = l;
		int j = a.length - 1;

		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}

	}

}
