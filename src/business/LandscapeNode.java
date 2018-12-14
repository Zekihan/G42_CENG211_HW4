package business;

import java.util.List;

public class LandscapeNode extends Node{

	private LandscapeType type;

	public LandscapeNode(int nodeId, String name, LandscapeType type) {
		super(nodeId, name);
		setType(type);
	}

	private void setType(LandscapeType type) {
		this.type = type;
	}
	
	
}
