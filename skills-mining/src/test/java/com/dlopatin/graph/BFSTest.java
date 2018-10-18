package com.dlopatin.graph;

import org.junit.Test;

import com.dlopatin.graph.BFS;

public class BFSTest {

	@Test
	public void test() {
		BFS g = new BFS(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(0, 4);
		g.addEdge(4, 5);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.bfs(2);
	}
}
