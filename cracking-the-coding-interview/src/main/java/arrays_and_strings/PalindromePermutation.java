package arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 *
 * Example:
 * Input: Tact Coa
 * Output: True ( permutations: "taco cat", "atco cta", ... )
 */
public class PalindromePermutation {

    public boolean isPalindromePermutation(String input){
        Set<Character> unmatchedCharacters = new HashSet<>();
        for (Character c : input.toCharArray()) {
            if(!Character.isSpaceChar(c) && !unmatchedCharacters.add(c)){
                unmatchedCharacters.remove(c);
            }
        }

        return unmatchedCharacters.size() < 2;

    }
}
