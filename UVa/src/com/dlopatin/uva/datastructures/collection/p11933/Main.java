package com.dlopatin.uva.datastructures.collection.p11933;

import java.io.IOException;
import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=626&page=show_problem&problem=3084
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int number = 0;
			while ((number = scanner.nextInt()) != 0) {
				int counter = 0;
				int a = 0;
				int b = 0;
				int idx = 0;
				while (number > 0) {
					if ((number & 1) == 1) {
						counter++;
						if (counter % 2 == 0) {
							b |= 1 << idx;
						} else {
							a |= 1 << idx;
						}
					}
					idx++;
					number >>>= 1;
				}
				result.append(String.format("%d %d\n", a, b));
			}
			System.out.println(result.toString().trim());
		}
	}
}
