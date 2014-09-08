package com.dlopatin.codeforce.r248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.StringTokenizer;

public class A {

	private static final String NO = "NO";
	private static final String YES = "YES";
	NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws IOException, ParseException {
		new A().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int n = numberFormat.parse(reader.readLine()).intValue();
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int[] weights = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += numberFormat.parse(tokenizer.nextToken()).intValue();

			}
			String result = NO;
			if (n <= 1) {
				result = NO;
			} else {
				if (sum % 200 == 0) {
					result = YES;
				}
			}
			System.out.println(result);
		}

	}
}
