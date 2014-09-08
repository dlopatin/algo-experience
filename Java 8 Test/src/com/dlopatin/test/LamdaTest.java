package com.dlopatin.test;

import java.util.Arrays;
import java.util.List;

public class LamdaTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.forEach(value -> System.out.println(value));
	}

}
