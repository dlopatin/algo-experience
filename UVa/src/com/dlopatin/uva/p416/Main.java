package com.dlopatin.uva.p416;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=357
*/
public class Main {

	private int usedPos;

	private static int[] DIGITS = new int[] { 0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011, 0b1011011,
			0b1011111, 0b1110000, 0b1111111, 0b1111011 };

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = 0;
			while ((n = scanner.nextInt()) != 0) {
				int[] lights = new int[n];
				for (int i = 0; i < n; i++) {
					int lightState = 0;
					char[] chars = scanner.next().toCharArray();
					for (int j = chars.length - 1; j >= 0; j--) {
						if (chars[j] == 'Y') {
							lightState |= 1 << (chars.length - 1 - j);
						}
					}
					lights[i] = lightState;
				}
				usedPos = 0;
//				String yesno = backtrack(0, resDominoes, dominoes) ? "MATCH" : "MISMATCH";
//				result.append(yesno).append(System.lineSeparator());
			}
			System.out.println(result.toString().trim());
		}

	}

//
//	private boolean backtrack(int number, int[] lights) {
//		while (number >= 0) {
//			if (place(result[prevPos], dominoes[pos], pos)) {
//				usedPos |= 1 << pos;
//				if (result[prevPos].isRotationNeeded(dominoes[pos])) {
//					dominoes[pos].rotate();
//				}
//				result[prevPos + 1] = dominoes[pos];
//				if (prevPos + 1 == result.length - 2) {
//					if (!result[prevPos + 1].isRotationNeeded(result[prevPos + 2])) {
//						return true;
//					}
//				} else if (backtrack(prevPos + 1, result, dominoes)) {
//					return true;
//				}
//				usedPos &= ~(1 << pos);
//			}
//		}
//		return false;
//	}

	private boolean place(int number, int light) {
		return (light | DIGITS[number]) == DIGITS[number] && (usedPos & (1 << number)) == 0;
	}

}
