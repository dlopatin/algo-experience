package com.dlopatin.codejam.y2017.qualification.a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemA {

	private final static String FILE_IN = "A-large.in";
	private final static String FILE_OUT = "A-large.out";

	public static void main(String[] args) throws Exception {
		new ProblemA().doJob();
	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int caseIdx = 0; caseIdx < t; caseIdx++) {
				final char[] stack = scanner.next().toCharArray();
				int k = scanner.nextInt();
				int counter = 0;
				boolean solution = true;
				for (int i = 0; i < stack.length; i++) {
					if (stack[i] == '-') {
						if (i <= stack.length - k) {
							counter++;
							for (int j = i; j < i + k; j++) {
								stack[j] = stack[j] == '-' ? '+' : '-';
							}
						} else {
							solution = false;
						}
					}
				}
				printResult(res, caseIdx, solution ? String.valueOf(counter) : "IMPOSSIBLE");
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
