package linkedlists;

/**
 * Chapter 9: Interview Questions
 * Topic: Linked Lists
 * Problem:
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class ReturnKthToLast {

    public <E> E getElementFromTail(SingleLinkedList<E> linkedList, int elemfromTailCount){
        int i = 0;
        SingleLinkedList.Node<E> curr = linkedList.head;
        while(i < linkedList.size - elemfromTailCount){
            curr = curr.next;
            i++;
        }
        return curr.data;
    }

}
