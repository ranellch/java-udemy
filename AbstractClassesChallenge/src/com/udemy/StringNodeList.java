package com.udemy;

public class StringNodeList {
    StringNode head;

    public StringNodeList() {
        this.head = null;
    }

    public boolean add(StringNode node) {
        if (this.head == null) {
            this.head = node;
            return true;
        }
        StringNode thisNode = this.head;
        int comparison = node.compareTo(thisNode);
        if (comparison == 0) {
            return false;
        } else if (comparison < 0) {
            thisNode.setPrevious(node);
            node.setNext(thisNode);
            this.head = node;
            return true;
        }
        while (thisNode.getNext() != null) {
            thisNode = (StringNode) thisNode.getNext();
            comparison = node.compareTo(thisNode);
            if (comparison == 0) {
                return false;
            } else if (comparison < 0) {
                Node prevNode = thisNode.getPrevious();
                prevNode.setNext(node);
                node.setPrevious(prevNode);
                node.setNext(thisNode);
                thisNode.setPrevious(node);
                return true;
            }
        }
        node.setPrevious(thisNode);
        thisNode.setNext(node);
        return true;
    }

    public boolean remove(StringNode node) {
        StringNode thisNode = this.head;
        while (thisNode != null) {
            int comparison = node.compareTo(thisNode);
            if (comparison == 0) {
                if (thisNode == this.head) {
                    this.head = (StringNode) thisNode.getNext();
                } else {
                    Node prevNode = thisNode.getPrevious();
                    Node nextNode = thisNode.getNext();
                    prevNode.setNext(nextNode);
                    if (nextNode != null) {
                        nextNode.setPrevious(prevNode);
                    }
                }
                return true;
            } else if (comparison > 0) {
                thisNode = (StringNode) thisNode.getNext();
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        Node thisNode = this.head;
        String outputString = "";
        while(thisNode != null) {
            outputString += thisNode.getValue() + " ";
            thisNode = thisNode.getNext();
        }
        return outputString;
    }
}
