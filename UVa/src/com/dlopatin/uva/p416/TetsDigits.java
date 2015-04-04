package com.dlopatin.uva.p416;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=357
*/
public class TetsDigits {

//	private int usedPos;

	private static int[] DIGITS = new int[] { 0b1111110, 0b0110000, 0b1101101, 0b1111001, 0b0110011, 0b1011011,
			0b1011111, 0b1110000, 0b1111111, 0b1111011 };

	public static void main(String[] args) {
		new TetsDigits().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {

			int lightState = 0;
			char[] chars = scanner.next().toCharArray();
			for (int j = chars.length - 1; j >= 0; j--) {
				if (chars[j] == 'Y') {
					lightState |= 1 << (chars.length - 1 - j);
				}
			}

			for (int i = 0; i < DIGITS.length; i++) {
				if ((lightState | DIGITS[i]) == DIGITS[i]) {
					System.out.println(i);
				}
			}

		}

	}

}
