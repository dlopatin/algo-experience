package com.dlopatin.test;

public class Increment {

	public static void main(String[] args) {
		int val = 4;
		simplePrint(val++);
		simplePrint(val);
		simplePrint(++val);
		simplePrint(val);

	}

	private static void simplePrint(int val) {
		System.out.println(val);
	}

}
