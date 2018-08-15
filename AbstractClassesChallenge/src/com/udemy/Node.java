package com.udemy;

public abstract class Node {
    private Object value;
    private Node next;
    private Node previous;

    public Node(Object value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public abstract int compareTo(Node node);

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }
}
