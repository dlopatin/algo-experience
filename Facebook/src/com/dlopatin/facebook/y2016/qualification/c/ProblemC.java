package com.dlopatin.facebook.y2016.qualification.c;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemC {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	public static void main(String[] args) throws Exception {
		new ProblemC().doJob();

	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int testCase = 0; testCase < t; testCase++) {
				int n = scanner.nextInt();
				int p = scanner.nextInt();
				long cnt = 0;
				int[] array = new int[n];
				int sum = 0;
				int left = 0;
				int leftFromPrev = 0;
				int newElCnt = 0;
				for (int i = 0; i < n; i++) {
					array[i] = scanner.nextInt();
					sum += array[i];
					if (sum <= p) {
						newElCnt++;
					} else {
						cnt += func(newElCnt) - func(leftFromPrev);
						leftFromPrev = newElCnt;
						while (sum > p && left < n) {
							newElCnt--;
							leftFromPrev--;
							sum -= array[left];
							left++;
						}
						newElCnt++;
					}
				}
				cnt += func(newElCnt) - func(leftFromPrev);
				printResult(res, testCase, cnt);
			}
			writeOutput(res);
		}
	}

	private long func(int value) {
		return ((long) value * (value + 1)) / 2;
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

	private void printResult(StringBuilder res, int caseIdx, long val) {
		res.append(String.format("Case #%d: %d\n", caseIdx + 1, val));
	}

}
