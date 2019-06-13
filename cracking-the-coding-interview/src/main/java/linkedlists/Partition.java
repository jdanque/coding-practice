package linkedlists;

/**
 * Chapter 9: Interview Questions
 * Topic: Linked Lists
 * Problem:
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x(see below).
 * The partition element x can appear anywhere in the "right partition";
 * It does not need to appear between the left and right partitions
 *
 * EXAMPLE
 * Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

/**
 * Note: I'll be honest I didn't get the problem,
 * so I didn't even write the tests to verify this :(
 */
public class Partition {

    public <E> SingleLinkedList.Node<E> partition(SingleLinkedList.Node<E> node, int x){
        SingleLinkedList.Node<E> head = node;
        SingleLinkedList.Node<E> tail = node;
        while(node != null){
            SingleLinkedList.Node<E> next = node.next;
            if((int) node.data < x){
                node.next = head;
                head = node;
            }else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

}
