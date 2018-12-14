package business;

import java.util.List;

public abstract class Node {

	private int id;
	private String name;
	
	
	public Node(int nodeId, String name) {
		
		setId(nodeId);
		setName(name);
	}
	
	public abstract double getDistance(Node other);

	
	private void setName(String name) {
		this.name = name;
	}

	private void setId(int id) {
		this.id = id;
	}


	
}
