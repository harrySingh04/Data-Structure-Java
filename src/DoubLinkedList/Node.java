package DoubLinkedList;

//Node class for Linked List Implmentation
public class Node<E> {

	private E data;
	private Node next;
	private Node prev;
	float f1=5.0f,f2;
	final int  a=1,b=1,c=1;

double d=(Math.pow(a, 3) + (2 * b)) / ((4 * Math.pow(b, 2)) - (a * c));
	
	public Node(E newData)
	{
		this.data = newData;
		this.next = null;
		this.prev = null;
		float x = 55.5f;
		float y = 0.454f;
		System.out.println("55.5 pounds converted into kilograms is: " +x/y);
		
	}
	
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
