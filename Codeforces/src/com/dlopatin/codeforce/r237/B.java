package com.dlopatin.codeforce.r237;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * http://codeforces.com/contest/404/problem/C
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			// Data[] d = new Data[n];
			int zeroCount = 0;
			Map<Integer, List<Integer>> graph = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				int path = scanner.nextInt();
				int node = i + 1;
				zeroCount = path == 0 ? zeroCount + 1 : zeroCount;
				List<Integer> subNodes = graph.get(path);
				if (subNodes == null) {
					subNodes = new ArrayList<>();
					subNodes.add(node);
					graph.put(path, subNodes);
				} else {
					subNodes.add(node);
				}
			}
			if (zeroCount != 1) {
				System.out.println(-1);
				return;
			}
			int edgesCounter = 0;
			int[] degrees = new int[n + 1];
			StringBuilder res = new StringBuilder();
			for (int i = 1; i < graph.keySet().size(); i++) {
				int path = i;
				List<Integer> prevNodes = graph.get(path - 1);
				List<Integer> subNodes = graph.get(path);
				if (prevNodes == null || subNodes == null) {
					System.out.println(-1);
					return;
				}
				edgesCounter += subNodes.size();
				boolean full = false;
				int j = 0;
				int z = 0;
				while (j < prevNodes.size() && z < subNodes.size()) {
					int firstVertex = prevNodes.get(j);
					int secondvertex = subNodes.get(z);

					if (degrees[firstVertex] >= k) {
						full = true;
						j++;
						continue;
					}
					if (degrees[secondvertex] >= k) {
						System.out.println(-1);
						return;
					}
					full = false;
					degrees[firstVertex]++;
					degrees[secondvertex]++;
					res.append(firstVertex).append(" ").append(secondvertex).append(System.lineSeparator());
					z++;
				}
				if (full) {
					System.out.println(-1);
					return;
				}
			}
			System.out.println(edgesCounter);
			System.out.println(res.toString());
		}
	}

}