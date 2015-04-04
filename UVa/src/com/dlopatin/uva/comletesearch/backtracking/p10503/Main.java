package com.dlopatin.uva.comletesearch.backtracking.p10503;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=17&page=show_problem&problem=1444
*/
public class Main {

	private int usedPos;

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = 0;
			while ((n = scanner.nextInt()) != 0) {
				int m = scanner.nextInt();
				Domino[] resDominoes = new Domino[n + 2];
				Domino first = new Domino(scanner.nextInt(), scanner.nextInt());
				Domino last = new Domino(scanner.nextInt(), scanner.nextInt());
				resDominoes[0] = first;
				resDominoes[n + 1] = last;
				Domino[] dominoes = new Domino[m];
				for (int i = 0; i < m; i++) {
					dominoes[i] = new Domino(scanner.nextInt(), scanner.nextInt());
				}
				usedPos = 0;
				String yesno = backtrack(0, resDominoes, dominoes) ? "YES" : "NO";
				result.append(yesno).append(System.lineSeparator());
			}
			System.out.println(result.toString().trim());
		}

	}

	private boolean backtrack(int prevPos, Domino[] result, Domino[] dominoes) {
		for (int pos = 0; pos < dominoes.length; pos++) {
			if (place(result[prevPos], dominoes[pos], pos)) {
				usedPos |= 1 << pos;
				if (result[prevPos].isRotationNeeded(dominoes[pos])) {
					dominoes[pos].rotate();
				}
				result[prevPos + 1] = dominoes[pos];
				if (prevPos + 1 == result.length - 2) {
					if (!result[prevPos + 1].isRotationNeeded(result[prevPos + 2])) {
						return true;
					}
				} else if (backtrack(prevPos + 1, result, dominoes)) {
					return true;
				}
				usedPos &= ~(1 << pos);
			}
		}
		return false;
	}

	private boolean place(Domino a, Domino b, int pos) {
		return a.canPlace(b) && (usedPos & (1 << pos)) == 0;
	}

	private class Domino {
		private int a = 0;
		private int b = 0;

		public Domino(int a, int b) {
			this.a = a;
			this.b = b;
		}

		private boolean canPlace(Domino next) {
			return (this.b == next.a || this.b == next.b);
		}

		private boolean isRotationNeeded(Domino next) {
			return !(this.b == next.a);
		}

		private void rotate() {
			int temp = a;
			a = b;
			b = temp;
		}

		@Override
		public String toString() {
			return "Domino [a=" + a + ", b=" + b + "]";
		}

	}

}
