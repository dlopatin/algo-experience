package com.dlopatin.uva.datastructures.array.p11340;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=979
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = scanner.nextInt();
			while (n-- > 0) {
				int k = scanner.nextInt();
				Map<Character, Integer> map = new HashMap<>();
				for (int i = 0; i < k; i++) {
					map.put(scanner.next().charAt(0), scanner.nextInt());
				}
				int m = scanner.nextInt();
				scanner.nextLine();
				long counter = 0;
				for (int i = 0; i < m; i++) {
					char[] line = scanner.nextLine().toCharArray();
					for (char ch : line) {
						Integer cost = map.get(ch);
						if (cost != null) {
							counter += cost;
						}
					}
				}
				result.append(String.format("%.2f$\n", counter / 100d));
			}
			System.out.println(result.toString().trim());
		}
	}

}
