package com.dlopatin.uva.datastructures.collection.p10258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=625&page=show_problem&problem=1199
*/
public class Main {

	public static void main(String[] args) throws IOException {
		new Main().doJob();
	}

	private void doJob() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String line = null;
			int n = Integer.parseInt(reader.readLine().trim());
			reader.readLine();
			while (n-- > 0) {
				Map<Integer, Player> players = new HashMap<>();
				Map<Integer, PlayerStatistics> statistics = new HashMap<>();
				while ((line = reader.readLine()) != null && !line.isEmpty()) {
					StringTokenizer token = new StringTokenizer(line);
					int playerId = Integer.parseInt(token.nextToken());
					int problemId = Integer.parseInt(token.nextToken());
					int penalty = Integer.parseInt(token.nextToken());
					String status = token.nextToken();

					Player player = players.get(playerId);
					if (player == null) {
						player = new Player(playerId);
						players.put(playerId, player);
					}
					Problem problem = player.getProblem(problemId);
					boolean solved = problem.solution(penalty, status);

					PlayerStatistics playerStatistics = statistics.get(playerId);
					if (playerStatistics == null) {
						playerStatistics = new PlayerStatistics(playerId);
						statistics.put(playerId, playerStatistics);
					}
					if (solved) {
						playerStatistics.addSolved().addPenalty(problem.getPenalty());
					}
				}

				Comparator<PlayerStatistics> comparator = Comparator
						.comparing(PlayerStatistics::getSolved, Comparator.reverseOrder())
						.thenComparing(PlayerStatistics::getPenalty).thenComparing(PlayerStatistics::getId);

				statistics
						.values()
						.stream()
						.sorted(comparator)
						.forEach(
								stat -> result.append(String.format("%d %d %d\n", stat.getId(), stat.getSolved(),
										stat.getPenalty())));
				result.append("\n");

			}
			System.out.println(result.toString().trim());
		}
	}

	private static class Player {
		private final int id;
		private final Map<Integer, Problem> problems;

		public Player(int id) {
			this.id = id;
			problems = new HashMap<>();
		}

		public Problem getProblem(int id) {
			Problem problem = problems.get(id);
			if (problem == null) {
				problem = new Problem(id);
				problems.put(id, problem);
			}
			return problem;
		}

	}

	private static class Problem {
		private final int id;
		private int penalty = 0;
		private boolean solved;

		public Problem(int id) {
			this.id = id;
		}

		private void addPenalty(int amount) {
			penalty += amount;
		}

		public boolean solution(int penalty, String status) {
			if (!solved) {
				if ("I".equals(status)) {
					addPenalty(20);
				} else if ("C".equals(status)) {
					addPenalty(penalty);
					solved = true;
					return true;
				}
			}
			return false;
		}

		public int getPenalty() {
			return penalty;
		}

		public boolean isSolved() {
			return solved;
		}

	}

	private static class PlayerStatistics {
		private final int id;
		private int solved = 0;
		private int penalty = 0;

		public PlayerStatistics(int id) {
			this.id = id;
		}

		public PlayerStatistics addSolved() {
			solved++;
			return this;
		}

		public void addPenalty(int value) {
			penalty += value;
		}

		public int getId() {
			return id;
		}

		public int getSolved() {
			return solved;
		}

		public int getPenalty() {
			return penalty;
		}

	}

}
