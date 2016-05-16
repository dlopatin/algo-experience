package com.dlopatin.codeforce.manthan16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/633/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String string = new StringBuffer(scanner.next()).reverse().toString();
			int m = scanner.nextInt();
			Map<String, String> wordsMap = new HashMap<>(m);
			Map<String, Integer> wordsPos = new HashMap<>(m);
			for (int i = 0; i < m; i++) {
				String original = scanner.next();
				String lowerCase = original.toLowerCase();
				wordsMap.put(lowerCase, original);
				wordsPos.put(lowerCase, -1);
			}
			int first = 0;
			int last = 1;
			while (true) {
				if (wordsMap.containsKey(string.substring(first, last))) {

				}
				;
			}

		}
	}

}