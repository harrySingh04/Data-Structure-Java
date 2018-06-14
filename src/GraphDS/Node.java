package GraphDS;

public class Node {
	
	public int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null)
			return false;
		if(!(obj instanceof Node))
			return false;
		if(obj==this)
			return true;
		return this.data == ((Node)obj).data;
	}
	
	
	
}
