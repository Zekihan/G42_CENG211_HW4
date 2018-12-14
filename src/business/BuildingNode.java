package business;

import java.util.List;

public class BuildingNode extends Node {

	private BuildingType type;

	public BuildingNode(int nodeId, String name, BuildingType type) {
		super(nodeId, name);
		setType(type);
	}

	

	
	private void setType(BuildingType type) {
		this.type = type;
	}

}
