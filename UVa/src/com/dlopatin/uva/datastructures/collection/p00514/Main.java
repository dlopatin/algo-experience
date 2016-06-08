package com.dlopatin.uva.datastructures.collection.p00514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=628&page=show_problem&problem=455
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = "";
			while (!(line = buffer.readLine()).equals("0")) {
				int n = Integer.parseInt(line);
				while (!(line = buffer.readLine()).equals("0")) {
					if (line.length() == 1) {
						result.append("Yes\n");
						continue;
					}
					StringTokenizer tokenizer = new StringTokenizer(line);
					int[] array = new int[n];
					for (int i = 0; i < n; i++) {
						array[i] = Integer.parseInt(tokenizer.nextToken());
					}
					Deque<Integer> stack = new ArrayDeque<>();
					Deque<Integer> res = new ArrayDeque<>();
					for (int i = array.length - 1; i >= 0; i--) {
						while (stack.size() > 0 && stack.peek() > array[i]) {
							res.push(stack.pop());
						}
						stack.push(array[i]);
					}
					while (stack.size() > 0) {
						res.push(stack.pop());
					}
					int value = 1;
					boolean sorted = true;
					for (Integer val : res) {
						sorted = val == value;
						if (!sorted) {
							break;
						}
						value++;
					}
					result.append(sorted ? "Yes" : "No").append("\n");
				}
				result.append("\n");
			}
			System.out.print(result.toString());
		}
	}
}
