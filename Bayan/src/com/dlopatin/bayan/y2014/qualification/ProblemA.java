package com.dlopatin.bayan.y2014.qualification;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ProblemA {

	private final static String FILE_IN = ProblemA.class.getSimpleName() + ".in";
	private final static String FILE_OUT = ProblemA.class.getSimpleName() + ".out";

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
		List<String> result = new ArrayList<>(casesNumber);
		for (int caseIdx = 1; caseIdx <= casesNumber; caseIdx++) {
			String res = new StringBuilder(inData.get(caseIdx)).reverse().toString();
			result.add(res);
		}
		writeOutput(result);
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
