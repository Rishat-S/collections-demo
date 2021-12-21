package ru.rishat;

public class LinkedListDemo<T> implements ListDemo<T> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Node previous;
        T element;
        Node next;

        public Node(Node previous, T element, Node next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    }

    public LinkedListDemo() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    @Override
    public void add(T t) {

        if (first == null) {
            Node node = new Node(null, t, null);
            first = last = node;
        } else {
            Node node = new Node(null, t, first);
            first.previous = node;
            first = node;
        }
        size++;
    }

    @Override
    public void add(int index, T t) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = getNodeOfIndex(index);

        Node nodeNext = node.next;

        Node newNode = new Node(node, t, nodeNext);

        node.next = newNode;
        nodeNext.previous = newNode;

        size++;

    }

    @Override
    public T get(int index) {

        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            return first.element;
        }

        Node node = getNodeOfIndex(index);
        if (node != null) {
            return node.element;
        }

        return null;
    }

    private Node getNodeOfIndex(int index) {

        Node currentNode = last;
        int currentIndex = 0;

        while (currentNode.previous != null) {
            if (currentIndex == index) {
                return currentNode;
            }
            currentNode = currentNode.previous;
            currentIndex++;
        }
        return null;
    }

    @Override
    public boolean remove(T t) {
        Node node = getNodeOfElement(t);

        if (node == null) {
            return false;
        }

        if (node.next == null) {
            last = node.previous;
            node.previous.next = null;
            size--;
            return true;
        }

        if (node.previous == null) {
            first = node.next;
            node.next.previous = null;
            size--;
            return true;
        }

        Node nodeNext = node.next;
        Node nodePrevious = node.previous;

        nodeNext.previous = nodePrevious;
        nodePrevious.next = nodeNext;
        size--;
        return true;
    }

    private Node getNodeOfElement(T t) {

        if (first.element.equals(t)) {
            return first;
        }

        Node currentNode = last;

        while (currentNode.previous != null) {
            if (currentNode.element.equals(t)) {
                return currentNode;
            }
            currentNode = currentNode.previous;
        }
        return null;
    }

    @Override
    public int indexOf(T t) {
        Node currentNode = last;
        int currentIndex = 0;

        while (currentNode.previous != null) {
            currentNode = currentNode.previous;
            currentIndex++;
            if (currentNode.element.equals(t)) {
                return currentIndex;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}