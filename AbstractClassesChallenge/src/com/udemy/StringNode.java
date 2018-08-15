package com.udemy;

public class StringNode extends Node {
    public StringNode(String value) {
        super(value);
    }

    @Override
    public int compareTo(Node node) {
        String checkString = (String) node.getValue();
        String thisString = (String) getValue();
        return thisString.compareTo(checkString);
    }
}
