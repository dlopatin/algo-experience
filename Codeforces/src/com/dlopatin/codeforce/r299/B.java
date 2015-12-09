package com.dlopatin.codeforce.r299;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/535/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] luckyArray = new int[1022];
			luckyArray[0] = 4;
			luckyArray[1] = 7;
			int power = 10;
			int index = 1;
			for (int i = 2; i < (2 << 8); i <<= 1) {
				int startIndex = index;
				// add 4 to beginning
				for (int j = 0; j < i; j++) {
					luckyArray[++index] = luckyArray[0] * power + luckyArray[startIndex - i + j + 1];
				}
				// add 7 to beginning
				for (int j = 0; j < i; j++) {
					luckyArray[++index] = luckyArray[1] * power + luckyArray[startIndex - i + j + 1];
				}
				power *= 10;
			}
			System.out.println(Arrays.binarySearch(luckyArray, n) + 1);
		}
	}

	private boolean isLucky(int n) {
		while (n != 0) {
			int digit = n % 10;
			if (!(digit == 4 || digit == 7)) {
				return false;
			}
			n /= 10;
		}
		return true;
	}

}