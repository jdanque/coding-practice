package arrays_and_strings;

import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public boolean isUnique(String input) {
        if(Objects.isNull(input)) throw new NullPointerException("Input must not be null");

        //Could've used a Set<Character> but the problem explicitly stated
        //to not use an additional data structure,
        //but this works just like a Set without helper methods.
        //still subject to the set jvm character encoding

        int[] characterSet = new int[Charset.availableCharsets().size()];
        for (int i = 0; i < input.length(); i++) {
            int codePoint = input.codePointAt(i);
            if(characterSet[codePoint] == codePoint){
                return false;
            }

            characterSet[codePoint] = codePoint;
        }

        return true;
    }
}
