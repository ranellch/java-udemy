package com.ranella;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am";
        System.out.println(string);
        String yourString = string.replaceAll("I","You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF112GhhabcDeeeiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee","YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abc"));
        System.out.println(alphanumeric.matches("abcDeeeF112GhhabcDeeeiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("jkl99z$","THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]","X"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]","X")); //a or e or i followed by F or j

        System.out.println("harry".replaceAll("[Hh]arry","Harry"));
        System.out.println(alphanumeric.replaceAll("[^ej]","X"));
        System.out.println(alphanumeric.replaceAll("[a-f3-8]","X"));
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]","X")); //case insensitive
        System.out.println(alphanumeric.replaceAll("\\d","X")); //replace all digits
        System.out.println(alphanumeric.replaceAll("\\D","X")); //replace all non digits


        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s",""));
        System.out.println(hasWhitespace.replaceAll("\t",""));
        System.out.println(alphanumeric.replaceAll("\\w","X")); //replace all non word characters (a-z,0-9,_)
        System.out.println(hasWhitespace.replaceAll("\\b","X")); //replace word boundaries

        String alphanumeric2 = "abcDeeeF112Ghhiiiijkl99z";

        System.out.println(alphanumeric2.replaceAll("^abcDe{3}","YYY")); //quantifies number of preceding characters to match
        System.out.println(alphanumeric2.replaceAll("^abcDe+","YYY")); //one or more e's
        System.out.println(alphanumeric2.replaceAll("^abcDe*","YYY")); //zero or more e's
        System.out.println(alphanumeric2.replaceAll("^abcDe{2,5}","YYY")); //between 2 and 5 e's
        System.out.println(alphanumeric2.replaceAll("h+i*j","Y")); //one or more h followed by zero or more i's followed by j

        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        int count = 0;
        matcher.reset();
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)"; //lazy match all
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        System.out.println("----------");

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        System.out.println("---------");

        String tvTest = "tstvtkt";
        String tNotVRegExp = "t(?!v)"; //negative lookahead -- positive lookahead: t(?=v)
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        System.out.println("======== CHALLENGES =======");
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches("I want a \\w+."));
        System.out.println(challenge1.matches("I want a \\w+."));

        String regEx = "I want a \\w+.";
        Pattern regExPattern = Pattern.compile(regEx);
        Matcher matcher1 = regExPattern.matcher(challenge1);
        System.out.println(matcher1.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s","_"));

        String challenge5 = "aaabcccccccdddefffg";
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("^a{3}bc{7}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[a-z]+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        regEx = "([a-z]+)\\.(\\d+)";
        regExPattern = Pattern.compile(regEx);
        matcher = regExPattern.matcher(challenge8);

        count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.group(2));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        regEx = "([a-z]+)\\.(\\d+)\\s";
        regExPattern = Pattern.compile(regEx);
        matcher = regExPattern.matcher(challenge9);

        count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.group(2) + " Start: " + matcher.start(2) + " End: " + (matcher.end(2)-1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        regEx = "\\{(\\d+, \\d+)}";
        regExPattern = Pattern.compile(regEx);
        matcher = regExPattern.matcher(challenge11);

        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        String challenge14Regex = "^\\d{5}(-\\d{4})?$";
        System.out.println(challenge12.matches(challenge14Regex));
        System.out.println(challenge13.matches(challenge14Regex));
    }
}