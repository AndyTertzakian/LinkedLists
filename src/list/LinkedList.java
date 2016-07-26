package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import utility.MyIterator;

/*
 * Author: Andre Tertzakian
 * January, 2013
 */

public class LinkedList implements List {

	public DllNode head;
	public DllNode tail;
	private int size = 0;

	public LinkedList() {
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(Object e) {
		if (e == null) {
			return false;
		} else {
			DllNode elementToAdd = new DllNode(e);
			if (size == 0) {
				head = elementToAdd;
				tail = elementToAdd;
			} else {
				DllNode previousTail = tail;
				previousTail.setSuccesor(elementToAdd);

				tail = elementToAdd;
				tail.setPredecessor(previousTail);
			}
			size = size + 1;
			return true;
		}
	}

	@Override
	public Object get(int index) {
		DllNode element = getNode(index);
		return element.getElement();
	}

	@Override
	public boolean contains(Object o) {
		boolean exists = false;
		DllNode element = head; // index 0
		for (int i = 0; i < size; i++) {
			if (o == element.getElement()) {
				exists = true;
				break;
			}
			element = element.getSuccesor();
		}
		return exists;
	}

	@Override
	public Object[] toArray() {
		Object[] ary = new Object[size];
		for (int i = 0; i < size; i++) {
			ary[i] = get(i);
		}
		return ary;
	}

	@Override
	public Object[] toArray(Object[] a) {
		if (a.length == 0) {
			a = toArray();
		} else {
			for (int i = 0; i < a.length; i++) {
				a[i] = get(i);
			}
		}
		return a;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void add(int index, Object element) {
		DllNode node = new DllNode(element);
		DllNode oldHead = head;
		DllNode oldTail = tail;
		if(index == 0) {
			head = node;
			head.setSuccesor(oldHead);
			oldHead.setPredecessor(head);
		}else if(index >= size){
			tail = node;
			tail.setPredecessor(oldTail);
			oldTail.setSuccesor(tail);
		}else {
			DllNode oldNode = getNode(index);
			node.setSuccesor(oldNode);
			DllNode oldNodePredecessor = oldNode.getPredecessor();
			oldNodePredecessor.setSuccesor(node);
			node.setPredecessor(oldNodePredecessor);
			oldNode.setPredecessor(node);
		}
		
		size += 1;
	}

	@Override
	public Object remove(int index) {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		Object removed = null;
		if (index == 0) {
			removed = head.getElement();
			DllNode suc = head.getSuccesor();
			head = suc;
		} else if (index == size - 1) {
			removed = tail.getElement();
			DllNode pre = tail.getPredecessor();
			tail = pre;
		} else {
			DllNode element = head; // index 0
			for (int i = 0; i < size; i++) {
				if (index == i) {
					removed = element.getElement();
					DllNode pre = element.getPredecessor();
					DllNode suc = element.getSuccesor();
					pre.setSuccesor(suc);
					suc.setPredecessor(pre);
				}
				element = element.getSuccesor();
			}
		}

		size -= 1;
		return removed;
	}

	@Override
	public boolean remove(Object objectToRemove) {
		if (objectToRemove == head.getElement()) {
			DllNode succesor = head.getSuccesor();
			head = succesor;
		} else if (objectToRemove == tail.getElement()) {
			DllNode pre = tail.getPredecessor();
			tail = pre;
		} else {
			DllNode element = head; // index 0
			for (int i = 0; i < size; i++) {
				if (objectToRemove == element.getElement()) {
					DllNode pre = element.getPredecessor();
					DllNode suc = element.getSuccesor();
					pre.setSuccesor(suc);
					suc.setPredecessor(pre);
				}
				element = element.getSuccesor(); // update
			}
		}

		size -= 1;

		return true;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			Object object = get(i);
			if (object == o) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			Object object = get(i);
			if (object == o) {
				index = i;
			}
		}
		return index;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		LinkedList ll = new LinkedList();
		for (int i = fromIndex; i <= toIndex; i++) {
			Object z = get(i);
			ll.add(z);
		}
		return ll;
	}

	@Override
	public boolean containsAll(Collection c) {
		boolean result = false;
		for (Object g: c) {
			result = contains(g);
			if (!result) {
				break;
			}
		}
		return result;
	}
	
	@Override
	public boolean addAll(Collection c) {
		boolean result = false;
		for (Object g: c) {
			result = add(g);
		}
		
		return result;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		List list = (List) c;
		boolean result = false;
		int indexToAdd = index;
		for (int i = 0; i < list.size(); i++) {
			Object objectToAdd = list.get(i);
			add(indexToAdd, objectToAdd);
			indexToAdd++;
			result = true;
		}
		return result;
	}

	@Override
	public Object set(int index, Object element) {
		DllNode node = getNode(index);
		Object oldElement = node.getElement();
		node.setElement(element);
		return oldElement;
	}

	private DllNode getNode(int index) {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		DllNode node = head; // index 0
		for (int i = 0; i < index; i++) { // loops through whatever index we
											// called
			node = node.getSuccesor();
		}
		return node;
	}
	
	@Override
	public boolean removeAll(Collection c) {
		List list = (List) c;
		boolean result = false;
		for(int i = 0; i < c.size(); i++) {
			Object object = list.get(i);
			remove(object);
			result = true;
		}
		return result;
	}

	@Override
	public boolean retainAll(Collection c) {
		List list = (List) c;
		boolean result = false;
		head = null;
		tail = null;
		size = 0;
		for(int i = 0 ; i < c.size(); i++) {
			Object object = list.get(i);
			result = add(object);
		}
		return result;
	}

	@Override
	public Iterator iterator() {
		Iterator iterator = new MyIterator(this);
		return iterator;
	}

	@Deprecated
	public ListIterator listIterator() {
		return null;
	}

	@Deprecated
	public ListIterator listIterator(int index) {
		return null;
	}
}
