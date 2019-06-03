package arrays_and_strings;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem: One Away
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit ( or zero edits) away.
 * Example:`
 * pale,    ple     -> true
 * pales,   pale    -> true
 * pale,    bale    -> true
 * pale,    bake    -> false
 */
public class OneAway {

    public boolean isOneAway(String a, String b) {

        String shorter = (a.length() <= b.length()) ? a : b;
        String longer = (a.length() <= b.length()) ? b : a;

        int diff = 0,
            sIndex = 0,
            lIndex = 0,
            lengthDiff = longer.length() - shorter.length();

        boolean isEqualLength = lengthDiff == 0;

        if (lengthDiff > 1) return false;

        while (sIndex < shorter.length()) {
            if (diff > 1) break;
            if(!isEqualLength && (lIndex == longer.length())) break;

            if (shorter.charAt(sIndex) != longer.charAt(lIndex)){
                diff++;
            }

            if (shorter.charAt(sIndex) == longer.charAt(lIndex) || isEqualLength) {
                sIndex++;
            }

            lIndex++;
        }

        return diff < 2;
    }

}
