package com.example.mypackage;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();
        languages.put("Java", "A compiled high level, object-oriented, platform independent language");
        languages.put("Python", "An interpreted, object-oriented, high level programming language with dynamic semantics");
        languages.put("Algol","An algorithm language");
        languages.put("BASIC","Beginners All Purpose Symbolic Instruction Code");
        System.out.println(languages.put("Lisp","Therein lies madness"));

        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java","This course is about Java");
        }
        System.out.println(languages.put("Java","This course is about Java"));
        System.out.println(languages.get("Java"));

        System.out.println("=====================");
//        languages.remove("Lisp");
        if(languages.remove("Algol","An algorithm language")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if(languages.replace("Lisp","Therein lies madness","a functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }
        System.out.println(languages.replace("Scala","this will not be added"));
        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}