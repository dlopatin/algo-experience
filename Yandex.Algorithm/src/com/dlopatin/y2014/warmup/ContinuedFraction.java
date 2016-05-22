package com.dlopatin.y2014.warmup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContinuedFraction {

	private static final BigInteger BIG_ZERO = BigInteger.ZERO;
	private static final BigInteger BIG_ONE = BigInteger.ONE;
	private static final String FILE_IN = "input.txt";
	private static final String FILE_OUT = "output.txt";

	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws ParseException, IOException {
		new ContinuedFraction().doJob();
	}

	private void doJob() throws ParseException, IOException {
		int n;
		String[] toParse;
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_IN))) {
			n = numberFormat.parse(br.readLine().trim()).intValue();
			toParse = br.readLine().trim().split("\\s+");
		}
		int[] fractions = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			fractions[i] = numberFormat.parse(toParse[i]).intValue();
		}

		List<Integer> result = new ArrayList<>();
		result.add(0);
		int a1 = fractions[1];
		int startCopyFrom = 0;
		if (a1 > 1) {
			result.add(1);
			result.add(a1 - 1);
			startCopyFrom = 2;
		} else {
			result.add(1 + fractions[2]);
			startCopyFrom = 3;
		}
		for (int i = startCopyFrom; i < fractions.length; i++) {
			result.add(fractions[i]);
		}

		try (PrintWriter writer = new PrintWriter(FILE_OUT, "UTF-8")) {
			writer.println(result.size() - 1);
			StringBuilder sb = new StringBuilder();
			for (int val : result) {
				sb.append(val).append(" ");
			}
			writer.println(sb.toString().trim());
		}

	}

	private double calcValue(int[] fractions) {
		double res = fractions[fractions.length - 1];
		for (int i = fractions.length - 2; i >= 0; i--) {
			res = fractions[i] + 1 / res;
		}
		return res;
	}

	private BigInteger findNumerator(BigInteger[] fraction) {
		List<BigInteger> pList = new ArrayList<>(fraction.length + 5);
		pList.add(BIG_ONE);
		pList.add(fraction[0]);
		for (int i = 1; i < fraction.length; i++) {
			BigInteger p = pList.get(i).multiply(fraction[i]).add(pList.get(i - 1));
			pList.add(p);
		}
		return pList.get(pList.size() - 1);
	}

	private BigInteger findDenominator(BigInteger[] fraction) {
		List<BigInteger> qList = new ArrayList<>(fraction.length + 5);
		qList.add(BIG_ZERO);
		qList.add(BIG_ONE);
		for (int i = 1; i < fraction.length; i++) {
			BigInteger q = qList.get(i).multiply(fraction[i]).add(qList.get(i - 1));
			qList.add(q);
		}
		return qList.get(qList.size() - 1);
	}

	private Fraction reverseFraction(Fraction fraction) {
		return new Fraction(fraction.getQ().subtract(fraction.getP()), fraction.getQ());
	}

	private List<Integer> findFraction(double val) {
		List<Integer> fractions = new LinkedList<>();
		int a = (int) val;
		double x = val - a;
		fractions.add(a);
		while (x > 0) {
			a = (int) (1 / x);
			fractions.add(a);
			x = 1.0 / x - a;
		}
		return fractions;
	}

	private List<Integer> findFraction(Fraction fraction) {
		List<Integer> fractions = new LinkedList<>();
		while (true) {
			BigInteger a = fraction.getP().divide(fraction.getQ());
			fractions.add(a.intValue());
			BigInteger newP = fraction.getP().subtract(a.multiply(fraction.getQ()));
			if (newP.compareTo(BIG_ZERO) == 0) {
				break;
			}
			// rotate
			fraction.setP(fraction.getQ());
			fraction.setQ(newP);
		}
		return fractions;
	}

	private class Fraction {

		private BigInteger p;
		private BigInteger q;

		public Fraction(BigInteger p, BigInteger q) {
			this.p = p;
			this.q = q;
		}

		public BigInteger getP() {
			return p;
		}

		public BigInteger getQ() {
			return q;
		}

		public void setP(BigInteger p) {
			this.p = p;
		}

		public void setQ(BigInteger q) {
			this.q = q;
		}

		@Override
		public String toString() {
			return getP() + "/" + getQ();
		}

	}

}