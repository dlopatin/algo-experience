package com.dlopatin.uva.datastructures.collection.p10172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=629&page=show_problem&problem=1113
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = "";
			int caseIdx = 0;
			while (!(line = buffer.readLine()).equals("end")) {
				int[] stacks = new int[26];
				char[] input = line.toCharArray();
				for (char ch : input) {
					ch -= 'A';
					int idx = ch;
					boolean found = false;
					while (!found && idx < stacks.length) {
						if (stacks[idx] > 0) {
							found = true;
							stacks[idx] = 0;
						}
						idx++;
					}
					stacks[ch] = 1;
				}
				int count = 0;
				for (int stackUsed : stacks) {
					count += stackUsed;
				}
				result.append(String.format("Case %d: %d\n", ++caseIdx, count));
			}
			System.out.print(result.toString());
		}
	}
}
