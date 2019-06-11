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

    public static class SingleLinkedList<E>{

        Node<E> head;
        Node<E> tail;
        int size;

        public SingleLinkedList() {}

        public void add(E e){
            final Node<E> t = tail;
            final Node<E> newNode = new Node<>(e, null);
            tail = newNode;

            if(t == null){
                head = newNode;
            }else{
                t.next = newNode;
            }

            size++;
        }

        public void addAll(E... elements) {
            for(E e : elements){
                this.add(e);
            }
        }

        static class Node<E>{
            E data;
            Node<E> next;

            public Node(E elem, Node<E> next) {
                this.data = elem;
                this.next = next;
            }
        }

    }

}
