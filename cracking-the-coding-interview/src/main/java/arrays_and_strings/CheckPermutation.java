package arrays_and_strings;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Given two strings, write a method to decide
 * if one is a permutation of the other
 */
public class CheckPermutation {

    public boolean isPermutation(String a, String b){
        if(a.length() != b.length()){
            return false;
        }

        int total = 0;

        for (int i = 0; i < a.length(); i++) {
            total += a.codePointAt(i);
            total -= b.codePointAt(i);
        }

        return total == 0;
    }
}
