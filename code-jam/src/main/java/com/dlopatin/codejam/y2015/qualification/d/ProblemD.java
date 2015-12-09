package com.dlopatin.codejam.y2015.qualification.d;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemD {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	public static void main(String[] args) throws Exception {
		new ProblemD().doJob();

	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int testCase = 0; testCase < t; testCase++) {
				int x = scanner.nextInt();
				int r = scanner.nextInt();
				int c = scanner.nextInt();
				String mylittleBaby = "RICHARD";
				if (x == 1) {
					mylittleBaby = "GABRIEL";
				} else if (x == 2 && (r % 2 == 0 || c % 2 == 0)) {
					mylittleBaby = "GABRIEL";
				} else if (x == 3 && ((r == 3 && c > 1) || (c == 3 && r > 1))) {
					mylittleBaby = "GABRIEL";
				} else if (x == 4 && ((c == 4 && r > 2) || (r == 4 && c > 2))) {
					mylittleBaby = "GABRIEL";
				}
				printResult(res, testCase, mylittleBaby);
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
