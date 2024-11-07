import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.uninorte.ProfeImplementedList;

public class ProfeImplementedListTest {
    
    // create all test for the profeList class

    // test the add method
    @Test
    public void testAdd() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    // test the get method
    @Test
    public void testGet() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
    }

    // test the remove method
    @Test
    public void testRemove() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
    }

    // test the size method
    @Test
    public void testSize() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    // test the clear method
    @Test
    public void testClear() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    // test the isEmpty method
    @Test
    public void testIsEmpty() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        assertEquals(true, list.isEmpty());
    }

    // test the contains method
    @Test
    public void testContains() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.contains(2));
    }

    // test the indexOf method
    @Test
    public void testIndexOf() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
    }

    // test the lastIndexOf method
    @Test
    public void testLastIndexOf() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        assertEquals(3, list.lastIndexOf(2));
    }

    // test the toArray method

    // test the addAll method
    @Test
    public void testAddAll() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        ProfeImplementedList<Integer> list2 = new ProfeImplementedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        assertEquals(3, list.size());
    }


    // test the addAll method with index
    @Test
    public void testAddAllIndex() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        ProfeImplementedList<Integer> list2 = new ProfeImplementedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(0, list2);
        assertEquals(3, list.size());
    }

    // test the set method
    @Test
    public void testSet() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(1, 4);
        assertEquals(4, list.get(1));
    }

    // test the remove with index method
    @Test
    public void testRemoveIndex() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(2, list.size());
    }

    // test the remove with object method
    @Test
    public void testRemoveObject() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));
        assertEquals(2, list.size());
    }

    // test the removeAll method
    @Test
    public void testRemoveAll() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        ProfeImplementedList<Integer> list2 = new ProfeImplementedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeAll(list2);
        assertEquals(0, list.size());
    }

    // test the retainAll method
    @Test
    public void testRetainAll() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        ProfeImplementedList<Integer> list2 = new ProfeImplementedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.retainAll(list2);
        assertEquals(3, list.size());
    }

    // test the containsAll method
    @Test
    public void testContainsAll() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        ProfeImplementedList<Integer> list2 = new ProfeImplementedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(true, list.containsAll(list2));
    }

    // test the subList method
    @Test
    public void testSubList() {
        ProfeImplementedList<Integer> list = new ProfeImplementedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ProfeImplementedList<Integer> list2 = (ProfeImplementedList<Integer>) list.subList(0, 2);
        assertEquals(2, list2.size());
    }

    // test the iterator method
    // test the listIterator method
    // test the listIterator method with index



}
