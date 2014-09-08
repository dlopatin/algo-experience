package com.dlopatin.codeforce.r261;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws IOException, ParseException {
		new A().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			int x3 = 0, x4 = 0, y3 = 0, y4 = 0;
			if (x1 == x2 && y1 == y2) {
				System.out.println(-1);
				return;
			}
			if (x1 == x2) {
				int length = Math.abs(y1 - y2);
				x3 = x1 + length;
				x4 = x2 + length;
				System.out.println(x3 + " " + y1 + " " + x4 + " " + y2);
				return;
			}
			if (y1 == y2) {
				int length = Math.abs(x1 - x2);
				y3 = y1 + length;
				y4 = y2 + length;
				System.out.println(x1 + " " + y3 + " " + x2 + " " + y4);
				return;
			}
			int a1 = x1, a2 = y2;
			if (calcLineLenght(x1, y1, a1, a2) == calcLineLenght(x2, y2, a1, a2)) {
				int b1 = x2, b2 = y1;
				System.out.println(a1 + " " + a2 + " " + b1 + " " + b2);
				return;
			}
		}
		System.out.println(-1);

	}

	private double calcLineLenght(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
