package com.dlopatin.bayan.y2014.qualification;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ProblemB {

	private final static String FILE_IN = ProblemB.class.getSimpleName() + ".in";
	private final static String FILE_OUT = ProblemB.class.getSimpleName() + ".out";

	private static final String VOWELS = "AEIOU".toLowerCase();

	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws Exception {
		new ProblemB().doJob();
	}

	private void doJob() throws Exception {
		List<String> inData = readFile(FILE_IN);
		if (inData == null || inData.size() == 0) {
			System.out.println("Empty file!");
		}
		int casesNumber = numberFormat.parse(inData.get(0).trim()).intValue();
		List<String> result = new ArrayList<>(casesNumber);
		for (int caseIdx = 1; caseIdx <= casesNumber; caseIdx++) {
			char[] name = inData.get(caseIdx).trim().toCharArray();
			int vowesCounter = 0;
			for (int i = 0; i < name.length; i++) {
				if (isVowel(name[i])) {
					vowesCounter++;
				}
			}
			result.add(vowesCounter % 2 == 0 ? "DOKHTAR" : "PESAR");
		}
		writeOutput(result);
	}

	private boolean isVowel(char ch) {
		return VOWELS.contains(Character.toString(ch).toLowerCase());
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
		return "src" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(List<String> data) throws IOException {
		writeFile(data, FILE_OUT);
	}

}
