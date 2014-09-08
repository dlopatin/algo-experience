package com.dlopatin.codeforce.r265;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/465/problem/A
 */
public class A {

	public static void main(String[] args) throws IOException, ParseException {
		new A().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String number_2 = scanner.next();
			int number = Integer.parseInt(reverse(number_2), 2);
			number++;
			String incremented = String.format("%" + n + "s", Integer.toBinaryString(number)).replace(' ', '0');
			incremented = reverse(incremented).substring(0, n);
			int count = 0;
			char[] src = number_2.toCharArray();
			char[] ed = incremented.toCharArray();
			for (int i = 0; i < n; i++) {
				if (src[i] != ed[i]) {
					count++;
				}
			}

			System.out.println(count);
		}
	}

	private String reverse(String val) {
		return new StringBuilder(val).reverse().toString();
	}

}
