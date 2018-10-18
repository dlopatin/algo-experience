package com.dlopatin.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DFS {

	private final int size;
	private final List<Integer> graph[];

	public DFS(int size) {
		this.size = size;
		graph = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			graph[i] = new ArrayList<>();
		}
	}

	public void addEdge(int from, int to) {
		graph[from].add(to);
	}

	public void dfs(int startNode) {
		boolean visited[] = new boolean[size];
		Deque<Integer> stack = new LinkedList<>();

		visited[startNode] = true;
		stack.push(startNode);

		while (!stack.isEmpty()) {
			int node = stack.pop();
			System.out.println(node);
			for (int subNode : graph[node]) {
				if (!visited[subNode]) {
					stack.push(subNode);
					visited[subNode] = true;
				}
			}
		}
	}

}
