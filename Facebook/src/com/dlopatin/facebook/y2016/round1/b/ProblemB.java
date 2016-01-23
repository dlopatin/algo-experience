package com.dlopatin.facebook.y2016.round1.b;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemB {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	public static void main(String[] args) throws Exception {
		new ProblemB().doJob();

	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int testCase = 0; testCase < t; testCase++) {
				int l = scanner.nextInt();
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				long d = scanner.nextLong();
				long minW = Long.MAX_VALUE;
				long w[] = new long[n];
				for (int i = 0; i < n; i++) {
					w[i] = scanner.nextLong();
					minW = Math.min(minW, w[i]);
				}

				long timeMin = minW;
				long timeMax = minW * l;
				while (timeMin < timeMax) {
					long middleTime = timeMin + (timeMax - timeMin) / 2;
					long result = 0;
					for (int i = 0; i < n; i++) {
						result += middleTime / w[i];
					}
					if (result < l) {
						timeMin = middleTime + 1;
					} else {
						timeMax = middleTime;
					}
				}

				List<Long> workingTimes = new ArrayList<>(n);
				for (int i = 0; i < n; i++) {
					long lNumber = timeMin / w[i];
					for (long j = w[i]; j <= w[i] * lNumber; j += w[i]) {
						workingTimes.add(j);
					}
				}
				Collections.sort(workingTimes);
				long result = timeMin + d;
				for (int j = 0; j < m; j++) {
					long current = workingTimes.get(j) + d;

					for (int k = j + m; k < l; k += m) {
						if (current > workingTimes.get(k)) {
							current += d;
						} else {
							current = workingTimes.get(k) + d;
						}
					}
					result = Math.max(result, current);
				}

				printResult(res, testCase, result);
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

	private void printResult(StringBuilder res, int caseIdx, long val) {
		res.append(String.format("Case #%d: %d\n", caseIdx + 1, val));
	}

}
