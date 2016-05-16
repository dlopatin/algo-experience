package com.dlopatin.codejam.y2016.qualification.a;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
				final long n = scanner.nextLong();
				if (n == 0) {
					printResult(res, caseIdx, "INSOMNIA");
				} else {
					Set<Integer> digits = new HashSet<>();
					long lastNumber = 0;
					for (int i = 1; i < Integer.MAX_VALUE && digits.size() < 10; i++) {
						long number = n * i;
						digits.addAll(getDigits(number));
						lastNumber = number;
					}
					if (digits.size() < 10) {
						printResult(res, caseIdx, "INSOMNIA");
					} else {
						printResult(res, caseIdx, String.valueOf(lastNumber));
					}
				}
			}
			writeOutput(res);
		}
	}

	private Set<Integer> getDigits(long number) {
		Set<Integer> digits = new HashSet<>();
		while (number > 0) {
			digits.add((int) (number % 10));
			number /= 10;
		}
		return digits;
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
