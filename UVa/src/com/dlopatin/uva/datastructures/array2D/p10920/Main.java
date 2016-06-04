package com.dlopatin.uva.datastructures.array2D.p10920;

import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=624&page=show_problem&problem=1861
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = 0;
			while ((n = scanner.nextInt()) != 0) {
				int p = scanner.nextInt();
				double value = Math.sqrt(p);
				double fractionPart = value % 1;
				int r = (int) value;
				if (r % 2 == 0) {
					r += 1;
				} else if (fractionPart != 0) {
					r += r % 2 == 0 ? 1 : 2;
				}
				int i = 0;
				int j = 0;
				int rr = r * r;
				int start = rr;
				int end = start - r + 1;
				int diff = (n - r) / 2;
				if (inRange(p, start, end)) {
					j = r;
					i = r - (start - p);
				} else {
					start = end;
					end = start - r + 1;
					if (inRange(p, start, end)) {
						i = 1;
						j = r - (start - p);
					} else {
						start = end;
						end = start - r + 1;
						if (inRange(p, start, end)) {
							j = 1;
							i = 1 + (start - p);
						} else {
							start = end;
							end = start - r + 1;
							i = r;
							j = 1 + (start - p);
						}
					}
				}
				result.append(String.format("Line = %d, column = %d.\n", i + diff, j + diff));
			}
			System.out.println(result.toString().trim());
		}
	}

	private boolean inRange(int value, int start, int end) {
		return value >= end && value <= start;
	}
}
