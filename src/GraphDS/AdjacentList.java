package GraphDS;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacentList implements GraphAccess{

	public Map<Node,LinkedList<Edge>> adjacentList = new LinkedHashMap<>();
	
	@Override
	public void addNode(Node vertex) {
		// If vertex is not present in the map then we will add the new vertex.
		
		if(!adjacentList.containsKey(vertex))
			adjacentList.put(vertex, null);
		
	}

	@Override
	public void addEdge(Edge edge) {
		// We will iterate over the map and found the corresponding vertex for which
		// we want to add the new edge.If edge is not 
		for (Map.Entry<Node,LinkedList<Edge>> entry : adjacentList.entrySet()) {
		   if(entry.getKey().equals(edge.fromNode)) {
			   if(!entry.getValue().contains(edge))
				   entry.getValue().add(edge);
		   }
		}
		
	}

	@Override
	public void deleteNode(Node vertex) {
		// TODO Auto-generated method stub
		
		if(adjacentList.containsKey(vertex)) {
			adjacentList.remove(vertex);
		}
		
	}

	@Override
	public void deleteEdge(Edge edge) {
		// TODO Auto-generated method stub
		for (Map.Entry<Node,LinkedList<Edge>> entry : adjacentList.entrySet()) {
			   if(entry.getKey().equals(edge.fromNode)) {
				   if(entry.getValue().contains(edge))
					   entry.getValue().remove(edge);
			   }
			}
			
		
	}

	@Override
	public List<Node> adjacent(Node node) {
		List<Edge> edgeList = new LinkedList<>();
		List<Node> adjacent = new LinkedList<>();
		// TODO Auto-generated method stub
		for (Map.Entry<Node,LinkedList<Edge>> entry : adjacentList.entrySet()) {
			   if(entry.getKey().equals(node)) {
				  edgeList = entry.getValue();
				  break;
			   }
			}
			
		for(Edge e:edgeList) {
			adjacent.add(e.fromNode);
		}
		return adjacent;
	}

	@Override
	public boolean neighbors(Node vertex1, Node vertex2) {
		// TODO Auto-generated method stub
		List<Edge> edgeList = new LinkedList<>(); 
		for (Map.Entry<Node,LinkedList<Edge>> entry : adjacentList.entrySet()) {
			   if(entry.getKey().equals(vertex1)) {
				   edgeList = new LinkedList<>();
				   break;
			   }
			}
		
		for(Edge e:edgeList) {
			if(e.toNode.equals(vertex2))
				return true;
		}
		return false;
	}

}
