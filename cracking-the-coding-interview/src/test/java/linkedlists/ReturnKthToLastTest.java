package linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReturnKthToLastTest {
    private ReturnKthToLast underTest;

    @Before
    public void setUp() {
        underTest = new ReturnKthToLast();
    }

    @Test
    public void getElementFromTail_withIndex_souldReturnCorretElement() {
        ReturnKthToLast.SingleLinkedList<Integer> linkedList = new ReturnKthToLast.SingleLinkedList<>();
        linkedList.addAll(1,2,3,4,5);

        assertEquals(new Integer(4), underTest.getElementFromTail(linkedList,2));
        assertEquals(new Integer(2), underTest.getElementFromTail(linkedList,4));
        assertEquals(new Integer(1), underTest.getElementFromTail(linkedList,5));
        assertEquals(new Integer(5), underTest.getElementFromTail(linkedList,1));

    }
}