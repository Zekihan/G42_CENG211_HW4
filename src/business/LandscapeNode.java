package business;

import java.util.List;

public class LandscapeNode extends Node{

	private LandscapeType type;

	public LandscapeNode(int nodeId, List<Node> neighborList, LandscapeType type) {
		super(nodeId, neighborList);
		setType(type);
	}

	private void setType(LandscapeType type) {
		this.type = type;
	}
	
	
}
