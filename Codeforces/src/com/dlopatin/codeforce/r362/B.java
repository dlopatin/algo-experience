package com.dlopatin.codeforce.r362;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/697/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			String n = scanner.next();
			String real = n.substring(0, n.lastIndexOf('e'));
			int b = Integer.parseInt(n.substring(n.lastIndexOf('e') + 1));
			String a = real.substring(0, n.indexOf('.'));
			String d = real.substring(n.indexOf('.') + 1);
			int min = Math.min(b, d.length());
			if (Integer.parseInt(a) == 0 && d.length() == 1 && Integer.parseInt(d) == 0) {
				System.out.println(0);
				return;
			}
			StringBuilder res = new StringBuilder(a).append(d.substring(0, min));
			if (d.length() < b) {
				while (min != b) {
					res.append('0');
					min++;
				}
			} else if (d.length() > b) {
				res.append('.').append(d.substring(min));
			}
			while (res.charAt(0) == '0') {
				res.deleteCharAt(0);
			}
			if (res.charAt(0) == '.') {
				res.insert(0, '0');
			}
			if (res.indexOf(".") > 0) {
				while (res.charAt(res.length() - 1) == '0') {
					res.deleteCharAt(res.length() - 1);
				}
				if (res.charAt(res.length() - 1) == '.') {
					res.deleteCharAt(res.length() - 1);
				}
			}
			System.out.println(res);
		}
	}

}