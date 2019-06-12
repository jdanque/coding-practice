package linkedlists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteMiddleNodeTest {
    private DeleteMiddleNode underTest;
    private SingleLinkedList<Integer> actual = new SingleLinkedList<>();
    private final SingleLinkedList<Integer> expected = new SingleLinkedList<>();

    @Before
    public void setUp() {
        underTest = new DeleteMiddleNode();
    }

    @Test
    public void deleteNode_inMiddle() {
        actual.addAll(1,2,3,4,5, 6);
        expected.addAll(1,2,4,5,6);

        actual = underTest.deleteNode(actual,2);

        testActualVsExpected(actual, expected);
    }

    @Test
    public void deleteNode_inFirst() {
        actual.addAll(1,2,3,4,5,6);
        expected.addAll(2,3,4,5,6);

        actual = underTest.deleteNode(actual,0);

        testActualVsExpected(actual, expected);
    }

    @Test
    public void deleteNode_inLast() {
        actual.addAll(1,2,3,4,5,6);
        expected.addAll(1,2,3,4,5);

        actual = underTest.deleteNode(actual,5);

        testActualVsExpected(actual, expected);
    }

    public void testActualVsExpected(SingleLinkedList<Integer> actual, SingleLinkedList<Integer> expected) {
        SingleLinkedList.Node actualNode = actual.head,
                              expectedNode = expected.head;

        while (actualNode.hasNext()) {
            assertEquals(actualNode.data, expectedNode.data);

            actualNode = actualNode.next;
            expectedNode = expectedNode.next;
        }
    }
}