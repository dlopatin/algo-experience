package com.dlopatin.unionfind;

import java.util.Arrays;
import java.util.Scanner;

public class QuickFind {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int unions = scanner.nextInt();
			QuickFind quickFind = new QuickFind(n);
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

	public QuickFind(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int pId = id[p];
		int qId = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(id);
	}

}
