package com.dlopatin.uva.datastructures.collection.p00146;

import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=82
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			String line = null;
			while (!"#".equals(line = scanner.next())) {
				char[] chars = line.toCharArray();
				result.append(nextPermutation(chars) ? new String(chars) : "No Successor");
				result.append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}

	private boolean nextPermutation(char[] n) {
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

	private void swap(char[] n, int i, int m) {
		char temp = n[m];
		n[m] = n[i];
		n[i] = temp;
	}

	private void reverse(char[] a, int l) {
		int i = l;
		int j = a.length - 1;

		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}

	}

}
