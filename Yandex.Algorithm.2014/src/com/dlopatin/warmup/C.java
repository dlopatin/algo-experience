package com.dlopatin.warmup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class C {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) throws ParseException, FileNotFoundException, UnsupportedEncodingException {
		new C().doJob();
	}

	private void doJob() throws ParseException, FileNotFoundException, UnsupportedEncodingException {
		int result = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_IN))) {
			String line;
			line = br.readLine();
			int n = numberFormat.parse(line).intValue();
			Map<Double, Integer> resMap = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String[] splitted = br.readLine().trim().split("\\s+");
				int a = numberFormat.parse(splitted[0]).intValue();
				int b = numberFormat.parse(splitted[1]).intValue();
				int c = numberFormat.parse(splitted[2]).intValue();
				double r = calcInnerRadius(a, b, c);
				Integer count = resMap.get(r);
				if (count == null) {
					resMap.put(r, 1);
				} else {
					resMap.put(r, count + 1);
				}
			}
			result = Collections.max(resMap.values());

		} catch (IOException e) {
			e.printStackTrace();
		}
		try (PrintWriter writer = new PrintWriter(FILE_OUT, "UTF-8")) {
			writer.println(result);
		}
	}

	private double calcInnerRadius(int a, int b, int c) {
		double p = (a + b + c) / 2.0;
		return Math.sqrt((p - a) * (p - b) * (p - c) / p);
	}

}
