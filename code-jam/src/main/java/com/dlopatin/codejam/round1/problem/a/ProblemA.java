package com.dlopatin.codejam.round1.problem.a;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ProblemA {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	private static final String NOT_POSSIBLE = "NOT POSSIBLE";

	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws Exception {
		new ProblemA().doJob();

	}

	private void doJob() throws Exception {
		List<String> inData = readFile(FILE_IN);
		if (inData == null || inData.size() == 0) {
			System.out.println("Empty file!");
		}
		int casesNumber = numberFormat.parse(inData.get(0).trim()).intValue();
		int line = 1;
		List<String> result = new ArrayList<>(casesNumber);
		for (int caseIdx = 0; caseIdx < casesNumber; caseIdx++) {
			int index = caseIdx * 3 + 1;
			String[] inNumbers = inData.get(index).trim().split("\\s+");
			int n = numberFormat.parse(inNumbers[0]).intValue();
			int l = numberFormat.parse(inNumbers[1]).intValue();

			String[] nLineString = inData.get(++index).trim().split("\\s+");
			int[] nLine = new int[nLineString.length];
			for (int i = 0; i < nLineString.length; i++) {
				nLine[i] = Integer.parseInt(nLineString[i], 2);
			}

			String[] lLineString = inData.get(++index).trim().split("\\s+");
			int[] lLine = new int[lLineString.length];
			for (int i = 0; i < lLineString.length; i++) {
				lLine[i] = Integer.parseInt(lLineString[i], 2);
			}

			int nAND = ~((~0) << l);
			for (int val : nLine) {
				nAND &= val;
			}

			int lAND = ~((~0) << l);
			for (int val : lLine) {
				lAND &= val;
			}

			if (nAND != lAND) {
				printResult(result, caseIdx, NOT_POSSIBLE);
				continue;
			} else {
				int nXOR = 0;
				for (int val : nLine) {
					nXOR ^= val;
				}

				int lXOR = 0;
				for (int val : lLine) {
					lXOR ^= val;
				}

				int count = 0;
				for (int pos = 0; pos < l; pos++) {
					if (getBit(nXOR, pos) != getBit(lXOR, pos)) {
						count++;
					}
				}
				printResult(result, caseIdx, String.valueOf(count));
			}
		}
		writeOutput(result);
	}

	private byte getBit(int val, int position) {
		return (byte) ((val >>> position) & 1);
	}

	private List<String> readFile(String file) throws IOException {
		String filePath = getCurrentPath(file);
		return FileUtils.readLines(new File(filePath));
	}

	private void writeFile(List<String> data, String file) throws IOException {
		String path = getCurrentPath(file);
		FileUtils.writeLines(new File(path), data);
	}

	private String getCurrentPath(String file) {
		String packagePath = this.getClass().getPackage().getName().replace(".", File.separator);
		return "src/main/java" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(List<String> data) throws IOException {
		data.forEach(System.out::println);
		writeFile(data, FILE_OUT);
	}

	private void printResult(List<String> resList, int caseIdx, String val) {
		resList.add(String.format("Case #%d: %s", caseIdx + 1, val));
	}

}
