package com.ranella;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        new Thread(runnable).start();

        Function<String, String> lambdaFunction =  s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));
        System.out.println(everySecondCharacter(lambdaFunction,"1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        long countAs = topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println(countAs);

        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .sorted()
                .collect(Collectors.toList());
    }

    private static String everySecondCharacter(Function<String,String> lambda, String s) {
        return lambda.apply(s);
    }
}
