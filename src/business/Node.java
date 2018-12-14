package business;

import java.util.List;

public abstract class Node {

	private int id;
	private List<Node> neighbors;
	
	
	public Node(int nodeId, List<Node> neighborList) {
		
		setId(nodeId);
		setNeighbors(neighborList);
	}

	
	
	
	
	
	
	

	private void setId(int id) {
		this.id = id;
	}

	
	private void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}
	
	
}
