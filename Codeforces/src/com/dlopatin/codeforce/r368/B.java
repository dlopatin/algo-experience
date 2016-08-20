package com.dlopatin.codeforce.r368;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/707/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			if (k == 0 || k == n) {
				System.out.println(-1);
				return;
			}
			@SuppressWarnings("unchecked")
			ArrayList<Vertex>[] graph = new ArrayList[n];
			for (int i = 0; i < m; i++) {
				int v1 = scanner.nextInt() - 1;
				int v2 = scanner.nextInt() - 1;
				int l = scanner.nextInt();
				putToArray(graph, v1, v2, l);
				putToArray(graph, v2, v1, l);
			}
			int min = Integer.MAX_VALUE;
			List<Integer> storages = new ArrayList<>(k);
			for (int i = 0; i < k; i++) {
				storages.add(scanner.nextInt() - 1);
			}
			Comparator<Vertex> comparator = Comparator.comparing(Vertex::getLength);
			for (int storage : storages) {
				ArrayList<Vertex> vertexes = graph[storage];
				if (vertexes != null) {
					Collections.sort(vertexes, comparator);
					for (int i = 0; i < vertexes.size(); i++) {
						Vertex vertex = vertexes.get(i);
						if (!storages.contains(vertex.getV())) {
							min = Math.min(min, vertex.getLength());
							break;
						}
					}
				}
			}
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		}
	}

	private void putToArray(ArrayList<Vertex>[] graph, int v1, int v2, int l) {
		ArrayList<Vertex> list = graph[v1];
		if (list == null) {
			list = new ArrayList<>();
			graph[v1] = list;
		}
		list.add(new Vertex(v2, l));
	}

	private static class Vertex {
		private final int v;
		private final int length;

		public Vertex(int v, int length) {
			this.v = v;
			this.length = length;
		}

		public int getV() {
			return v;
		}

		public int getLength() {
			return length;
		}

	}

}