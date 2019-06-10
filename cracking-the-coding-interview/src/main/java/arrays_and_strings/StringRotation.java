package arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 */
public class StringRotation {

    public boolean isSubstring(String s1, String s2){
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            s1 = s1.substring(1) + s1.charAt(0);
            if(s1.equals(s2)){
                return true;
            }

        }
        return false;
    }
}
