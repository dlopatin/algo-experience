package com.dlopatin.codeforce.r291;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/514/problem/B
 *
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int x0 = scanner.nextInt();
			int y0 = scanner.nextInt();
			Point gun = new Point(x0, y0);
			List<Point> points = new LinkedList<>();
			while (n-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				points.add(new Point(x, y));
			}
			int counter = 0;
			while (!points.isEmpty()) {
				Point a = points.get(0);
				points.remove(0);
				Iterator<Point> iterator = points.iterator();
				while (iterator.hasNext()) {
					Point next = iterator.next();
					if (isOnLine(gun, a, next)) {
						iterator.remove();
					}
				}
				counter++;
			}
			System.out.println(counter);

		}
	}

	private boolean isOnLine(Point gun, Point a, Point b) {
		return (b.x - gun.x) * (a.y - gun.y) - (b.y - gun.y) * (a.x - gun.x) == 0;
	}

	private class Point {
		private final int x;
		private final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
