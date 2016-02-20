package com.dlopatin.codeforce.r343;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/629/problem/A?locale=en
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int array[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] chars = scanner.next().toCharArray();
				for (int j = 0; j < n; j++) {
					array[i][j] = chars[j] == '.' ? 0 : 1;
				}
			}
			long cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						cnt += array[i][j] == 1 && array[i][j] == array[i][k] ? 1 : 0;
						cnt += array[j][i] == 1 && array[j][i] == array[k][i] ? 1 : 0;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}