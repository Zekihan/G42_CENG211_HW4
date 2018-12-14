package business;

import java.util.List;

public abstract class Node {

	private int id;
	private String name;
	
	
	public Node(int nodeId, String name) {
		
		setId(nodeId);
		setName(name);
	}
	
	public abstract double getNeighborDistance(Node other);

	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		Node other = (Node) obj;
		return ((getId() == other.getId()) && (getName().equals(other.getName())));
	}


	
}
