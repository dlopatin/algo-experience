package com.dlopatin.codejam.y2015.qualification.b;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
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
				int n = scanner.nextInt();
				PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(n, Collections.reverseOrder());
				for (int i = 0; i < n; i++) {
					maxQueue.offer(scanner.nextInt());
				}

				int minTime = maxQueue.peek();
				int timeCounter = 0;
				int caseTime = minTime;

				while (minTime <= caseTime && maxQueue.peek() > 2) {
					int max = maxQueue.peek();
					while (maxQueue.peek() == max && max > 2) {
						maxQueue.poll();
						maxQueue.offer(max / 2);
						maxQueue.offer(max - (max / 2));
						timeCounter++;
					}
					caseTime = timeCounter + maxQueue.peek();
					minTime = Math.min(minTime, caseTime);
				}
				printResult(res, testCase, minTime);
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
		return "src/main/java" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(StringBuilder res) throws IOException {
		writeFile(res, FILE_OUT);
	}

	private void printResult(StringBuilder res, int caseIdx, int val) {
		res.append(String.format("Case #%d: %d\n", caseIdx + 1, val));
	}

}
