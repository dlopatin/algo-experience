package com.dlopatin.facebook.y2016.round1.a;

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
			for (int testCase = 0; testCase < t; testCase++) {
				int n = scanner.nextInt();
				int prev = 0;
				int sum = 0;
				int seqCnt = 1;
				for (int i = 0; i < n; i++) {
					int current = scanner.nextInt();
					if (i != 0) {
						if (current > prev) {
							// OK
							int delta = current - prev;
							if (delta <= 10) {
								seqCnt++;
								seqCnt = seqCnt % 4;
							} else {
								if (seqCnt != 0 && delta <= (4 - seqCnt) * 10) {
									// we can insert number
									seqCnt++;
									int toInsert = (delta - 1) / 10;
									toInsert = toInsert > 0 ? toInsert : 1;
									sum += toInsert;
									seqCnt += toInsert;
									seqCnt = seqCnt % 4;
								} else {
									// finish current sequence and start new one with current value
									sum += seqCnt == 0 ? 0 : 4 - seqCnt;
									seqCnt = 1;
								}
							}
						} else {
							// new sequence
							sum += seqCnt == 0 ? 0 : 4 - seqCnt;
							seqCnt = 1;
						}
					}
					prev = current;
				}
				sum += seqCnt == 0 ? 0 : 4 - seqCnt;
				printResult(res, testCase, sum);
			}
			writeOutput(res);
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
