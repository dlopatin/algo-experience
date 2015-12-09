package com.dlopatin.codejam.y2014.round0.problem.a;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class ProblemA {

	private final String FILE = "input.txt";
	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws Exception {
		ProblemA problemA = new ProblemA();
		problemA.doJob();

	}

	private void doJob() throws Exception {
		List<String> lines = readFile(FILE);
		if (lines == null || lines.size() == 0) {
			System.out.println("Empty file!");
		}
		int casesNumber = numberFormat.parse(lines.get(0).trim()).intValue();
		if (casesNumber < 1 && casesNumber > 100) {
			return;
		}
		int lineIdx = 1;
		for (int caseIdx = 0; caseIdx < casesNumber; caseIdx++) {
			int firstRow = numberFormat.parse(lines.get(lineIdx).trim()).intValue();
			if (firstRow < 1 || firstRow > 4) {
				cheat(caseIdx);
				continue;
			}
			int[] firstRowData = parseRowNumbers(lines.get(lineIdx + firstRow));
			lineIdx += 5;
			int secondRow = numberFormat.parse(lines.get(lineIdx).trim()).intValue();
			if (secondRow < 1 || secondRow > 4) {
				cheat(caseIdx);
				continue;
			}
			int[] secondRowData = parseRowNumbers(lines.get(lineIdx + secondRow));
			lineIdx += 5;
			Set<Integer> firstSet = new HashSet<Integer>(4);
			for (int number : firstRowData) {
				firstSet.add(number);
			}
			int result = -1;
			boolean bad = false;
			for (int number : secondRowData) {
				if (firstSet.contains(number)) {
					if (result == -1) {
						result = number;
					} else {
						bad(caseIdx);
						bad = true;
						break;
					}
				}
			}
			if (bad) {
				continue;
			}
			if (result == -1) {
				cheat(caseIdx);
				continue;
			}
			correct(caseIdx, result);

		}
	}

	private List<String> readFile(String file) throws IOException {
		String packagePath = this.getClass().getPackage().getName().replace(".", File.separator);
		String filePath = "src/main/java" + File.separator + packagePath + File.separator + file;
		return FileUtils.readLines(new File(filePath));
	}

	private int[] parseRowNumbers(String row) throws ParseException {
		int[] numbers = new int[4];
		String[] splitted = row.split("\\s+");
		Assert.assertEquals(splitted.length, 4);
		for (int i = 0; i < splitted.length; i++) {
			numbers[i] = numberFormat.parse(splitted[i]).intValue();
		}
		return numbers;
	}

	private void cheat(int caseIdx) {
		System.out.println(String.format("Case #%d: Volunteer cheated!", caseIdx + 1));
	}

	private void correct(int caseIdx, int answer) {
		System.out.println(String.format("Case #%d: %d", (caseIdx + 1), answer));
	}

	private void bad(int caseIdx) {
		System.out.println(String.format("Case #%d: Bad magician!", caseIdx + 1));
	}

}
