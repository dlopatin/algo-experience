package com.dlopatin.uva.datastructures.c2_4ownlibraries.quadtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class P00297 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();
            while (n-- > 0) {
                RangeQuadtree rangeQuadtree1 = new RangeQuadtree(reader.readLine());
                RangeQuadtree rangeQuadtree2 = new RangeQuadtree(reader.readLine());
                int sum = calc(rangeQuadtree1.node, rangeQuadtree2.node);
                result.append("There are ").append(sum).append(" black pixels.\n");
            }
            System.out.print(result);
        }
    }

    private static int calc(RangeQuadtree.Node node1, RangeQuadtree.Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2 ? 0 : Optional.ofNullable(node1).orElse(node2).blackPixels;
        }

        if (node1.isBlack() || node2.isBlack()) {
            return node1.getCells();
        }
        if (node1.isWhite() || node2.isWhite()) {
            return node1.isWhite() ? node2.blackPixels : node1.blackPixels;
        }
        int count = 0;
        for (int i = 0; i < RangeQuadtree.Node.SIZE; i++) {
            count += calc(node1.getChildren()[i], node2.getChildren()[i]);
        }
        return count;
    }


    private static class RangeQuadtree {

        private static class Node {
            public static final int SIZE = 4;
            private final char data;
            private final int cells;
            private int blackPixels = 0;
            private Node[] children;

            public Node(Node other) {
                data = other.getData();
                children = other.getChildren();
                cells = other.getCells();
            }

            public Node(char data, int cells) {
                this.data = data;
                this.cells = cells;
                if (data == 'p') {
                    children = new Node[SIZE];
                }
                if (data == 'f') {
                    blackPixels += cells;
                }
            }

            public static Node newBlack(int cells) {
                return new Node('f', cells);
            }

            public static Node newWhite(int cells) {
                return new Node('e', cells);
            }

            public boolean hasChildren() {
                return children != null;
            }

            public Node[] getChildren() {
                return children;
            }

            public char getData() {
                return data;
            }

            public int getCells() {
                return cells;
            }

            public boolean isBlack() {
                return data == 'f';
            }

            public boolean isWhite() {
                return data == 'e';
            }

            @Override
            public String toString() {
                return String.valueOf(data);
            }
        }


        private final Node node;

        public RangeQuadtree(String line) {
            Deque<Character> queue = new LinkedList<>();
            line.chars().forEach(e -> queue.add((char) e));
            int cells = 1024;
            node = new Node(queue.pop(), cells);
            insert(node, queue, cells / Node.SIZE);
        }

        public RangeQuadtree(Node node) {
            this.node = node;
        }

        public void insert(Node node, Deque<Character> queue, int cells) {
            for (int i = 0; i < Node.SIZE; i++) {
                Character action = queue.poll();
                if (action == null) {
                    return;
                }
                if (action == 'p') {
                    Node nextNode = node.getChildren()[i] = new Node(action, cells);
                    insert(nextNode, queue, cells / Node.SIZE);
                } else {
                    node.getChildren()[i] = new Node(action, cells);
                }
                node.blackPixels += node.getChildren()[i].blackPixels;
            }
        }

        /**
         * Creates new merged quadtree
         */
        public RangeQuadtree merge(RangeQuadtree other) {

            return null;
        }

        private Node mergeNode(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return Optional.ofNullable(node1).orElse(node2);
            }

            if (node1.isBlack() || node2.isBlack()) {
                return Node.newBlack(node1.getCells());
            }
            if (node1.isWhite() || node2.isWhite()) {
                return node1.isWhite() ? new Node(node2) : new Node(node1);
            }
            // stub
            return null;
        }
    }

}
