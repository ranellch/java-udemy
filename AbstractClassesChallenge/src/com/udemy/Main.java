package com.udemy;

public class Main {

    public static void main(String[] args) {
        StringNodeList mylist = new StringNodeList();
	    String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

	    String[] data = stringData.split(" ");
	    for(String s : data) {
            System.out.println(mylist.add(new StringNode(s)));
        }

        System.out.println(mylist);

	    mylist.remove(new StringNode("Canberra"));
        System.out.println(mylist);
        mylist.remove(new StringNode("Adelaide"));
        System.out.println(mylist);
        mylist.remove(new StringNode("Sydney"));
        System.out.println(mylist);
    }
}
