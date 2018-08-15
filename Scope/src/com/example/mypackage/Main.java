package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        String var4 = "this is private to main()";
	    ScopeCheck scopeCheck = new ScopeCheck();
	    scopeCheck.useInner();
        System.out.println("scopeInstance var1 is " + scopeCheck.getVar1());
        System.out.println(var4);
        scopeCheck.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        innerClass.timesTwo();
    }
}
