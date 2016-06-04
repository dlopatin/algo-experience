package com.dlopatin.uva.datastructures.collection.p11988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=627&page=show_problem&problem=3139
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
				Deque<String> input = new LinkedList<>();
				char[] chars = line.toCharArray();
				int start = 0;
				char action = ' ';
				for (int i = 0; i < chars.length; i++) {
					char symbol = chars[i];
					if (symbol == '[' || symbol == ']' || i == chars.length - 1) {
						if (i - start >= 0) {
							int end = symbol == '[' || symbol == ']' ? i : i == chars.length - 1 ? i + 1 : i;
							if (action == '[') {
								input.addFirst(new String(Arrays.copyOfRange(chars, start, end)));
							} else {
								input.addLast(new String(Arrays.copyOfRange(chars, start, end)));
							}
						}
						start = i + 1;
						action = symbol;
					}
				}
				result.append(String.join("", input)).append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}
}
