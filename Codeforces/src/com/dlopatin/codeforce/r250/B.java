package com.dlopatin.codeforce.r250;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int sum = scanner.nextInt();
			int maxVal = scanner.nextInt();
			int size = 0;
			StringBuilder builder = new StringBuilder();
			for (int i = 65536; i >= 1; i >>= 1) {
				for (int j = i; j <= maxVal; j += i << 1) {
					if (i <= sum) {
						sum -= i;
						if (size != 0) {
							builder.append(' ');
						}
						size++;
						builder.append(j);
					}
				}
			}
			if (sum == 0) {
				System.out.println(size);
				System.out.println(builder);
			} else {
				System.out.println(-1);
			}
		}
	}

}
