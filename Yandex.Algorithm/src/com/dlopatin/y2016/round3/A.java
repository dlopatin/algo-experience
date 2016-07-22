package com.dlopatin.y2016.round3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Integer> plus = new ArrayList<>();
			List<Integer> minus = new ArrayList<>();
			int res = 1;
			for (int i = 0; i < n; i++) {
				int pos = scanner.nextInt();
				if ('+' == scanner.next().charAt(0)) {
					plus.add(pos);
					if (minus.stream().filter(minpos -> minpos < pos).count() > 0) {
						res = 2;
						break;
					}
				} else {
					minus.add(pos);
					if (plus.stream().filter(maxpos -> maxpos > pos).count() > 0) {
						res = 2;
						break;
					}
				}
			}
			System.out.println(res);

		}
	}
}