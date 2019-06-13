package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class SumListsTest {
    private SumLists underTest;
    private LinkedList<Integer> addend1 = new LinkedList<>();
    private LinkedList<Integer> addend2 = new LinkedList<>();
    private LinkedList<Integer> expected = new LinkedList<>();

    @Before
    public void setUp() {
        underTest = new SumLists();
    }

    @Test
    public void addReverse_withValidNumbers_shouldReturnSum() {
        Collections.addAll(addend1,7,1,6);
        Collections.addAll(addend2,5,9,2);
        Collections.addAll(expected,2,1,9);

        testActualVsExpected(underTest.add(addend1, addend2, true), expected);

        addend1.clear();
        addend2.clear();
        expected.clear();
        Collections.addAll(addend1,1);
        Collections.addAll(addend2,9);
        Collections.addAll(expected,0,1);
        testActualVsExpected(underTest.add(addend1, addend2, true), expected);

        addend1.clear();
        addend2.clear();
        expected.clear();
        Collections.addAll(addend1,1);
        Collections.addAll(addend2,999);
        Collections.addAll(expected,0,0,0,1);
        testActualVsExpected(underTest.add(addend1, addend2, true), expected);
    }

    @Test
    public void add_withValidNumbers_shouldReturnSum() {
        Collections.addAll(addend1,6,1,7);
        Collections.addAll(addend2,2,9,5);
        Collections.addAll(expected,9,1,2);

        testActualVsExpected(underTest.add(addend1, addend2, false), expected);

        addend1.clear();
        addend2.clear();
        expected.clear();
        Collections.addAll(addend1,1);
        Collections.addAll(addend2,9);
        Collections.addAll(expected,1,0);
        testActualVsExpected(underTest.add(addend1, addend2, false), expected);

        addend1.clear();
        addend2.clear();
        expected.clear();
        Collections.addAll(addend1,1);
        Collections.addAll(addend2,999);
        Collections.addAll(expected,1,0,0,0);
        testActualVsExpected(underTest.add(addend1, addend2, false), expected);
    }

    public void testActualVsExpected(LinkedList<Integer> actual, LinkedList<Integer> expected) {
        Iterator<Integer> a = actual.iterator();
        Iterator<Integer> b = expected.iterator();

        while(a.hasNext()){
            assertEquals(b.next(), a.next());
        }
    }

}