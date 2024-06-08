package _22.RegularExpressions.PatternMatches;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String sentence = "I like motorcycles.";

        //Pattern matching using Pattern static method
        boolean matched = Pattern.matches("[A-Z].*[.]", sentence);
        System.out.println(matched + ": " + sentence);
        //prints "true: I like motorcycles."

        Pattern firstPattern = Pattern.compile("[A-Z].*?[.]");
        var matcher = firstPattern.matcher(sentence);
        System.out.println(matcher.matches() + ": " + sentence);
        //prints "true: I like motorcycles."
        System.out.println(sentence.length()); //prints "19"
        System.out.println("Matched ending index: " + matcher.end());
        //prints "Matched ending index: 19"

        //Other Matcher methods
        String sentence2 = "I like B.M.W. motorcycles.";
        Pattern secondPattern = Pattern.compile("[A-Z].*?[.]"); //Matches pattern but stop at the earliest successful point
        var matcher2 = secondPattern.matcher(sentence2);
        System.out.println(sentence2.length()); //prints "26"
        matcher2.lookingAt();
        System.out.println("Matched ending index: " + matcher2.end()); //prints "9"
        System.out.println("Matched on : " +
                sentence2.substring(0, matcher2.end()));
        //prints "Matched on : I like B."

        System.out.println(matcher2.find() + " : " + matcher.end());
        //prints "true : 19"
        System.out.println("Matched on : " +
                sentence2.substring(matcher2.start(), matcher2.end()));
        //prints "Matched on : M."
        System.out.println("Matched on : " + matcher2.group());
        //prints "Matched on : M."

        //Resetting matcher
        matcher2.reset();

        matcher2.results().forEach(mr -> System.out.println(
                mr.group()));
        //prints "I like B.
        //M.
        //W."

    }
}
