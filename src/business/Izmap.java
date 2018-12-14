package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				double distance = 0;
				List<Node> neighbors = getNeighbors(node1);
				for (Node node : neighbors) {
					if (!(node.equals(node1))) {
						if(isReachable(node, node2)) {
							distance += node1.getNeighborDistance(node);
							getDistance(node, node2);
						}
					}
				}
				return distance;
			}
			else {
				return 0;
			}
		}
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
	
	public List<Node> getReachable(Node node1) {
		Set<Node> reached = new HashSet<>();
		List<Node> neighbors = getNeighbors(node1);
		reached.addAll(neighbors);
		for (Node node : neighbors) {
			if (!(node.equals(node1))) {
				reached.addAll(getReachable(node));
			}
		}
		return new ArrayList<Node>(reached);
	}
}
