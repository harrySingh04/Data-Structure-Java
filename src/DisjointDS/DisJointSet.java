package DisjointDS;

import java.util.HashMap;
import java.util.Map;

public class DisJointSet {
	
	private Map<Long,Node> map = new HashMap<Long,Node>();
	public class Node{
		long data;
		int rank;
		Node parent;	
		}
	
	public void makeSet(long data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.rank = 0;
		newNode.parent = newNode;
		map.put(data, newNode);
	}
	
	public void unionSet(Long data1,Long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		
		
		if(parent1.data ==parent2.data) 
			//That means both belongs to same set
			return ;
		//If same rank then only we will increase the rank value or else we will keep the same 
	// rank
		if(parent1.rank>=parent2.rank) {
			parent1.rank = (parent1.rank==parent2.rank?parent1.rank+1:parent1.rank);
			parent2.parent = parent1;
		}
		else {
			parent1.parent = parent2;
		}
		
	}
	
	public Node findSet(Node node) {
		
		if(node.parent.equals(node))
			return node.parent;
		else {
			node.parent = findSet(node.parent);
			return node.parent;
		}
		
	}
	
	//Find the value of a particular set
	public long findSet(long data) {
		return findSet(map.get(data)).data; 
	}
	
	public static void main(String[] args) {
		DisJointSet set = new DisJointSet();
		
		set.makeSet(1L);
		set.makeSet(2L);
		set.makeSet(3L);
		set.makeSet(4L);
		set.makeSet(5L);
		set.makeSet(6L);
		set.makeSet(7L);
		
		set.unionSet(1L, 2L);
		set.unionSet(2L, 3L);
		set.unionSet(4L, 5L);
		set.unionSet(6L, 7L);
		set.unionSet(5L, 6L);
		set.unionSet(3L, 7L);
		
		System.out.println(set.findSet(1L));
		System.out.println(set.findSet(2L));
		System.out.println(set.findSet(3L));
		System.out.println(set.findSet(4L));
		System.out.println(set.findSet(5L));
		System.out.println(set.findSet(6L));
		System.out.println(set.findSet(7L));
		
	}
}
