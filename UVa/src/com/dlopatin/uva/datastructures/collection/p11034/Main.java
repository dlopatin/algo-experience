package com.dlopatin.uva.datastructures.collection.p11034;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=629&page=show_problem&problem=1975
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int T = scanner.nextInt();
			while (T-- > 0) {
				int l = scanner.nextInt() * 100;
				int m = scanner.nextInt();
				Queue<Integer> left = new LinkedList<>();
				Queue<Integer> right = new LinkedList<>();
				for (int i = 0; i < m; i++) {
					int length = scanner.nextInt();
					String direction = scanner.next();
					if (direction.equals("left")) {
						left.add(length);
					} else {
						right.add(length);
					}
				}

				int crossNumber = 0;
				while (left.size() > 0 || right.size() > 0) {
					int loaded = 0;
					while (left.size() > 0 && left.peek() + loaded <= l) {
						loaded += left.poll();
					}
					crossNumber++;
					loaded = 0;
					if (left.size() > 0 || right.size() > 0) {
						while (right.size() > 0 && right.peek() + loaded <= l) {
							loaded += right.poll();
						}
						crossNumber++;
					}

				}
				result.append(crossNumber).append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}

}
