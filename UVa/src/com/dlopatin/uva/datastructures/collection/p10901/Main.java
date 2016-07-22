package com.dlopatin.uva.datastructures.collection.p10901;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=627&page=show_problem&problem=3139
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int T = scanner.nextInt();
			while (T-- > 0) {
				int n = scanner.nextInt();
				int t = scanner.nextInt();
				int m = scanner.nextInt();
				Queue<Car> left = new LinkedList<>();
				Queue<Car> right = new LinkedList<>();
				List<Car> cars = new ArrayList<>();
				for (int i = 0; i < m; i++) {
					int time = scanner.nextInt();
					String direction = scanner.next();
					Car car = new Car(time);
					if (direction.equals("left")) {
						left.add(car);
					} else {
						right.add(car);
					}
					cars.add(car);
				}
				int time = 0;
				while (left.size() > 0 || right.size() > 0) {
					time = wait(left, right, time);
					int loaded = 0;
					while (left.size() > 0 && left.peek().getTime() <= time && loaded < n) {
						loaded++;
						Car car = left.poll();
						car.setResult(time + t);
					}
					time += t;

					time = wait(left, right, time);
					loaded = 0;
					if (left.size() > 0 || right.size() > 0) {
						while (right.size() > 0 && right.peek().getTime() <= time && loaded < n) {
							loaded++;
							Car car = right.poll();
							car.setResult(time + t);
						}
						time += t;
					}

				}
				result.append(cars.stream().map(car -> String.valueOf(car.getResult()))
						.collect(Collectors.joining("\n")));
				result.append("\n\n");
			}
			System.out.println(result.toString().trim());
		}
	}

	private int wait(Queue<Car> left, Queue<Car> right, int time) {
		int t = time;
		if ((left.size() > 0 && left.peek().getTime() > time) && (right.size() > 0 && right.peek().getTime() > time)) {
			t = Math.min(left.peek().getTime(), right.peek().getTime());
		} else if (left.size() == 0 && right.size() > 0 && right.peek().getTime() > time) {
			t = right.peek().getTime();
		} else if (right.size() == 0 && left.size() > 0 && left.peek().getTime() > time) {
			t = left.peek().getTime();
		}
		return t;
	}

	private static class Car {
		private final int time;
		private int result;

		public Car(int time) {
			this.time = time;
		}

		public int getResult() {
			return result;
		}

		public void setResult(int result) {
			this.result = result;
		}

		public int getTime() {
			return time;
		}

	}
}
