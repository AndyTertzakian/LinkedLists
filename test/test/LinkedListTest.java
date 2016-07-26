package test;

import java.util.ArrayList;

import junit.framework.TestCase;
import list.DllNode;
import list.LinkedList;

/*
 * Author: Andre Tertzakian
 * January, 2013
 */

public class LinkedListTest extends TestCase {

	public void testInitialize() throws Exception {
		// setup and execute
		LinkedList list = new LinkedList();

		// assert
		assertTrue("Should be empty", list.isEmpty());
		assertEquals("Size should be 0", 0, list.size());
		assertNull("Should be null", list.head);
		assertNull("Should be null", list.tail);
	}

	public void testAdd() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";

		// execute
		boolean result = list.add(e1);

		// assert
		assertTrue("Should have added", result);
		assertFalse("Should not be empty", list.isEmpty());
		assertEquals("Size should be 1", 1, list.size());
		assertEquals("Wrong head element", e1, list.head.getElement());
		assertEquals("Wrong tail element", e1, list.tail.getElement());

	}

	public void testAddTwoElements() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "element2";

		// execute
		boolean result1 = list.add(e1);
		boolean result2 = list.add(e2);

		// assert
		assertTrue("Should have added", result1);
		assertTrue("Should have added", result2);
		assertFalse("Should not be empty", list.isEmpty());
		assertEquals("Size should be 2", 2, list.size());

		DllNode head = list.head;
		DllNode tail = list.tail;
		assertEquals("Wrong head element", e1, head.getElement());
		assertEquals("Wrong tail element", e2, tail.getElement());

		assertEquals("Wrong head successor", e2, head.getSuccesor()
				.getElement());
		assertEquals("Wrong tail predeccessor", e1, tail.getPredecessor()
				.getElement());
	}

	public void testAddThreeElements() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "element2";
		String e3 = "element3";

		// execute
		boolean result1 = list.add(e1);
		boolean result2 = list.add(e2);
		boolean result3 = list.add(e3);

		// assert
		assertTrue("Should have added", result1);
		assertTrue("Should have added", result2);
		assertTrue("Should have added", result3);
		assertFalse("Should not be empty", list.isEmpty());
		assertEquals("Size should be 3", 3, list.size());

		DllNode head = list.head;
		DllNode tail = list.tail;
		assertEquals("Wrong head element", e1, head.getElement());
		assertEquals("Wrong tail element", e3, tail.getElement());

		assertEquals("Wrong head successor", e2, head.getSuccesor()
				.getElement());
		assertEquals("Wrong tail predeccessor", e2, tail.getPredecessor()
				.getElement());
	}

	public void testAddFourElements() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "element2";
		String e3 = "element3";
		String e4 = "element4";

		// execute
		boolean result1 = list.add(e1);
		boolean result2 = list.add(e2);
		boolean result3 = list.add(e3);
		boolean result4 = list.add(e4);

		// assert
		assertTrue("Should have added", result1);
		assertTrue("Should have added", result2);
		assertTrue("Should have added", result3);
		assertTrue("Should have added", result4);
		assertFalse("Should not be empty", list.isEmpty());
		assertEquals("Size should be 4", 4, list.size());

		DllNode head = list.head;
		assertHead(head, e1, e2);

		DllNode e2Dll = head.getSuccesor();
		assertDll(e2Dll, e2, e3, e1);

		DllNode e3Dll = e2Dll.getSuccesor();
		assertDll(e3Dll, e3, e4, e2);

		DllNode tail = list.tail;
		assertTail(tail, e4, e3);
	}

	public void testGet() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		list.add(e1);

		// execute
		Object actualElement = list.get(0);

		// assert
		assertEquals("not equal", e1, actualElement);
	}

	public void testGet2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		list.add(e1);
		list.add(e2);

		// execute
		Object actualElement = list.get(1);

		// assert
		assertEquals("not equal", e2, actualElement);
	}

	public void testGet3() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		Object actualElement = list.get(1);

		// assert
		assertEquals("not equal", e2, actualElement);
	}

	public void testGet4() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		Object actualElement = list.get(2);

		// assert
		assertEquals("not equal", e3, actualElement);
	}

	public void testGet_ThrowsError() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		try {
			list.get(3); // there is no element of index3
			fail();
		} catch (IndexOutOfBoundsException e) {
			// do nothing, expecting an error
		}

	}

	public void testGet_DoesNotThrowError() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		try {
			Object actualElement = list.get(2);
			assertEquals("not equal", e3, actualElement);
		} catch (IndexOutOfBoundsException e) {
			fail();
		}
	}

	public void testContain() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		boolean exists = list.contains(e1);

		// assert
		assertTrue("element should exist", exists);
	}

	public void testContain2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		boolean exists = list.contains(e2);

		// assert
		assertTrue("element should exist", exists);
	}

	public void testContain3() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		boolean exists = list.contains(e3);

		// assert
		assertTrue("element should exist", exists);
	}
	
	public void testContainAll() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		String e5 = "elememt5";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		ArrayList<String> aryList = new ArrayList<String>();
		aryList.add(e1);
		aryList.add(e2);
		aryList.add(e3);
		
		// execute
		boolean exists = list.containsAll(aryList);
		
		// assert
		assertTrue("element should exist", exists);
	}
	
	public void testAddAll() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		list.add(e1);
		list.add(e2);
		
		ArrayList<String> aryList = new ArrayList<String>();
		String e3 = "elememt3";
		String e4 = "elememt4";
		aryList.add(e3);
		aryList.add(e4);

		// execute
		boolean result = list.addAll(aryList);
		
		// assert
		assertTrue(result);
		assertEquals(" e3 expected", list.get(2), e3);
		assertEquals(" e4 expected", list.get(3), e4);
	}
	
	public void testRemoveAll() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		ArrayList<String> aryList = new ArrayList<String>();
		aryList.add(e3);
		aryList.add(e4);
		
		// execute
		boolean result = list.removeAll(aryList);
		
		// assert
		assertTrue(result);
		assertEquals(" size 2 expected", 2, list.size());
		assertEquals(" e1 expected", e1, list.get(0));
		assertEquals(" e2 expected", e2, list.get(1));
	}
	
	public void testRetainAll() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		ArrayList<String> aryList = new ArrayList<String>();
		aryList.add(e3);
		aryList.add(e4);
		
		// execute
		boolean result = list.retainAll(aryList);
		
		// assert
		assertTrue(result);
		assertEquals(" size 2 expected", 2, list.size());
		assertEquals(" e3 expected", e3, list.get(0));
		assertEquals(" e4 expected", e4, list.get(1));
	}
	
	public void testAddIndex() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		list.add(e1);
		list.add(e2);
		
		// execute
		String e3 = "elememt3";
		list.add(0, e3);
		
		// assert
		DllNode head = list.head;
		assertHead(head, e3, e1);
		assertEquals(" size expected", 3, list.size());
		assertEquals(" e3 expected", e3, list.get(0));
	}
	
	public void testAddIndex2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		list.add(e1);
		list.add(e2);
		
		// execute
		String e3 = "elememt3";
		list.add(5, e3);
		
		// assert
		DllNode tail = list.tail;
		assertTail(tail, e3, e2);
		assertEquals(" size expected", 3, list.size());
		assertEquals(" e3 expected", e3, list.get(2));
	}

	public void testAddIndexCollection() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		list.add(e1);
		list.add(e2);
		

		ArrayList<String> list2 = new ArrayList<String>();
		String e3 = "elememt3";
		String e4 = "elememt4";
		list2.add(e3);
		list2.add(e4);
		
		// execute
		boolean result = list.addAll(0, list2);
		
		// assert
		assertTrue(result);
		DllNode head = list.head;
		assertHead(head , e3, e4);
		assertEquals(" size expected", 4, list.size());
		assertEquals(" e4 expected", e4, list.get(1));
		assertEquals(" e1 expected", e1, list.get(2));
		assertEquals(" e2 expected", e2, list.get(3));
	}

	public void testAddIndexCollection2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		list.add(e1);
		list.add(e2);
		
		
		ArrayList<String> list2 = new ArrayList<String>();
		String e3 = "elememt3";
		String e4 = "elememt4";
		list2.add(e3);
		list2.add(e4);
		
		// execute
		boolean result = list.addAll(1, list2);
		
		// assert
		assertTrue(result);
		DllNode head = list.head;
		assertEquals(" size expected", 4, list.size());
		assertHead(head , e1, e3);
		assertEquals(" e4 expected", e3, list.get(1));
		assertEquals(" e1 expected", e4, list.get(2));
		assertEquals(" e2 expected", e2, list.get(3));
	}
	
	public void testAddIndex3() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e4 = "elememt4";
		String e5 = "elememt5";
		String e6 = "elememt6";
		list.add(e1);
		list.add(e2);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		
		// execute
		String e3 = "elememt3";
		list.add(2, e3);
		
		// assert
		assertEquals(" size expected", 6, list.size());
		assertEquals(" e3 expected", e3, list.get(2));
	}
	
