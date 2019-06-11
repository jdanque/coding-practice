package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class RemoveDupsTest {
    private RemoveDups underTest;

    @Before
    public void setUp() {
        underTest = new RemoveDups();
    }

    @Test
    public void removeDuplicates_withDups_shouldReturnRemovedDups() {
        LinkedList<Integer> actual = new LinkedList<>();
        Collections.addAll(actual, 1,1,2,2,3,3,4,4,5,5);
        actual = underTest.removeDuplicates(actual);

        LinkedList<Integer> expected = new LinkedList<>();
        Collections.addAll(expected, 1,2,3,4,5);


        Iterator<Integer> a = actual.iterator();
        Iterator<Integer> b = expected.iterator();

        while(a.hasNext()){
            assertEquals(b.next(), a.next());
        }

    }
}