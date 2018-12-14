package business;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

	private int Id;
	private List<Node> neighbors;
	
	
	public Node(int nodeId, List<Node> neighborList) {
		
		setId(nodeId);
		setNeighbors(neighborList);
	}

	
	
	
	
	
	
	

	private void setId(int id) {
		Id = id;
	}

	
	private void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}
	
	
}
