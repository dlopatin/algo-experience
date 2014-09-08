package com.dlopatin.unionfind;

import java.util.Arrays;
import java.util.Scanner;

public class WeightedQuickUnion {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int unions = scanner.nextInt();
			WeightedQuickUnion quickFind = new WeightedQuickUnion(n);
			for (int i = 0; i < unions; i++) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				if (!quickFind.connected(p, q)) {
					quickFind.union(p, q);
				}
			}
			System.out.println(quickFind);
		}
	}

	private final int[] id;
	private final int[] size;

	public WeightedQuickUnion(int n) {
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j) {
			return;
		}
		if (size[i] < size[j]) {
			id[i] = j;
			size[j] += size[i];
		} else {
			id[j] = i;
			size[i] += size[j];

		}
	}

	@Override
	public String toString() {
		return Arrays.toString(id);
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

}
