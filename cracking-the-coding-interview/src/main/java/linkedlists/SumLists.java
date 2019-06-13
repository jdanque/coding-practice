package linkedlists;

import java.util.LinkedList; /**
 * Chapter 9: Interview Questions
 * Topic: Linked Lists
 * Problem:
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912
 *
 * FOLLOWUP
 * Suppose the digits are stored in forward order Repeat the above problem.
 *
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912
 */
public class SumLists {

    public LinkedList<Integer> add(LinkedList<Integer> a, LinkedList<Integer> b, boolean reversed) {
        LinkedList<Integer> result = new LinkedList<>();

        int carry = 0;
        int limit = Math.max(a.size(), b.size());

        for (int i = 0, j = limit - 1; i < limit || carry != 0; i++, j--) {
            int x = reversed ? i : j;

            int sum = getOrDefault(a,x) + getOrDefault(b,x);
            if(carry > 0){
                sum += carry;
                carry = 0;
            }

            if(sum > 9){
                carry = sum / 10;
                sum %= 10;
            }

            if(reversed){
                result.add(sum);
            }else {
                result.addFirst(sum);
            }

        }

        return result;
    }

    private int getOrDefault(LinkedList<Integer> list, int i){
        return i >= 0 && i < list.size() ? list.get(i) : 0;

    }
}
