package com.dlopatin.y2016.qualification;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			double V = scanner.nextInt();
			double T = scanner.nextDouble();
			int n = scanner.nextInt();
			double res = Double.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < n; i++) {
				int X = scanner.nextInt();
				double t = scanner.nextDouble();
				double time = (X / V + t + T) * V;
				if (time < res) {
					res = time;
					idx = i + 1;
				}
			}
			System.out.printf("%.5f %d", res, idx);
		}
	}

}