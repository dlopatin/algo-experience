package com.dlopatin.codeforce.r327;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/591/problem/B?locale=en
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			char[] name = scanner.next().toCharArray();
			List<HashSet<Integer>> idx = new ArrayList<HashSet<Integer>>();
			for (int i = 0; i <= 'z' - 'a'; i++) {
				idx.add(new HashSet<Integer>());
			}
			for (int i = 0; i < name.length; i++) {
				idx.get(name[i] - 'a').add(i);
			}
			for (int i = 0; i < m; i++) {
				int first = scanner.next().toCharArray()[0] - 'a';
				int second = scanner.next().toCharArray()[0] - 'a';
				HashSet<Integer> temp = idx.get(first);
				idx.set(first, idx.get(second));
				idx.set(second, temp);
			}
			char[] result = new char[name.length];
			for (int i = 0; i < idx.size(); i++) {
				char letter = (char) (i + 'a');
				for (Integer pos : idx.get(i)) {
					result[pos] = letter;
				}
			}
			System.out.println(new String(result));
		}
	}
}