package com.dlopatin.uva.datastructures.collection.p10264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=626&page=show_problem&problem=1205
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null && !line.isEmpty()) {
				int n = Integer.parseInt(line);
				int m = 1 << n;
				int[] weights = new int[m];
				for (int i = 0; i < m; i++) {
					weights[i] = Integer.parseInt(reader.readLine());
				}
				int[] sums = new int[m];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						sums[i] += weights[i ^ (1 << j)];
					}
				}
				int max = 0;
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						max = Math.max(max, sums[i] + sums[i ^ (1 << j)]);
					}
				}
				result.append(max).append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}

}
