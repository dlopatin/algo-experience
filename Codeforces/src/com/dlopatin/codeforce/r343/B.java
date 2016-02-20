package com.dlopatin.codeforce.r343;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/629/problem/B?locale=en
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] gender = new char[n];
			int[] start = new int[n];
			int[] end = new int[n];
			for (int i = 0; i < n; i++) {
				gender[i] = scanner.next().charAt(0);
				start[i] = scanner.nextInt();
				end[i] = scanner.nextInt();
			}
			int max = 0;
			for (int day = 1; day <= 366; day++) {
				int male = 0;
				int female = 0;
				for (int i = 0; i < n; i++) {
					if (start[i] <= day && day <= end[i]) {
						if (gender[i] == 'F') {
							female++;
						} else {
							male++;
						}
					}
				}
				int cnt = Math.min(male, female) * 2;
				max = Math.max(max, cnt);
			}
			System.out.println(max);
		}
	}

}