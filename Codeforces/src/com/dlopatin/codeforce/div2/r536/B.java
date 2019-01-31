package com.dlopatin.codeforce.div2.r536;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1106/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nm = new StringTokenizer(reader.readLine());
            int n = parseInt(nm.nextToken());
            int m = parseInt(nm.nextToken());
            Dish[] dishes = new Dish[n];
            StringTokenizer aTokens = new StringTokenizer(reader.readLine());
            for (int i = 0; i < dishes.length; i++) {
                dishes[i] = new Dish(i, parseInt(aTokens.nextToken()));
            }
            StringTokenizer cTokens = new StringTokenizer(reader.readLine());
            PriorityQueue<Dish> queue = new PriorityQueue<>(n, Comparator.comparingLong(Dish::getCost));
            for (Dish dish : dishes) {
                dish.setCost(parseInt(cTokens.nextToken()));
                queue.add(dish);
            }

            StringBuilder result = new StringBuilder();
            while (m-- > 0) {
                long cost = 0;
                StringTokenizer query = new StringTokenizer(reader.readLine());
                int t = parseInt(query.nextToken()) - 1;
                int d = parseInt(query.nextToken());
                Dish orderedDish = dishes[t];
                if (orderedDish.amount >= d) {
                    cost += d * orderedDish.cost;
                    orderedDish.amount = orderedDish.amount - d;
                    d = 0;
                } else {
                    cost += orderedDish.cost * orderedDish.amount;
                    d = (int) Math.abs(orderedDish.amount - d);
                    orderedDish.amount = 0;
                    while (!queue.isEmpty() && d > 0) {
                        Dish cheapest = queue.peek();
                        if (cheapest.amount <= 0) {
                            queue.poll();
                            continue;
                        }
                        long l = cheapest.amount - d;
                        if (l >= 0) {
                            cost += d * cheapest.cost;
                            d = 0;
                            cheapest.amount = l;
                        } else {
                            cost += cheapest.cost * cheapest.amount;
                            d -= cheapest.amount;
                            cheapest.amount = 0;
                            queue.poll();
                        }
                    }
                }
                if (d > 0) {
                    result.append(0);
                } else {
                    result.append(cost);
                }
                result.append("\n");
            }
            System.out.print(result);
        }
    }

    private static class Dish {
        private final int id;
        private long amount;
        private long cost;

        public Dish(int id, int amount) {
            this.id = id;
            this.amount = amount;
        }

        public void setCost(long cost) {
            this.cost = cost;
        }

        public long getCost() {
            return cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Dish dish = (Dish) o;
            return id == dish.id &&
                    amount == dish.amount &&
                    cost == dish.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, amount, cost);
        }
    }


}