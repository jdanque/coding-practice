package arrays_and_strings;

/**
 * Chapter 9: Interview Questions
 * Topic: Arrays and Strings
 * Problem:
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end
 * to hold the additional characters, and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * Example:
 * Input: "Mr John Smith", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {

    public char[] toUrl(char[] input, int trueLength){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < trueLength; i++) {
            if(Character.isSpaceChar(input[i])){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(input[i]);
            }
        }

        return stringBuilder.toString().toCharArray();
    };

}
