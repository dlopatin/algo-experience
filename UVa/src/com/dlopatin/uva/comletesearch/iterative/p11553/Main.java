package com.dlopatin.uva.comletesearch.iterative.p11553;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=27&page=show_problem&problem=2548
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int n = scanner.nextInt();
				int[] colums = new int[n];
				int[][] field = new int[n][n];
				for (int i = 0; i < n; i++) {
					colums[i] = i;
					for (int j = 0; j < n; j++) {
						field[i][j] = scanner.nextInt();
					}
				}

				int min = Integer.MAX_VALUE;
				do {
					int sum = 0;
					for (int i = 0; i < n; i++) {
						sum += field[i][colums[i]];
					}
					min = Math.min(sum, min);
				} while (nextPermutation(colums));

				System.out.println(min);
			}

		}
	}

	private boolean nextPermutation(int[] n) {
		int end = n.length - 1;
		for (int i = end - 1; i >= 0; i--) {
			if (n[i] < n[i + 1]) {
				for (int m = end; m > i; m--) {
					if (n[m] > n[i]) {
						// swap
						swap(n, i, m);

						// reorder
						reverse(n, i + 1);

						return true;
					}
				}
			}
		}
		return false;
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
