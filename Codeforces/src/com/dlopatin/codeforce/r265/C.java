package com.dlopatin.codeforce.r265;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/465/problem/C
 */
public class C {

	public static void main(String[] args) throws IOException, ParseException {
		new C().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int p = scanner.nextInt();
			String line = scanner.next();
			findNextLetterPos(line);

			// System.out.println(actionsCount);
		}
	}

	private int findNextLetterPos(String val) {
		int i, j, k; // iterators
		int rp; // length of 'palindrome radius'
		int N = val.length();
		int R[][] = new int[2][N + 1]; // table for storing results (2 rows for
										// odd- and even-length palindromes

		// print s first

		// ...then search for palindromes

		val = "@" + val + "#"; // insert 'guards' to iterate easily over s
		char[] s = val.toCharArray();
		for (j = 0; j <= 1; j++) {
			R[j][0] = rp = 0;
			i = 1;
			while (i <= N) {
				while (s[i - rp - 1] == s[i + j + rp]) {
					rp++;
				}
				R[j][i] = rp;
				k = 1;
				while ((R[j][i - k] != rp - k) && (k < rp)) {
					R[j][i + k] = Math.min(R[j][i - k], rp - k);
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}

		val = val.substring(1, N); // remove 'guards'

		// print the results

		for (i = 1; i <= N; i++) {
			for (j = 0; j <= 1; j++) {
				for (rp = R[j][i]; rp > 0; rp--) {
					for (k = 1; k < i - rp; k++) {
						System.out.println(" ");
					}
					System.out.println(val.substring(i - rp - 1, 2 * rp + j));
				}
			}
		}
		System.out.println("/n");
		return 0;
	}
}
