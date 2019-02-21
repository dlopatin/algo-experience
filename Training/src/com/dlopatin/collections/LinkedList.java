package com.dlopatin.collections;

public class LinkedList<T> {
    private Node<T> head = null;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        Node(E value) {
            this.value = value;
        }
    }

    public void addToStack(T value) {
        head = new Node<>(value, head);
    }

    public void addToQueue(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node<>(value);
        }
    }

    public void print() {
        for (Node<T> el = head; el != null; el = el.next) {
            System.out.println(el.value);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> ints = new LinkedList<>();
        ints.addToQueue(1);
        ints.addToQueue(2);
        ints.addToQueue(3);
        ints.addToStack(10);
        ints.addToStack(20);
        ints.addToStack(30);
        ints.print();
    }

}
