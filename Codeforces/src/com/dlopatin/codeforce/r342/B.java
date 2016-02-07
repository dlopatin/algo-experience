package com.dlopatin.codeforce.r342;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/625/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			String string = scanner.next();
			String subString = scanner.next();
			int cnt = 0;
			int charIdx = 0;
			while ((charIdx = string.indexOf(subString, charIdx)) >= 0) {
				charIdx += subString.length();
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}