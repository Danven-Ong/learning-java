package _22.RegularExpressions;

public class Basics {
    public static void main(String[] args) {

        String testString = "Anyone can learn abc's, 123's, and any regular expression";
        String replacement = "(-)";

        //Creating basic regular expressions
        String[] patterns = {"abc", "123", "A"};

        for (String pattern : patterns) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " => " + output);
        }
        //prints
        //"Pattern: abc => Anyone can learn (-)'s, 123's, and any regular expression"
        //"Pattern: 123 => Anyone can learn abc's, (-)'s, and any regular expression"
        //"Pattern: A => (-)nyone can learn abc's, 123's, and any regular expression"

        //Using regular expressions with square brackets
        String[] patterns2 = {"[abc]", "[123]", "[A]"};

        //Code wil match on one of the characters in the pattern
        for (String pattern : patterns2) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " => " + output);
        }
        //prints
        //"Pattern: [abc] => Anyone (-)an learn abc's, 123's, and any regular expression"
        //"Pattern: [123] => Anyone can learn abc's, (-)23's, and any regular expression"
        //"Pattern: [A] => (-)nyone can learn abc's, 123's, and any regular expression"

        //Regular expressions using | (similar to or operator)
        String patternString = "ab|bc";
        String output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: ab|bc => Anyone can learn (-)c's, 123's, and any regular expression"

        //Other patterns
        String[] patterns3 = {"[a-z]", "[0-9]", "[A-Z]"}; //Pattern will match any character within the range
        for (String pattern : patterns3) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " => " + output);
        }
        //prints
        //"Pattern: [a-z] => A(-)yone can learn abc's, 123's, and any regular expression"
        //"Pattern: [0-9] => Anyone can learn abc's, (-)23's, and any regular expression"
        //"Pattern: [A-Z] => (-)nyone can learn abc's, 123's, and any regular expression"

        //Matching any alphabetical character
        patternString = "[a-zA-Z]";
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [a-zA-Z] => (-)nyone can learn abc's, 123's, and any regular expression"

        //Quantifiers
        //Using * quantifier
        patternString = "[a-zA-Z]*"; //Pattern will match any alphabetical char that appears zero or more times
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [a-zA-Z]* => (-) can learn abc's, 123's, and any regular expression"

        patternString = "[0-9]*"; //Pattern will match any integer that appears zero or more times
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [0-9]* => (-)Anyone can learn abc's, 123's, and any regular expression"

        //Using + quantifier
        patternString = "[0-9]+"; //Pattern will match any integer that appears one or more times
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [0-9]+ => Anyone can learn abc's, (-)'s, and any regular expression"

        //Using {n} quantifier
        patternString = "[0-9]{2}"; //Pattern must appear exactly 2(n) times
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [0-9]{2} => Anyone can learn abc's, (-)3's, and any regular expression"

        //Using {n,} quantifier
        patternString = "[0-9]{2,}"; //Pattern must appear 2(n) or more times
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [0-9]{2,} => Anyone can learn abc's, (-)'s, and any regular expression"

        //Using {n,m} quantifier
        patternString = "[0-9]{1,2}"; //Pattern must appear exactly 1(n) to 2(m) times
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [0-9]{2} => Anyone can learn abc's, (-)3's, and any regular expression"

        //Boundary Matchers
        //Using ^ boundary matcher
        patternString = "^[a-zA-Z]{3}"; //Pattern will start searching at the start of the string
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: ^[a-zA-Z]{3} => (-)one can learn abc's, 123's, and any regular expression"

        //Using $ boundary matcher
        patternString = "[a-zA-Z]*$"; //Pattern will start searching at the end of the string
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [a-zA-Z]*$ => Anyone can learn abc's, 123's, and any regular (-)"

        //Using \b boundary matcher
        patternString = "[aA]ny\\b"; //Pattern will match first word in the string
        output2 = testString.replaceFirst(patternString, replacement);
        System.out.println("Pattern: " + patternString + " => " + output2);
        //prints "Pattern: [aA]ny\b => Anyone can learn abc's, 123's, and (-) regular expression"
    }
}
