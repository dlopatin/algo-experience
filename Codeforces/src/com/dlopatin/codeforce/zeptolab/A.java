package com.dlopatin.codeforce.zeptolab;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws IOException, ParseException {
		new A().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int candiesNumber = scanner.nextInt();
			int jumpHeight = scanner.nextInt();
			List<Candy> candies = new LinkedList<>();
			for (int candyIdx = 0; candyIdx < candiesNumber; candyIdx++) {
				int type = scanner.nextInt();
				int height = scanner.nextInt();
				int weight = scanner.nextInt();
				Candy candy = new Candy(type, height, weight);
				candies.add(candy);
			}

			Comparator<Candy> comparator = new Comparator<Candy>() {
				@Override
				public int compare(Candy c1, Candy c2) {
					return c2.getWeight() - c1.getWeight();
				}
			};
			Collections.sort(candies, comparator);
			List<Candy> candiesCopy = new LinkedList<>(candies);
			int max1 = findMax(candies, jumpHeight, 0);
			int max2 = findMax(candiesCopy, jumpHeight, 1);

			System.out.println(Math.max(max1, max2));
		}
	}

	private int findMax(List<Candy> candies, int jumnHeight, int startType) {
		int count = 0;
		int type = startType;
		boolean exit = false;
		while (!exit && candies.size() > 0) {
			for (int i = 0; i < candies.size(); i++) {
				Candy candy = candies.get(i);
				if (candy.getType() == type || jumnHeight < candy.getHeight()) {
					if (i == candies.size() - 1) {
						exit = true;
					}
					continue;
				}
				jumnHeight += candy.getWeight();
				count++;
				type = candy.getType();
				candies.remove(i);
				break;
			}
		}
		return count;
	}

	private class Candy {
		private final int type;
		private final int height;
		private final int weight;

		public Candy(int type, int height, int weight) {
			this.type = type;
			this.height = height;
			this.weight = weight;
		}

		public int getType() {
			return type;
		}

		public int getHeight() {
			return height;
		}

		public int getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return "Candy [getHeight()=" + getHeight() + ", getWeight()=" + getWeight() + "]";
		}

	}
}
