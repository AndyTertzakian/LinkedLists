package utility;

import java.util.Iterator;
import java.util.List;

/*
 * Author: Andre Tertzakian
 * January, 2013
 */

public class MyIterator implements Iterator{

	private List list;
	private Object current;
	private int index = 0;
	
	public MyIterator(List list) {
		this.list = list;
		index = 0;
		current = list.get(index);
	}

	@Override
	public boolean hasNext() {
		boolean result = false; 
		if(index < list.size()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public Object next() {
		current = list.get(index++);
		return current;
	}

	@Override
	public void remove() {
		list.remove(current);
	}

}
