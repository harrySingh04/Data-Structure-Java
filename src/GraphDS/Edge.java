package GraphDS;

public class Edge {
	
	Node fromNode;
	Node toNode;
	int weight;
	
	public Edge(Node fromNode,Node toNode,int weight) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromNode == null) ? 0 : fromNode.hashCode());
		result = prime * result + ((toNode == null) ? 0 : toNode.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (fromNode == null) {
			if (other.fromNode != null)
				return false;
		} else if (!fromNode.equals(other.fromNode))
			return false;
		if (toNode == null) {
			if (other.toNode != null)
				return false;
		} else if (!toNode.equals(other.toNode))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
	
}
