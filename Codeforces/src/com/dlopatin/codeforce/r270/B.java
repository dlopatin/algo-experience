package com.dlopatin.codeforce.r270;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/472/problem/B
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			Integer[] f = new Integer[n];
			for (int i = 0; i < n; i++) {
				f[i] = scanner.nextInt();
			}
			Arrays.sort(f, Collections.reverseOrder());

			int counter = 0;
			for (int i = 0; i < n; i += k) {
				counter += f[i] * 2 - 2;
			}
			System.out.println(counter);
		}
	}

}
