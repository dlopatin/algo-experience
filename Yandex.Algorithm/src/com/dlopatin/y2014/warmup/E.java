package com.dlopatin.y2014.warmup;

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

public class E {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			}
			result = Collections.max(resMap.values());

		} catch (IOException e) {
			e.printStackTrace();
		}
		try (PrintWriter writer = new PrintWriter(FILE_OUT, "UTF-8")) {
			writer.println(result);
		}
	}

}
