package linkedlists;

public class SingleLinkedList<E>  {

    Node<E> head;
    Node<E> tail;
    int size;

    public SingleLinkedList() {}

    static class Node<E>{
        E data;
        Node<E> next;

        public Node(E elem, Node<E> next) {
            this.data = elem;
            this.next = next;
        }

        public boolean hasNext(){
            return this.next != null;
        }
    }

    public void linkLast(E e) {
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

    /**
     * retrieves the node from the linkedlist
     * @param index
     * @return
     */
    public Node<E> node(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean addAll(E... elements) {
        for (E e : elements) {
            this.add(e);
        }

        return true;
    }

}
