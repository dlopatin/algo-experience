package com.dlopatin.codeforce.r332;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/599/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Block> blocks = new ArrayList<>();
			int array[] = new int[n];
			for (int j = 0; j < n; j++) {
				array[j] = scanner.nextInt();
				int current = array[j];
				if (blocks.size() == 0) {
					blocks.add(new Block(array, 0, j));
				} else {
					Block block = blocks.get(blocks.size() - 1);
					if (block.max > current) {
						blocks.add(blocks.size() - 1, new Block(array, block.i, j));
					}
				}
			}
		}
	}

	private class Block {
		private final int i;
		private final int j;
		private int min;
		private int max;

		public Block(int[] array, int i, int j) {
			this.i = i;
			this.j = j;
			for (int idx = i; idx < j; idx++) {
				min = Math.min(min, array[idx]);
				max = Math.max(max, array[idx]);
			}
		}

	}
}