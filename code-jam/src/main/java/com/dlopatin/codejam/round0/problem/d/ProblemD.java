package com.dlopatin.codejam.round0.problem.d;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ProblemD {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws Exception {
		new ProblemD().doJob();
	}

	private void doJob() throws Exception {
		numberFormat.setRoundingMode(RoundingMode.HALF_UP);
		List<String> inData = readFile(FILE_IN);
		if (inData == null || inData.size() == 0) {
			System.out.println("Empty file!");
		}
		int casesNumber = numberFormat.parse(inData.get(0).trim()).intValue();
		if (casesNumber < 1 && casesNumber > 100) {
			return;
		}
		List<String> result = new ArrayList<>(casesNumber);
		int lineIdx = 1;
		for (int caseIdx = 0; caseIdx < casesNumber; caseIdx++) {
			int blocksNumber = numberFormat.parse(inData.get(lineIdx).trim()).intValue();
			List<Double> naomies = getBlocks(inData, ++lineIdx);
			List<Double> kens = getBlocks(inData, ++lineIdx);
			int deceitfulStrategy = deceitfulStrategy(naomies, kens);
			int honestStrategy = honestStrategy(naomies, kens);
			printResult(result, caseIdx, deceitfulStrategy, honestStrategy);
			lineIdx++;
		}
		writeOutput(result);
	}

	private int deceitfulStrategy(List<Double> aNaomies, List<Double> aKens) {
		int res = 0;
		List<Double> naomies = new ArrayList<>(aNaomies.size());
		naomies.addAll(aNaomies);
		List<Double> kens = new ArrayList<>(aKens.size());
		kens.addAll(aKens);
		res += filterFromMax(naomies, kens);
		while (naomies.size() != 0) {
			double naomiRealVal = naomies.get(0);
			double lastKensVal = kens.get(kens.size() - 1);
			if (naomiRealVal > lastKensVal) {
				res++;
			}
			naomies.remove(0);
			kens.remove(kens.size() - 1);
			res += filterFromMax(naomies, kens);
		}
		return res;
	}

	private int filterFromMax(List<Double> naomies, List<Double> kens) {
		int res = 0;
		for (int index = naomies.size() - 1; index >= 0; index--) {
			if (naomies.get(index) > kens.get(index)) {
				res++;
				naomies.remove(index);
				kens.remove(index);
			} else {
				break;
			}
		}
		return res;
	}

	private int honestStrategy(List<Double> naomies, List<Double> kens) {
		int res = 0;
		while (naomies.size() != 0) {
			double naomiVal = naomies.get(0);
			double nextKensVal = findNextKensVal(kens, naomiVal);
			if (naomiVal > nextKensVal) {
				res++;
			}
			naomies.remove(0);
			kens.remove(nextKensVal);
		}
		return res;
	}

	private double findNextKensVal(List<Double> list, double value) {
		for (double val : list) {
			if (val > value) {
				return val;

			}
		}
		return list.get(0);
	}

	private List<Double> getBlocks(List<String> inData, int lineIdx) throws ParseException {
		String[] blocks = inData.get(lineIdx).trim().split(" ");
		List<Double> res = new LinkedList<>();
		for (String block : blocks) {
			res.add(numberFormat.parse(block).doubleValue());
		}
		Collections.sort(res);
		return res;
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

	private void printResult(List<String> resList, int caseIdx, int deceitful, int honest) {
		resList.add(String.format("Case #%d: %d %d", caseIdx + 1, deceitful, honest));
	}

}
