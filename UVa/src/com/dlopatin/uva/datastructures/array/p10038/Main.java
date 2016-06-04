package com.dlopatin.uva.datastructures.array.p10038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=979
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null && !line.isEmpty()) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				int n = Integer.parseInt(tokenizer.nextToken());
				int prev = Integer.parseInt(tokenizer.nextToken());
				int[] subs = new int[n - 1];
				for (int i = 1; i < n; i++) {
					int input = Integer.parseInt(tokenizer.nextToken());
					int val = Math.abs(input - prev) - 1;
					prev = input;
					if (val >= 0 && val < n - 1) {
						subs[val] = 1;
					}
				}
				result.append(isJolly(subs) ? "Jolly" : "Not jolly");
				result.append(System.lineSeparator());
			}
			System.out.println(result.toString().trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	private boolean isJolly(int[] subs) {
		for (int i = 0; i < subs.length; i++) {
			if (subs[i] == 0) {
				return false;
			}
		}
		return true;
	}

}
