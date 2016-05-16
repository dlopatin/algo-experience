package com.dlopatin.codejam.y2016.qualification.b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemB {

	private final static String FILE_IN = "B-large.in";
	private final static String FILE_OUT = "B-large.out";

	public static void main(String[] args) throws Exception {
		new ProblemB().doJob();
	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int caseIdx = 0; caseIdx < t; caseIdx++) {
				final char[] stack = scanner.next().toCharArray();
				int counter = 0;
				for (int i = stack.length - 1; i >= 0; i--) {
					if (stack[i] == '-') {
						counter++;
						for (int j = 0; j < i; j++) {
							if (stack[j] == '-') {
								stack[j] = '+';
							} else {
								stack[j] = '-';
							}
						}
					}
				}
				printResult(res, caseIdx, String.valueOf(counter));
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

	private void printResult(StringBuilder res, int caseIdx, String val) {
		res.append(String.format("Case #%d: %s\n", caseIdx + 1, val));
	}

}
