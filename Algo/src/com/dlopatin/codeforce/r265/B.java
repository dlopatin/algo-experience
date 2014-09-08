package com.dlopatin.codeforce.r265;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/465/problem/B
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] letters = new int[n];
			for (int i = 0; i < n; i++) {
				letters[i] = scanner.nextInt();
			}

			int actionsCount = 0;
			int current = 0;
			int nextPos = findNextLetterPos(letters, current);
			boolean letterOpened = false;
			while (current < n) {
				if (nextPos == -1) {
					break;
				}
				// enter
				if (!letterOpened || !closeAndOpen(current, nextPos)) {
					actionsCount++;
					letterOpened = true;
				} else if (letterOpened && closeAndOpen(current, nextPos)) {
					actionsCount += 2;
				}
				current = nextPos;
				nextPos = findNextLetterPos(letters, current + 1);
			}
			System.out.println(actionsCount);
		}
	}

	private int findNextLetterPos(int[] letters, int startPos) {
		int pos = startPos;
		while (pos < letters.length) {
			if (letters[pos] == 1) {
				return pos;
			} else {
				pos++;
			}
		}
		return -1;
	}

	private boolean closeAndOpen(int current, int next) {
		return next - current > 1;
	}

}
