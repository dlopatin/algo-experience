package com.dlopatin.y2016.qualification;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String[] words = new String[n];
			for (int i = 0; i < n; i++) {
				words[i] = scanner.next();
			}
			String result = "";
			for (int i = 0; i < n; i++) {
				int max = 0;
				char[] w1 = words[i].toCharArray();
				for (int j = 0; j < n; j++) {
					if (i != j) {
						char[] w2 = words[j].toCharArray();
						for (int c = 0; c < w1.length && max < 2; c++) {
							if (w1[c] != w2[c]) {
								max++;
							}
						}
						if (max > 1) {
							break;
						}
					}
					max = 0;
				}
				if (max < 2) {
					result = String.valueOf(w1);
					System.out.println(result);
					return;
				}
			}
		}
	}

}