package GraphDS;

import java.util.List;

public interface GraphAccess {
	
	//This method will add the new vertex in the graph
	public void addNode(Node vertex);
	
	// This method will add the new edge 
	public void addEdge(Edge edge);
	
	//This method will delete the vertex from the graph
	public void deleteNode(Node vertex);
	
	//This method will delete the edge from the graph
	public void deleteEdge(Edge edge);
	
	//This method will return the list of adjacent vertex for the particular vertex
	public List<Node> adjacent(Node node);
	
	//This method will check if the two vertex passed are neighbors or not.
	public boolean neighbors(Node vertex1,Node vertex2);
	
	
	
}
