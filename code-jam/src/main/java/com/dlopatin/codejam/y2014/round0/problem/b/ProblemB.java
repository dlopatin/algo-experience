package com.dlopatin.codejam.y2014.round0.problem.b;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class ProblemB {

	private final String FILE_IN = "input.txt";
	private final String FILE_OUT = "output.txt";
	private final NumberFormat numberFormat = new DecimalFormat("#.0000000");

	public static void main(String[] args) throws Exception {
		new ProblemB().doJob();

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
		for (int caseIdx = 0; caseIdx < casesNumber; caseIdx++) {
			String inLine = inData.get(caseIdx + 1);
			String[] splitted = inLine.split(" ");
			Assert.assertEquals(splitted.length, 3);
			double c = numberFormat.parse(splitted[0]).doubleValue();
			double f = numberFormat.parse(splitted[1]).doubleValue();
			double x = numberFormat.parse(splitted[2]).doubleValue();
			double cookiesPerSecond = 2;
			double totalTime = 0;
			double timeToGoal = 0;
			double timeNext = -1;
			while (timeNext < timeToGoal) {
				timeToGoal = calcTime(cookiesPerSecond, x);
				double timeToBuyFarm = calcTime(cookiesPerSecond, c);
				timeNext = calcTimeForNextBuyAndWaiting(cookiesPerSecond, c, f, x);
				if (timeNext < timeToGoal) {
					cookiesPerSecond += f;
					totalTime += timeToBuyFarm;
				} else {
					totalTime += timeToGoal;
				}
			}
			printResult(result, caseIdx, totalTime);
		}
		writeOutput(result);
	}

	private double calcTimeForNextBuyAndWaiting(double cookiesPerSecond, double farmCost, double additionalCookie,
			double goal) throws ParseException {
		double res = 0;
		res += calcTime(cookiesPerSecond, farmCost);
		res += calcTime(cookiesPerSecond + additionalCookie, goal);
		return res;
	}

	private double calcTime(double cookiesPerSecond, double goal) throws ParseException {
		String val = numberFormat.format(goal / cookiesPerSecond);
		return numberFormat.parse(val).doubleValue();
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

	private void printResult(List<String> resList, int caseIdx, double val) {
		resList.add(String.format("Case #%d: %s", caseIdx + 1, numberFormat.format(val)));
	}
}
