package list;

/*
 * Author: Andre Tertzakian
 * January, 2013
 */

public class DllNode {

	private DllNode succesor;
	private DllNode predecessor;
	private Object element;

	public DllNode(Object e) {
		element = e;
	}
	
	public DllNode getSuccesor() {
		return succesor;
	}

	public void setSuccesor(DllNode succesor) {
		this.succesor = succesor;
	}

	public DllNode getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(DllNode predecessor) {
		this.predecessor = predecessor;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	
	@Override
	public String toString() {
		return element.toString();
	}
}
