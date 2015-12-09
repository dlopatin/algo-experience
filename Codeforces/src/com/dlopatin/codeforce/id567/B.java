package com.dlopatin.codeforce.id567;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/567/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			scanner.nextLine();
			int[] visitors = new int[10000004];
			int maxVisitors = 0;
			int activeVisitors = 0;
			for (int i = 0; i < n; i++) {
				String line = scanner.nextLine();
				String sign = line.substring(0, 1);
				int id = Integer.parseInt(line.substring(2, line.length()));
				if ("+".equals(sign)) {
					activeVisitors++;
					maxVisitors = Math.max(maxVisitors, activeVisitors);
					visitors[id] = 1;
				} else {
					if (visitors[id] == 0) {
						maxVisitors++;
					} else {
						visitors[id] = 0;
						activeVisitors--;
					}
				}
			}
			System.out.println(maxVisitors);
		}
	}
}