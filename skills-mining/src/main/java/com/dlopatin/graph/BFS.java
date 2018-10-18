package com.dlopatin.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	private final int size;
	private final List<Integer> graph[];

	public BFS(int size) {
		this.size = size;
		graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<>();
		}
	}

	public void addEdge(int from, int to) {
		graph[from].add(to);
	}

	public void bfs(int startNode) {
		boolean visited[] = new boolean[size];
		Queue<Integer> queue = new LinkedList<>();

		visited[startNode] = true;
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.println(node);
			for (int subNode : graph[node]) {
				if (!visited[subNode]) {
					queue.add(subNode);
					visited[subNode] = true;
				}
			}
		}
	}

}
