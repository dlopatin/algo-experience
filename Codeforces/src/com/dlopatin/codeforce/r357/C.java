package com.dlopatin.codeforce.r357;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/681/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<Command> commands = new ArrayList<>(n);
			Queue<Integer> heap = new PriorityQueue<>(n);
			for (int i = 0; i < n; i++) {
				Command command = new Command(scanner.next());
				if (command.isNeedNumber()) {
					command.setNumber(scanner.nextInt());
				}
				if ("insert".equals(command.getCommand())) {
					heap.add(command.getNumber());
					commands.add(command);
				} else if ("getMin".equals(command.getCommand())) {
					while (heap.size() > 0 && heap.peek() < command.getNumber()) {
						heap.poll();
						commands.add(new Command("removeMin"));
					}
					if (heap.isEmpty() || heap.peek() > command.getNumber()) {
						heap.add(command.getNumber());
						commands.add(new Command("insert").setNumber(command.getNumber()));
					}
					commands.add(command);
				} else {
					if (heap.isEmpty()) {
						heap.add(command.getNumber());
						commands.add(new Command("insert").setNumber(command.getNumber()));
					}
					heap.poll();
					commands.add(command);
				}
			}

			System.out.println(commands.size());
			StringBuilder builder = new StringBuilder();
			commands.forEach(cmd -> builder.append(cmd).append("\n"));
			System.out.println(builder);
		}
	}

	private static class Command {
		private final String command;
		private int number;

		public Command(String command) {
			this.command = command;
		}

		public boolean isNeedNumber() {
			return !"removeMin".equals(command);
		}

		public int getNumber() {
			return number;
		}

		public Command setNumber(int number) {
			this.number = number;
			return this;
		}

		public String getCommand() {
			return command;
		}

		@Override
		public String toString() {
			if (isNeedNumber()) {
				return (command + " " + number);
			}
			return command;
		}

	}
}