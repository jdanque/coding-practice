package arrays_and_strings;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters ( a - z ).
 */

public class StringCompression {

    public String compress(String input){
        if(input.length() == 0) return input;

        Stack<AlphaNumber> stack = new Stack<>();
        stack.push(new AlphaNumber(input.charAt(0), 1));

        for (int i = 1; i < input.length(); i++) {
            AlphaNumber current = stack.pop();

            if (!current.isEqualChar(input.charAt(i))) {
                stack.push(current);
                stack.push(new AlphaNumber(input.charAt(i), 1));
            } else {
                current.incrementCount();
                stack.push(current);
            }
        }


        String compressed = stack.stream().map(AlphaNumber::toString).collect(Collectors.joining());

        return (compressed.length() >= input.length()) ? input : compressed;
    }

    static class AlphaNumber{
        private Character character;
        private Integer count;

        public AlphaNumber(Character character, Integer count) {
            this.character = character;
            this.count = count;
        }

        public void incrementCount(){
            this.count++;
        }

        public boolean isEqualChar(Character c){
            return c.equals(this.character);
        }

        @Override
        public String toString() {
            return this.character + this.count.toString();
        }
    }

}
