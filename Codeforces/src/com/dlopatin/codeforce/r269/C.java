package com.dlopatin.codeforce.r269;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/471/problem/C
 *
 */
public class C {

	public static void main(String[] args) throws IOException, ParseException {
		new C().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int count = 0;
			long used = 0;
			for (int i = 1; i < 1000000000; i++) {
				used += i * 3 - 1;
				if (used > n) {
					break;
				}
				if ((n - used) % 3 == 0) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
