package com.dlopatin.codeforce.r296;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/527/problem/B?locale=en
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			char[] t = scanner.next().toCharArray();
			Map<Character, List<Integer>> pos = new HashMap<>();
			int distance = 0;
			for (int i = 0; i < n; i++) {
				if (s[i] != t[i]) {
					List<Integer> positions = pos.get(s[i]);
					if (positions == null) {
						positions = new ArrayList<>();
						positions.add(i);
						pos.put(s[i], positions);
					} else {
						positions.add(i);
					}
					distance++;
				}
			}

			List<Character> keySet = new ArrayList<>(pos.keySet());
			boolean stop = false;
			int a = -1;
			int b = -1;
			int workingD = distance;
			for (int i = 0; i < keySet.size(); i++) {
				for (int j = i + 1; j < keySet.size(); j++) {
					List<Integer> list = pos.get(keySet.get(i));
					for (Integer first : list) {
						List<Integer> list2 = pos.get(keySet.get(j));
						for (Integer second : list2) {
							if (t[first] == s[second] && t[second] == s[first]) {
								workingD = distance - 2;
								a = first + 1;
								b = second + 1;
								stop = true;
								break;
							} else if (t[first] == s[second] || t[second] == s[first]) {
								a = first + 1;
								b = second + 1;
								workingD = distance - 1;
							}
						}
						if (stop) {
							break;
						}
					}
					if (stop) {
						break;
					}
				}
				if (stop) {
					break;
				}
			}
			System.out.println(workingD >= 0 ? workingD : 0);
			System.out.printf("%d %d\n", a, b);
		}
	}
}
