package com.dlopatin.codeforce.id567;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * http://codeforces.com/contest/567/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			Map<Long, Integer> sequenceCounter = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long a = scanner.nextLong();
				Integer counter = sequenceCounter.get(a);
				if (counter == null) {
					counter = 0;
				}
				counter++;
				sequenceCounter.put(a, counter);
			}
			long counter = 0;
			Set<Long> keys = sequenceCounter.keySet();
			long k2 = k;
			long k3 = k * k;
			for (Long key : keys) {
				Integer val1 = sequenceCounter.get(key);
				long key2 = key * k2;
				Integer val2 = sequenceCounter.get(key2);
				if (val2 == null) {
					continue;
				}
				long key3 = key * k3;
				Integer val3 = sequenceCounter.get(key3);
				if (val3 == null) {
					continue;
				}
				counter += val3 * val2 * val1;
			}

			System.out.println(counter);
		}
	}
}