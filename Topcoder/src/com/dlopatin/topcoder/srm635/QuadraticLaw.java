package com.dlopatin.topcoder.srm635;

public class QuadraticLaw {

	public static void main(String[] args) {
		long d = 999999998999999999L;
		long time = new QuadraticLaw().getTime(d);
		System.out.println(time);
		System.out.println(time * (time + 1));
		System.out.println(time * (time + 1) > d);
	}

	public long getTime(long d) {
		long res = (long) ((-1 + Math.sqrt(1 + 4 * d)) / 2);
		while (res * (res + 1) > d) {
			res--;
		}
		return res;
	}

}
