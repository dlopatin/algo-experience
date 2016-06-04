package com.dlopatin.uva.datastructures.collection.p11926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=626&page=show_problem&problem=3077
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = null;
			while (!"0 0".equals((line = reader.readLine()).trim())) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				int n = Integer.parseInt(tokenizer.nextToken());
				int m = Integer.parseInt(tokenizer.nextToken());
				List<Interval<Integer, Integer>> intervals = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					tokenizer = new StringTokenizer(reader.readLine());
					Interval<Integer, Integer> interval = new Interval<>(Integer.parseInt(tokenizer.nextToken()),
							Integer.parseInt(tokenizer.nextToken()));
					intervals.add(interval);
				}
				for (int i = 0; i < m; i++) {
					tokenizer = new StringTokenizer(reader.readLine());
					int start = Integer.parseInt(tokenizer.nextToken());
					int end = Integer.parseInt(tokenizer.nextToken());
					int period = Integer.parseInt(tokenizer.nextToken());
					for (int s = start, e = end; s <= 1_000_000 && e <= 1_000_000; s += period, e += period) {
						intervals.add(new Interval<Integer, Integer>(s, e));
					}
				}
				List<Interval<Integer, Integer>> sorted = intervals
						.stream()
						.sorted(Comparator.comparing(Interval<Integer, Integer>::getStart).thenComparing(
								Interval<Integer, Integer>::getEnd)).collect(Collectors.toList());
				boolean conflict = false;
				for (int i = 1; i < sorted.size() && !conflict; i++) {
					if (sorted.get(i).getStart() < sorted.get(i - 1).getEnd()) {
						conflict = true;
					}
				}
				result.append(conflict ? "CONFLICT" : "NO CONFLICT").append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}

	private static class Interval<T, S> {
		private final T start;
		private final S end;

		public Interval(T start, S end) {
			this.start = start;
			this.end = end;
		}

		public T getStart() {
			return start;
		}

		public S getEnd() {
			return end;
		}

	}

}
