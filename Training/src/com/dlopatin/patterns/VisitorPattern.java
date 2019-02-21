package com.dlopatin.patterns;

import java.util.Arrays;
import java.util.List;

public class VisitorPattern {

    public static void main(String[] args) {
        List<Visitable> items = Arrays.asList(new Book(30), new Fruit(0.32, 30), new Book(42));
        ShoppingCard shoppingCard = new ShoppingCard();
        double total = items.stream().mapToDouble(value -> value.accept(shoppingCard)).sum();
        System.out.println(total);

    }

    private interface Visitable {

        double accept(Visitor visitor);
    }

    private static class Book implements Visitable {
        private final int price;

        Book(int price) {
            this.price = price;
        }

        @Override
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }

        int getPrice() {
            return price;
        }
    }

    private static class Fruit implements Visitable {
        private final double weight;
        private final double priceKg;

        Fruit(double weight, double priceKg) {
            this.weight = weight;
            this.priceKg = priceKg;
        }

        @Override
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }

        double getWeight() {
            return weight;
        }

        double getPriceKg() {
            return priceKg;
        }
    }

    private interface Visitor {

        int visit(Book book);

        double visit(Fruit fruit);
    }

    private static class ShoppingCard implements Visitor {

        @Override
        public int visit(Book book) {
            return book.getPrice();
        }

        @Override
        public double visit(Fruit fruit) {
            return fruit.getPriceKg() * fruit.getWeight();
        }
    }

}
