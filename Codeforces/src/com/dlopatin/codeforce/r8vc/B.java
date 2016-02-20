package com.dlopatin.codeforce.r8vc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/626/problem/B?locale=en
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			char[] s = scanner.next().toCharArray();
			int[] cnt = new int[200];
			for (int i = 0; i < n; i++) {
				cnt[s[i]]++;
			}
			char[] rgb = new char[] { 'R', 'G', 'B' };
			for (char i : rgb) {
				for (char j : rgb) {
					for (char k : rgb) {
						if (i == j || j == k || i == k) {
							continue;
						}
						if (cnt[i] == 0 && cnt[j] == 0) {
							System.out.println(k);
							return;
						}
						if ((cnt[i] > 0 && cnt[j] > 0 && cnt[k] > 0) || cnt[i] > 1 && cnt[j] > 1) {
							System.out.println("BGR");
							return;
						}
						if (cnt[i] == 1 && cnt[j] == 1) {
							System.out.println(k);
							return;
						}
						if (cnt[i] > 1 && cnt[j] == 1) {
							char[] res = new char[2];
							res[0] = j;
							res[1] = k;
							Arrays.sort(res);
							System.out.println(new String(res));
							return;
						}
					}
				}
			}
		}
	}
}