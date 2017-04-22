package com.dlopatin.codejam.y2017.qualification.b;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
				long number = scanner.nextLong();
				List<Integer> digits = getDigits(number);
				if (digits.size() < 2) {
					printResult(res, caseIdx, String.valueOf(number));
					continue;
				} else {
					int stop = -1;
					for (int i = 1; i < digits.size(); i++) {
						if (digits.get(i - 1) > digits.get(i)) {
							stop = i;
							boolean dec = true;
							int fill9from = i;
							for (int j = i - 1; j >= 0; j--) {
								if (dec) {
									digits.set(j, digits.get(j) - 1);
									dec = false;
									if (j > 0 && digits.get(j - 1) > digits.get(j)) {
										dec = true;
										fill9from = j;
									}
									if (digits.get(j) < 1) {
										dec = true;
										if (j > 0) {
											digits.set(j, 9);
										} else {
											digits.set(j, 0);
										}
									}
								}
							}
							for (int j = fill9from; j < digits.size(); j++) {
								digits.set(j, 9);
							}
						}
					}
					if (stop < 0) {
						printResult(res, caseIdx, String.valueOf(number));
						continue;
					}
				}
				int idx = 0;
				while (idx++ < digits.size() && digits.get(0) == 0) {
					digits.remove(0);
					idx--;
				}
				boolean equals = digits.stream().sorted().collect(Collectors.toList()).equals(digits);
				if (!equals) {
					System.out.printf("Input: %d, output: %s", number, digits);
				}
				printResult(res, caseIdx, digits.stream().map(String::valueOf).collect(Collectors.joining()));
			}
			writeOutput(res);
		}
	}

	private List<Integer> getDigits(long number) {
		List<Integer> digits = new ArrayList<>();
		while (number > 0) {
			digits.add(0, (int) (number % 10));
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
