package com.dlopatin.codejam.y2015.qualification.a;

import java.io.File;
import java.io.IOException;
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
			for (int caseIdx = 0; caseIdx < t; caseIdx++) {
				int n = scanner.nextInt();
				int[] sums = new int[n + 1];
				int counter = 0;
				char[] s = scanner.next().toCharArray();
				for (int i = 0; i < sums.length; i++) {
					if (i == 0) {
						sums[i] = Character.getNumericValue(s[i]);
					} else {
						int people = sums[i - 1] >= i ? 0 : i - sums[i - 1];
						counter += people;
						sums[i] = sums[i - 1] + Character.getNumericValue(s[i]) + people;
					}
				}
				printResult(res, caseIdx, counter);
			}
			writeOutput(res);
		}
	}

	private File getInput() {
		return new File(getCurrentPath(FILE_IN));
	}

	private void writeFile(StringBuilder res, String file) throws IOException {
		String path = getCurrentPath(file);
		FileUtils.write(new File(path), res);
	}

	private String getCurrentPath(String file) {
		String packagePath = this.getClass().getPackage().getName().replace(".", File.separator);
		return "src/main/java" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(StringBuilder res) throws IOException {
		writeFile(res, FILE_OUT);
	}

	private void printResult(StringBuilder res, int caseIdx, int val) {
		res.append(String.format("Case #%d: %d\n", caseIdx + 1, val));
	}

}
