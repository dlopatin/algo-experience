package com.dlopatin.russiancodecup2015.round1;

import java.math.BigInteger;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				String x = scanner.next();
				String y = scanner.next();
				String z = scanner.next();
				BigInteger bigX = new BigInteger(x);
				BigInteger bigY = new BigInteger(y);
				BigInteger bigZ = new BigInteger(z);
				String res = "Finite";
				if (bigX.multiply(bigY).compareTo(bigZ) == 0) {
					res = "Infinity";
				}
				System.out.println(res);
			}
		}
	}

}