//	public void testAddAll2() throws Exception {
//		// setup
//		LinkedList list = new LinkedList();
//		String e1 = "elememt1";
//		String e2 = "elememt2";
//		list.add(e1);
//		list.add(e2);
//		
//		//list to add
//		ArrayList<String> aryList = new ArrayList<String>();
//		String e3 = "elememt3";
//		String e4 = "elememt4";
//		aryList.add(e3);
//		aryList.add(e4);
//		
//		// execute
//		boolean result = list.addAll(0, aryList);
//		
//		// assert
//		assertTrue(result);
//		assertEquals(" e3 expected", list.get(0), e3);
//		assertEquals(" e4 expected", list.get(1), e4);
//	}

	public void testContainAll2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		String e5 = "elememt5";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		ArrayList<String> aryList = new ArrayList<String>();
		aryList.add(e1);
		aryList.add(e2);
		aryList.add(e3);
		aryList.add("df");
		
		// execute
		boolean exists = list.containsAll(aryList);
		
		// assert
		assertFalse("element should not exist", exists);
	}

	public void testContain_false() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		boolean exists = list.contains("fake");

		// assert
		assertFalse("element should not exist", exists);
	}

	public void testClear() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);

		// execute
		list.clear();

		// assert
		assertEquals("Size should be 0", 0, list.size());
		assertNull(list.head);
		assertNull(list.tail);
	}
	
	public void testRemoveInt() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		String result = (String) list.remove(0);
		
		// assert
		assertEquals("element removed", e1, result);
		assertEquals("Size should be 2", 2, list.size());
		assertEquals("e2 shoudl be the new head", e2, list.head.getElement());
	}
	
	public void testRemove() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		boolean result = list.remove(e1);
		
		// assert
		assertTrue("element should be removed", result);
		assertEquals("Size should be 2", 2, list.size());
		assertEquals("e2 shoudl be the new head", e2, list.head.getElement());
	}
	
	public void testRemove_tail() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		boolean result = list.remove(e3);
		
		// assert
		assertTrue("element should be removed", result);
		assertEquals("Size should be 2", 2, list.size());
		assertEquals("e2 shoudl be the new tail", e2, list.tail.getElement());
	}
	
	public void testRemoveInt_tail() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		String result = (String) list.remove(2);
		
		// assert
		assertEquals("element removed", e3, result);
		assertEquals("Size should be 2", 2, list.size());
		assertEquals("e2 shoudl be the new tail", e2, list.tail.getElement());
		
	}
	
	public void testRemoveInt_IndexOutOfBounds() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		try {
			list.remove(3);
			fail();
		} catch(IndexOutOfBoundsException e) {
			//do nothing, error expected
		}
		
	}
	
	public void testRemove_element2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		boolean result = list.remove(e2);
		
		// assert
		assertTrue("element should be removed", result);
		assertEquals("Size should be 2", 2, list.size());
		assertEquals("e3 shoudl be the new tail", e3, list.tail.getElement());
		assertEquals("head successor shoudl be tail", list.head.getSuccesor(), list.tail);
	}
	
	public void testRemoveInt_element2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		String result = (String) list.remove(1);
		
		// assert
		assertEquals("element removed", e2, result);
		assertEquals("Size should be 2", 2, list.size());
		assertEquals("heads succesor should be the tail", e3, list.tail.getElement());
	}
	
	public void testRemove_element2_siz4() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		// execute
		boolean result = list.remove(e2);
		
		// assert
		assertTrue("element should be removed", result);
		assertEquals("Size should be 3", 3, list.size());
		assertEquals("e3 shoudl be the new tail", e4, list.tail.getElement());
		assertEquals("head new successor should be e3", list.head.getSuccesor().getElement(), e3);
	}
	
	public void testRemoveInt_element2_siz4() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		// execute
		String result = (String) list.remove(1);
		
		// assert
		assertEquals("element removed", e2, result);
		assertEquals("Size should be 3", 3, list.size());
		DllNode actualHeadSuccesor = list.head.getSuccesor();
		assertEquals("heads succesor should be the e3", e3, actualHeadSuccesor.getElement());
		assertEquals("heads succesor's predecessdor should be the head", e1, actualHeadSuccesor.getPredecessor().getElement());
	}
	
	public void testToArray() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		Object[] actual = list.toArray();
		
		// assert
		assertEquals("same e1 expected", actual[0], e1);
		assertEquals("same e2 expected", actual[1], e2);
		assertEquals("same e3 expected", actual[2], e3);
	}
	
	public void testToArray2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		Object[] ary = new Object[0];
		Object[] actual = list.toArray(ary);
		
		
		// assert
		assertEquals("same e1 expected", actual[0], e1);
		assertEquals("same e2 expected", actual[1], e2);
		assertEquals("same e3 expected", actual[2], e3);
	}
	
	public void testToArray3() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		Object[] ary = new Object[2];
		Object[] actual = list.toArray(ary);
		
		
		// assert
		assertEquals("same e1 expected", actual[0], e1);
		assertEquals("same e2 expected", actual[1], e2);
	}
	
	public void testIndexOf() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		int actual = list.indexOf(e2);
		
		
		// assert
		assertEquals("e2 index expected", 1, actual);
	}
	
	public void testIndexOf2() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		int actual = list.indexOf(e3);
		
		
		// assert
		assertEquals("e2 index expected", 2, actual);
	}

	
	public void testSet() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e3);
		
		// execute
		Object old = list.set(1, e2);
		
		// assert
		assertEquals("size 2 expected", 2, list.size());
		assertEquals("e2 expected", e2, list.get(1));
		assertEquals("e3 expected to be old element", e3, old);
	}
	
	public void testIndexOfError() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		// execute
		int actual = list.indexOf("312");
		
		
		// assert
		assertEquals("e2 index expected", -1, actual);
	}
	
	public void testLastIndexO() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e1);
		
		// execute
		int actual = list.lastIndexOf(e1);
		
		
		// assert
		assertEquals("e2 index expected", 3, actual);
	}
	
	public void testIndexOf3() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		list.add(e1);
		list.add(e1);
		list.add(e1);
		list.add(e1);
		list.add(e1);
		
		// execute
		int actual = list.indexOf(e1);
		
		
		// assert
		assertEquals("e2 index expected", 0, actual);
	}

	public void testSubList() throws Exception {
		// setup
		LinkedList list = new LinkedList();
		String e1 = "elememt1";
		String e2 = "elememt2";
		String e3 = "elememt3";
		String e4 = "elememt4";
		String e5 = "elememt5";
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		// execute
		LinkedList actual = (LinkedList) list.subList(0, 2);
		
		
		// assert
		assertEquals("e1 expected", e1, actual.get(0));
		assertEquals("e2 expected", e2, actual.get(1));
		assertEquals("e3 expected", e3, actual.get(2));
	}

	void assertHead(DllNode node, Object expectedElement, Object expectedSucc) {
		assertEquals("Wrong expected element", expectedElement,
				node.getElement());
		assertEquals("Wrong expected succ", expectedSucc, node.getSuccesor()
				.getElement());
		assertNull("no head pre", node.getPredecessor());
	}

	void assertTail(DllNode node, Object expectedElement, Object expectedPre) {
		assertEquals("Wrong expected element", expectedElement,
				node.getElement());
		assertNull("no tail succ", node.getSuccesor());
		assertEquals("Wrong expected pre", expectedPre, node.getPredecessor()
				.getElement());
	}

	void assertDll(DllNode node, Object expectedElement, Object expectedSucc,
			Object expectedPre) {
		assertEquals("Wrong expected element", expectedElement,
				node.getElement());
		assertEquals("Wrong expected succ", expectedSucc, node.getSuccesor()
				.getElement());
		assertEquals("Wrong expected pre", expectedPre, node.getPredecessor()
				.getElement());
	}
}
