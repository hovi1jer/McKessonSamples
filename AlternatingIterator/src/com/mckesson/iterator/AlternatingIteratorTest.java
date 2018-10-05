package com.mckesson.iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class AlternatingIteratorTest {
	
	@Test
	public void testAllNullIterators() {
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(null, null, null);
		
		assertEquals(false, testIter.hasNext());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}
	
	@Test
	public void testSomeNullIterators() {
		
		List<String> list1 = Arrays.asList("a","b", "c");
		List<String> list2 = Arrays.asList("1", "2");
		List<String> list3 = Arrays.asList("x", "y", "z");
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(null, list1.iterator(), null, list2.iterator(), null, list3.iterator());
		
		assertEquals(true, testIter.hasNext());
		assertEquals("a", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("1", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("x", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("b", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("2", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("y", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("c", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("z", testIter.next());
		assertEquals(false, testIter.hasNext());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}
	
	@Test
	public void testAllEmptyIterators() {
		
		List<String> list1 = Arrays.asList();
		List<String> list2 = Arrays.asList();
		List<String> list3 = Arrays.asList();
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(list1.iterator(), list2.iterator(), list3.iterator());
		
		assertEquals(false, testIter.hasNext());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}
	
	@Test
	public void testSomeEmptyIterators() {
		
		List<String> list1 = Arrays.asList("a","b", "c");
		List<String> list2 = Arrays.asList("1", "2");
		List<String> list3 = Arrays.asList("x", "y", "z");
		List<String> emptyList = Arrays.asList();
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(emptyList.iterator(), list1.iterator(), emptyList.iterator(), list2.iterator(), emptyList.iterator(), list3.iterator());
		
		assertEquals(true, testIter.hasNext());
		assertEquals("a", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("1", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("x", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("b", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("2", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("y", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("c", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("z", testIter.next());
		assertEquals(false, testIter.hasNext());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}
	
	@Test
	public void testStringHasNextMethodOnly() {
		
		List<String> list1 = Arrays.asList("a", "", "b", "c");
		List<String> list2 = Arrays.asList("1", "2");
		List<String> list3 = Arrays.asList("x", null, "y", "z");
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(list1.iterator(), list2.iterator(), list3.iterator());
		
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(true, testIter.hasNext());
		assertEquals(false, testIter.hasNext());
	}
	
	@Test
	public void testStringNextMethodOnly() {
		
		List<String> list1 = Arrays.asList("a", "", "b", "c");
		List<String> list2 = Arrays.asList("1", "2");
		List<String> list3 = Arrays.asList("x", null, "y", "z");
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(list1.iterator(), list2.iterator(), list3.iterator());
		
		assertEquals("a", testIter.next());
		assertEquals("1", testIter.next());
		assertEquals("x", testIter.next());
		assertEquals("", testIter.next());
		assertEquals("2", testIter.next());
		assertEquals(null, testIter.next());
		assertEquals("b", testIter.next());
		assertEquals("y", testIter.next());
		assertEquals("c", testIter.next());
		assertEquals("z", testIter.next());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}

	@Test
	public void testStringHasNextAndNextMethods() {
		
		List<String> list1 = Arrays.asList("a", "", "b", "c");
		List<String> list2 = Arrays.asList("1", "2");
		List<String> list3 = Arrays.asList("x", null, "y", "z");
		
		AlternatingIterator<String> testIter = new AlternatingIterator<String>(list1.iterator(), list2.iterator(), list3.iterator());
		
		assertEquals(true, testIter.hasNext());
		assertEquals("a", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("1", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("x", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("2", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(null, testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("b", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("y", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("c", testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals("z", testIter.next());
		assertEquals(false, testIter.hasNext());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}
	
	@Test
	public void testIntegerHasNextAndNextMethods() {
		
		List<Integer> list1 = Arrays.asList(-2, 1, 4, 6);
		List<Integer> list2 = Arrays.asList(-1, 2);
		List<Integer> list3 = Arrays.asList(0, 3, 5, 7, 8);
		
		AlternatingIterator<Integer> testIter = new AlternatingIterator<Integer>(list1.iterator(), list2.iterator(), list3.iterator());
		
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(-2), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(-1), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(0), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(1), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(2), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(3), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(4), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(5), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(6), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(7), testIter.next());
		assertEquals(true, testIter.hasNext());
		assertEquals(new Integer(8), testIter.next());
		assertEquals(false, testIter.hasNext());
	    assertThrows(NoSuchElementException.class, () -> {
	    	testIter.next();
	    });
	}
}
