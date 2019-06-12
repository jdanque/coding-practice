package linkedlists;

/**
 * Chapter 9: Interview Questions
 * Topic: Linked Lists
 * Problem:
 * Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact middle)
 * of a singly linked list, given only access to that node.
 *
 * EXAMPLE
 * Input: the node c from the linked list a -> b -> c -> d -> e -> f
 * Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
 */
public class DeleteMiddleNode {

    //had to return for tests
    public <E> SingleLinkedList<E> deleteNode(SingleLinkedList<E> list, int indexToDelete){
        int i = 0;
        SingleLinkedList.Node<E> prev = null,
                                 node = list.head;

        while (node.next != null) {
            if(i == indexToDelete){
                SingleLinkedList.Node<E> nextNode = node.next;
                node.next = null;
                if(prev != null){
                    prev.next = nextNode;
                }
                return list;
            }
            prev = node;
            node = node.next;
            i++;
        }

        return list;
    }
}
