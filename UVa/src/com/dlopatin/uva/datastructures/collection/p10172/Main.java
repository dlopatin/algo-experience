package com.dlopatin.uva.datastructures.collection.p10172;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=629&page=show_problem&problem=1113
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = scanner.nextInt();
			while (n-- > 0) {
				int N = scanner.nextInt();
				int S = scanner.nextInt();
				int Q = scanner.nextInt();
				List<Queue<Integer>> stations = new ArrayList<>();
				for (int i = 0; i < N; i++) {
					int cargosInQueue = scanner.nextInt();
					Queue<Integer> station = new LinkedList<>();
					for (int j = 0; j < cargosInQueue; j++) {
						station.add(scanner.nextInt() - 1);
					}
					stations.add(station);
				}

				Deque<Integer> carrier = new ArrayDeque<>(S);
				int emptyStations = 0;
				int index = 0;
				int time = -2;
				while (!carrier.isEmpty() || emptyStations < N) {
					time += 2; // moving time
					index %= N;
					Queue<Integer> station = stations.get(index);
					// unload
					while (carrier.size() > 0 && Q != station.size()) {
						time++;
						Integer cargo = carrier.pop();
						if (cargo != index) {
							station.add(cargo);
						}
					}
					while (carrier.size() > 0 && carrier.peekFirst() == index) {
						carrier.pop();
						time++;
					}

					// load
					while (carrier.size() != S && station.size() > 0) {
						carrier.addFirst(station.remove());
						time++;
					}

					int[] counter = new int[1];
					stations.forEach(s -> counter[0] += s.isEmpty() ? 1 : 0);
					emptyStations = counter[0];

					index++;
				}
				result.append(time >= 0 ? time : 0).append("\n");
			}
			System.out.print(result.toString());
		}
	}
}
