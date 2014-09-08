package com.dlopatin.codeforce.r262;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/460/problem/B
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long c = scanner.nextLong();
			List<Long> res = new LinkedList<>();
			for (long i = 0; i <= 81; i++) {
				long val = equation(a, b, c, i);
				if (func(val) == i && val > 0 && val < 1000000000) {
					res.add(val);
				}
			}
			Collections.sort(res);
			StringBuilder result = new StringBuilder();
			for (long val : res) {
				result.append(val).append(" ");
			}
			System.out.println(res.size());
			System.out.println(result.toString().trim());
		}
	}

	private long equation(long a, long b, long c, long x) {
		return (long) (b * Math.pow(x, a) + c);
	}

	private int func(long n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

}
