package com.dlopatin.codejam.y2017.round1b.a;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ProblemA {

	private final static String FILE_IN = "A-large.in";
	private final static String FILE_OUT = "A-large.out";

	private final static double A = .00000001;

	public static void main(String[] args) throws Exception {
		new ProblemA().doJob();
	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int caseIdx = 0; caseIdx < t; caseIdx++) {
				int d = scanner.nextInt();
				int n = scanner.nextInt();
				List<Horse> stat = new ArrayList<>(n);
				for (int horse = 0; horse < n; horse++) {
					stat.add(new Horse(scanner.nextInt(), scanner.nextInt()));
				}
				Collections.sort(stat, Comparator.comparing(Horse::getK).reversed());
				double longestH = 0;
				for (int idx = 0; idx < n; idx++) {
					Horse horse = stat.get(idx);
					if (idx == 0) {
						longestH = getDirectHours(d, horse);
						horse.meetPoint = d;
					} else {
						Horse nextHorse = stat.get(idx - 1);
						double horseH = getDirectHours(d, horse);
						if (horseH >= nextHorse.h) {
							horse.h = horseH;
							horse.meetPoint = d;
						} else {
							horse.meetPoint = getMeetPoint(horse, nextHorse, d);
							horse.h = (horse.meetPoint - horse.k) / horse.s + (d - horse.meetPoint) / nextHorse.s;
						}
						longestH = Math.max(longestH, horse.h);
					}

				}

				printResult(res, caseIdx, String.format("%.6f", d / longestH));
			}
			writeOutput(res);
		}
	}

	private double getDirectHours(int d, Horse nextHorse) {
		return nextHorse.h = (d - nextHorse.k) / (double) nextHorse.s;
	}

	private double getMeetPoint(Horse horse1, Horse horse2, int d) {
		double lo = 0;
		double hi = d;
		while (lo <= hi) {
			double mid = lo + (hi - lo) / 2;
			double h1 = ((mid - horse1.k) / horse1.s);
			double h2 = ((mid - horse2.k) / horse2.s);
			if (Math.abs(h1 - h2) < A && Math.abs(h2 - h1) < A) {
				return Math.round(mid * 10e6) / 10e6;
			} else if (h1 > h2) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return 0;
	}

	private static class Horse {
		private final int k;
		private final int s;
		private double h;
		private double meetPoint;

		public Horse(int k, int s) {
			super();
			this.k = k;
			this.s = s;
		}

		public int getK() {
			return k;
		}

	}

	private File getInput() {
		return new File(getCurrentPath(FILE_IN));
	}

	private void writeFile(StringBuilder res, String file) throws IOException {
		String path = getCurrentPath(file);
		FileUtils.write(new File(path), res);
	}

	private String getCurrentPath(String file) {
		String packagePath = this.getClass().getPackage().getName().replace(".", File.separator);
		return "src/main/java" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(StringBuilder res) throws IOException {
		writeFile(res, FILE_OUT);
	}

	private void printResult(StringBuilder res, int caseIdx, String val) {
		res.append(String.format("Case #%d: %s\n", caseIdx + 1, val));
	}

}
