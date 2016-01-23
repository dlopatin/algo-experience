package com.dlopatin.facebook.y2016.round2.a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
				char[] asrc = scanner.next().toCharArray();
				char[] adst = scanner.next().toCharArray();
				Set<Integer> startPos = new HashSet<>();
				startPos.add(n / 2);
				int seqCnt = 0;
				for (int i = n >> 1; i >= 0; i--) {
					if (asrc[i] != adst[i]) {
						if (seqCnt != 0) {
							startPos.add(i);
						}
					} else {
						seqCnt++;
					}
				}
				int cnt = 0;
				for (int i = 1; i < n; i++) {
					if (adst[i] == adst[i - 1]) {
						cnt++;
					} else if (cnt > 0) {
						startPos.add(i - 1);
					}
				}
				int minCnt = Integer.MAX_VALUE;
				for (int starti : startPos) {
					int iterationCnt = 0;
					char[] src = Arrays.copyOf(asrc, n);
					char[] dst = Arrays.copyOf(adst, n);
					for (int i = starti; i >= 0; i--) {
						while (i >= 0 && src[i] == dst[i]) {
							i--;
						}
						if (i >= 0) {
							for (int j = i; j >= 0; j--) {
								src[j] = dst[i];
							}
							int jill = i + 1;
							while (jill < src.length - 1 && src[jill] == dst[jill]) {
								jill++;
							}
							int jillHere = jill;
							while (jillHere < src.length) {
								src[jillHere] = dst[jill];
								jillHere++;
							}
							iterationCnt++;
						} else {
							// left side ended, but right not
							int jillStart = i;
							while (!Arrays.equals(src, dst)) {
								int jill = jillStart + 1;
								while (jill < src.length - 1 && src[jill] == dst[jill]) {
									jill++;
								}
								int jillHere = jill;
								while (jillHere < src.length) {
									src[jillHere] = dst[jill];
									jillHere++;
								}
								iterationCnt++;
								jillStart = jill;
							}
						}
					}
					if (Arrays.equals(src, dst)) {
						minCnt = Math.min(iterationCnt, minCnt);
					}
				}
				printResult(res, testCase, minCnt);
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
