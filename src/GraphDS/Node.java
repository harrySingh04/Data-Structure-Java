package GraphDS;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private int id;
	private List<Node> adjacent;
	
	public Node(int id) {
		this.id = id;
		this.adjacent  = new LinkedList<Node>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addAdjacentNodes(Node newNode) {
		this.adjacent.add(newNode);
	}
	public List<Node> getAdjacent(){
		return this.adjacent;
	}
	
	
}
