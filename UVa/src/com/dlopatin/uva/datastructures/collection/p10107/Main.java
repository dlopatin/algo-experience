package com.dlopatin.uva.datastructures.collection.p10107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=1048
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = null;
			List<Integer> list = new ArrayList<>();
			while ((line = reader.readLine()) != null && !line.isEmpty()) {
				list.add(Integer.parseInt(line.trim()));
				Collections.sort(list);
				int size = list.size();
				int mid = 0;
				int midIdx = size / 2;
				if (size % 2 == 0) {
					mid = (list.get(midIdx) + list.get(midIdx - 1)) / 2;
				} else {
					mid = list.get(midIdx);
				}
				result.append(mid).append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}

}
