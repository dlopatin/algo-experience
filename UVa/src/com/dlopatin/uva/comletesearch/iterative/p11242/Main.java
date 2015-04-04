package com.dlopatin.uva.comletesearch.iterative.p11242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2183
*/
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().doJob();
	}

	private void doJob() throws NumberFormatException, IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			String line;
			while ((line = in.readLine()) != null && !line.isEmpty() && !line.equals("0")) {
				StringTokenizer data = new StringTokenizer(line);
				int fSprockets = Integer.parseInt(data.nextToken());
				int rSprockets = Integer.parseInt(data.nextToken());
				double[] ratios = new double[fSprockets * rSprockets];
				int[] fTeeth = new int[fSprockets];
				data = new StringTokenizer(in.readLine());
				for (int i = 0; i < fSprockets; i++) {
					fTeeth[i] = Integer.parseInt(data.nextToken());
				}
				data = new StringTokenizer(in.readLine());
				int counter = 0;
				for (int i = 0; i < rSprockets; i++) {
					int rTeeth = Integer.parseInt(data.nextToken());
					for (int j = 0; j < fTeeth.length; j++) {
						ratios[counter++] = rTeeth / (double) fTeeth[j];
					}
				}
				Arrays.sort(ratios);
				double maxSpread = 0;
				for (int i = 1; i < ratios.length; i++) {
					maxSpread = Math.max(maxSpread, ratios[i] / ratios[i - 1]);
				}
				System.out.printf("%.2f\n", maxSpread);
			}
		}

	}

}
