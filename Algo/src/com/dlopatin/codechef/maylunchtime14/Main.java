package com.dlopatin.codechef.maylunchtime14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().doJob();

	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfCases = scanner.nextInt();
			for (int caseIdx = 0; caseIdx < numberOfCases; caseIdx++) {
				boolean stop = false;
				int n = scanner.nextInt();
				List<Integer> res = new ArrayList<>(n / 2);
				long[] a = new long[n];
				Pair[] remainders = new Pair[n];
				for (int ni = 0; ni < n; ni++) {
					a[ni] = scanner.nextLong();
					int remainder = (int) (a[ni] % n);
					if (remainder == 0) {
						stop = true;
						res.add(ni);
						print(res);
					}
					remainders[ni] = new Pair(ni, remainder);
				}
				if (stop) {
					continue;
				}
				Arrays.sort(remainders, new Comparator<Pair>() {
					@Override
					public int compare(Pair p1, Pair p2) {
						return Integer.compare(p1.getRemainder(), p2.getRemainder());
					}
				});
				List<Integer> indexes = new ArrayList<>();
				for (int i = n - 1; i >= 0; i--) {
					if (stop) {
						break;
					}
					int startVal = remainders[i].getRemainder();
					int sum = 0;
					for (int j = i - 1; j >= 0; j--) {
						sum = startVal + remainders[j].getRemainder();
						if (sum > n) {
							sum = 0;
							j = j + indexes.size() - 1;
							indexes.clear();
							continue;
						}
						indexes.add(j);
						if (sum % n == 0) {
							indexes.add(0, i);
							stop = true;
							break;
						}
					}

				}
				for (int idx : indexes) {
					res.add(remainders[idx].getPos());
				}
				print(res);
			}
		}
	}

	private void print(List<Integer> res) {
		if (res.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(res.size());
			StringBuilder builder = new StringBuilder();
			for (int idx : res) {
				builder.append(idx + 1).append(" ");
			}
			System.out.println(builder.toString().trim());
		}
	}

	private class Pair {
		private final int pos;
		private final int remainder;

		public Pair(int pos, int remainder) {
			super();
			this.pos = pos;
			this.remainder = remainder;
		}

		public int getPos() {
			return pos;
		}

		public int getRemainder() {
			return remainder;
		}

	}
}
