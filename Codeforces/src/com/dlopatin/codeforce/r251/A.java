package com.dlopatin.codeforce.r251;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws IOException, ParseException {
		new A().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int songsNumber = scanner.nextInt();
			int totalTime = scanner.nextInt();
			int currentTime = 0;
			int jokesCount = 0;
			for (int songIdx = 1; songIdx <= songsNumber; songIdx++) {
				currentTime += scanner.nextInt();
				if (currentTime > totalTime) {
					jokesCount = -1;
					break;
				}
				if (songIdx == songsNumber) {
					while (currentTime + 5 <= totalTime) {
						currentTime += 5;
						jokesCount++;
					}
				} else {
					currentTime += 10;
					jokesCount += 2;
				}
			}
			System.out.println(jokesCount);

		}
	}
}
