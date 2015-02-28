package com.dlopatin.uva.p11742;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=117&page=show_problem&problem=2842
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = 0;
			int m = 0;
			while (true) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				if (n == 0 && m == 0) {
					return;
				}
				int[] group = new int[n];
				for (int i = 0; i < n; i++) {
					group[i] = i;
				}
				Condition[] conditions = new Condition[m];
				for (int i = 0; i < m; i++) {
					conditions[i] = new Condition(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
				}
				int counter = 0;
				do {
					counter += isValid(group, conditions) ? 1 : 0;
				} while (permut(group));
				System.out.println(counter);
			}

		}
	}

	private boolean isValid(int[] group, Condition[] conditions) {
		for (Condition cond : conditions) {
			int dist = Math.abs(group[cond.getA()] - group[cond.getB()]);
			if (cond.getC() > 0 && dist <= Math.abs(cond.getC()) || cond.getC() < 0 && dist >= Math.abs(cond.getC())) {
				// good
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean permut(int[] n) {
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

	private class Condition {
		private final int a;
		private final int b;
		private final int c;

		public Condition(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public int getA() {
			return a;
		}

		public int getB() {
			return b;
		}

		public int getC() {
			return c;
		}

	}

}
