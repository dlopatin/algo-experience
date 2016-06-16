package com.dlopatin.uva.datastructures.nonlineards.p10226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=629&page=show_problem&problem=1975
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			int T = Integer.parseInt(reader.readLine());
			reader.readLine();
			while (T-- > 0) {
				Map<String, Integer> map = new TreeMap<>();
				String line = null;
				int counter = 0;
				while ((line = reader.readLine()) != null && !line.isEmpty()) {
					Integer count = map.get(line);
					count = count == null ? 1 : ++count;
					map.put(line, count);
					counter++;
				}
				final int number = counter;
				map.forEach((species, count) -> result.append(String
						.format("%s %.4f\n", species, count * 100d / number)));
				result.append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}
}
