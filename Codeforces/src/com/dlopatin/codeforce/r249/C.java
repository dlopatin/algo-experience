package com.dlopatin.codeforce.r249;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException, ParseException {
		new C().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfInputs = scanner.nextInt();
			int a[] = new int[numberOfInputs];
			int height = 0;
			int max = 0;
			int min = 0;
			int current = 0;
			int width = 0;
			for (int inputIdx = 0; inputIdx < numberOfInputs; inputIdx++) {
				int nextInt = scanner.nextInt();
				a[inputIdx] = nextInt;
				width += nextInt;
				if (inputIdx % 2 == 0) {
					current += nextInt;
					max = current > max ? current : max;
				} else {
					current -= nextInt;
					min = current < min ? current : min;
				}
			}
			max = Math.abs(max);
			min = Math.abs(min);
			height = max + min;
			int[][] scale = new int[height][width];
			int y = max - 1;
			int x = 0;
			for (int inputIdx = 0; inputIdx < numberOfInputs; inputIdx++) {
				int val = a[inputIdx];
				while (val > 0) {
					if (inputIdx % 2 == 0) {
						scale[y][x] = 1;
						if (val > 1) {
							y--;
						}
					} else {
						scale[y][x] = -1;
						if (val > 1) {
							y++;
						}
					}
					x++;
					val--;
				}
			}
			StringBuilder builder = new StringBuilder();
			for (int yy = 0; yy < height; yy++) {
				for (int xx = 0; xx < width; xx++) {
					char character = 0;
					switch (scale[yy][xx]) {
					case 1:
						character = '/';
						break;
					case 0:
						character = ' ';
						break;
					case -1:
						character = '\\';
						break;
					default:
						break;
					}
					builder.append(character);
				}
				builder.append("\n");
			}
			System.out.println(builder.toString());
		}
	}
}
