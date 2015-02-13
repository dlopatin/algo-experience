package com.dlopatin.codeforce.r292;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/516/problem/C
 *
 */
public class C {
	int[] res = new int[10];

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] a = scanner.next().toCharArray();
			List<Integer> res = new ArrayList<>(2 * n);
			for (char ai : a) {
				int number = Character.getNumericValue(ai);
				switch (number) {
				case 4:
					res.add(3);
					res.add(2);
					res.add(2);
					break;
				case 6:
					res.add(5);
					res.add(3);
					break;
				case 8:
					res.add(7);
					res.add(2);
					res.add(2);
					res.add(2);
					break;
				case 9:
					res.add(7);
					res.add(3);
					res.add(3);
					res.add(2);
					break;
				default:
					if (number > 1) {
						res.add(number);
					}
				}
			}
			Collections.sort(res, Collections.reverseOrder());
			StringBuilder builder = new StringBuilder();
			for (int digit : res) {
				builder.append(digit);
			}
			System.out.println(builder);
		}
	}

}
