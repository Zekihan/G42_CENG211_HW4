package business;

import java.util.List;

public class BuildingNode extends Node {

	private BuildingType type;

	public BuildingNode(int nodeId, List<Node> neighborList, BuildingType type) {
		super(nodeId, neighborList);
		setType(type);
	}

	

	
	private void setType(BuildingType type) {
		this.type = type;
	}

}
