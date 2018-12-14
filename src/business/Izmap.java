package business;

import java.util.HashMap;
import java.util.List;

public class Izmap {

	private HashMap<Node, List<Node>> map;

	public Izmap(HashMap<Node, List<Node>> map) {
		setMap(map);
	}

	public HashMap<Node, List<Node>> getMap() {
		return map;
	}

	private void setMap(HashMap<Node, List<Node>> map) {
		this.map = map;
	}
	
	public List<Node> getNeighbors(Node node) {
		return getMap().get(node);
	}
	
	public double getDistance(Node node1,Node node2) {
		if (isNeighbor(node1, node2)) {
			return node1.getNeighborDistance(node2);
		}else {
			if(isReachable(node1, node2)) {
				return 0;
			}
		}
		return 0;
	}
	
	public boolean isNeighbor(Node node1,Node node2) {
		return getMap().get(node1).contains(node2);
	}
	
	public boolean isReachable(Node node1,Node node2) {
		boolean reach = false;
		if(isNeighbor(node1, node2)) {
			reach = true;
		}else {
			List<Node> neighbors = getNeighbors(node1);
			for (Node node : neighbors) {
				if (!(node.equals(node1))) {
					if(isReachable(node, node2)) {
						reach = true;
					}
				}
			}
		}
		return reach;
	}
}
