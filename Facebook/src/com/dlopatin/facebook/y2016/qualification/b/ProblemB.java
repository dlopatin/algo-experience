package com.dlopatin.facebook.y2016.qualification.b;

import java.io.File;
import java.io.IOException;
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
				scanner.nextLine();
				char[][] grid = new char[2][n];
				for (int i = 1; i >= 0; i--) {
					char[] line = scanner.nextLine().toCharArray();
					for (int j = 0; j < n; j++) {
						grid[i][j] = line[j];
					}
				}
				int cnt = 0;
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < n; j++) {
						if (isCellFree(i, j, grid)) {
							if (isAlone(i, j, grid)) {
								int oppositeLine = Math.abs(i - 1);
								if (grid[oppositeLine][j] != 'X') {
									markLineGuarded(oppositeLine, j, grid);
								} else {
									markLineGuarded(i, j, grid);
								}
								grid[i][j] = '*';
								cnt++;
							}
						}
					}
				}
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < n; j++) {
						if (isCellFree(i, j, grid)) {
							markLineGuarded(i, j, grid);
							grid[i][j] = '*';
							cnt++;
						}
					}
				}
				printResult(res, testCase, cnt);
			}
			writeOutput(res);
		}
	}

	boolean isCellFree(int i, int j, char[][] grid) {
		return grid[i][j] != 'X' && grid[i][j] != '*';
	}

	private boolean isAlone(int i, int j, char[][] grid) {
		if (grid[i].length < 2) {
			return true;
		}
		if (j == 0) {
			return grid[i][j + 1] == 'X';
		}
		if (j == grid[i].length - 1) {
			return grid[i][j - 1] == 'X';
		}
		return grid[i][j + 1] == 'X' && grid[i][j - 1] == 'X';
	}

	private void markLineGuarded(int i, int j, char[][] grid) {
		if (!isCellFree(i, j, grid)) {
			return;
		}
		for (int left = j; left >= 0 && grid[i][left] != 'X'; left--) {
			grid[i][left] = '*';
		}
		for (int right = j + 1; right < grid[i].length && grid[i][right] != 'X'; right++) {
			grid[i][right] = '*';
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
