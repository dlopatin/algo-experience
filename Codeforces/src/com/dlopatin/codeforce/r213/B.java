package com.dlopatin.codeforce.r213;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/365/problem/B
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = scanner.nextInt();
			}
			int count=2;
			if (n>2){
				int length=2;
				for (int i=2; i<n; i++){
					if(numbers[i] == numbers[i-1] + numbers[i-2]){
						length++;
					} else {
						length = 2;
					}
					count = Math.max(length, count);
				}
			} else {
				count = n;
			}
			System.out.println(count);
		}
	}

}
