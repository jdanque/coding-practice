package linkedlists;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Chapter 9: Interview Questions
 * Topic: Linked Lists
 * Problem:
 * Write code to remove duplicates from an unsorted linked list.
 *
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {

    public <E> LinkedList<E> removeDuplicates(LinkedList<E> linkedList){
        HashSet<E> set = new HashSet<>();
        linkedList.removeIf(e -> !set.add(e));
        return linkedList;
    }

}
