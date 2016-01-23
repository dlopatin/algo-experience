package com.dlopatin.facebook.y2016.qualification.a;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemA {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	public static void main(String[] args) throws Exception {
		new ProblemA().doJob();

	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int testCase = 0; testCase < t; testCase++) {
				int n = scanner.nextInt();
				Point[] points = new Point[n];
				for (int i = 0; i < n; i++) {
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					points[i] = new Point(x, y);
				}
				int sum = 0;
				for (int i = 0; i < n; i++) {
					Point point = points[i];
					Map<Integer, Integer> dist = new HashMap<>();
					for (int j = 0; j < n; j++) {
						if (i != j) {
							int distance = distance(point, points[j]);
							Integer key = dist.get(distance);
							if (key == null) {
								dist.put(distance, 1);
							} else {
								dist.put(distance, ++key);
							}
						}
					}
					for (int count : dist.values()) {
						sum += sum(count);
					}
				}
				printResult(res, testCase, sum);
			}
			writeOutput(res);
		}
	}

	private int distance(Point point, Point point2) {
		return (int) (Math.pow(point.x - point2.x, 2) + (Math.pow(point.y - point2.y, 2)));
	}

	private int sum(int value) {
		return (value * (value - 1)) / 2;
	}

	private class Point {
		private final int x;
		private final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	private File getInput() {
		return new File(getCurrentPath(FILE_IN));
	}

	private void writeFile(StringBuilder res, String file) throws IOException {
		String path = getCurrentPath(file);
		FileUtils.write(new File(path), res.toString().trim());
	}

	private String getCurrentPath(String file) {
		String packagePath = this.getClass().getPackage().getName().replace(".", File.separator);
		return "src" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(StringBuilder res) throws IOException {
		writeFile(res, FILE_OUT);
	}

	private void printResult(StringBuilder res, int caseIdx, int val) {
		res.append(String.format("Case #%d: %d\n", caseIdx + 1, val));
	}

}
