package com.dlopatin.y2016.round2;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			String s = scanner.next();
			int[] price = new int['z' - 'a' + 1];
			for (int i = 0; i < m; i++) {
				scanner.nextInt();
				int aPrice = scanner.nextInt();
				char[] charArray = scanner.next().toCharArray();
				for (char ch : charArray) {
					int idx = ch - 'a';
					if (price[idx] == 0 || price[idx] > aPrice) {
						price[idx] = aPrice;
					}
				}
			}
			int counter = 0;
			for (char ch : s.toCharArray()) {
				int idx = ch - 'a';
				if (price[idx] == 0) {
					counter = -1;
					break;
				}
				counter += price[idx];
			}
			System.out.println(counter);

		}
	}

}