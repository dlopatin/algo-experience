package com.dlopatin.codeforce.r250;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

	private static final int SIZE = 4;

	public static void main(String[] args) throws IOException, ParseException {
		new A().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int maxLength = 0;
			String maxAnswer = "";
			int minLength = 101;
			String minAnswer = "";
			int lengths[] = new int[SIZE];
			for (int i = 0; i < SIZE; i++) {
				String answer = scanner.next();
				int size = answer.length() - 2;
				if (maxLength < size) {
					maxLength = size;
					maxAnswer = answer.substring(0, 1);
				}
				if (size < minLength) {
					minLength = size;
					minAnswer = answer.substring(0, 1);
				}
				lengths[i] = size;
			}
			List<Integer> bestAnswers = new ArrayList<>(4);
			int minLengthCount = 0;
			int maxLengthCount = 0;
			for (int i = 0; i < lengths.length; i++) {
				int size = lengths[i];
				if (minLength <= size / 2.0) {
					minLengthCount++;
				}
				if (maxLength >= size * 2.0) {
					maxLengthCount++;
				}
			}
			String answer = "C";
			if (maxLengthCount < minLengthCount && minLengthCount == 3) {
				answer = minAnswer;
			}
			if (maxLengthCount > minLengthCount && maxLengthCount == 3) {
				answer = maxAnswer;
			}
			System.out.println(answer);

		}
	}
}
