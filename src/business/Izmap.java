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
		if(map.get(node) == null) {
			return new ArrayList<Node>();
		}
		return map.get(node);
	}
	
	public double getShortestDistance(Node node1,Node node2) {
		if(node1.equals(node2)) {
			return 0;
		}else if (isNeighbor(node1, node2)) {
			return node1.getNeighborDistance(node2);
		}else {
			if(isReachable(node1, node2)) {
				double shortest = 100;
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
				return -1;
			}
		}
	}
	
	public boolean isNeighbor(Node node1,Node node2) {
		return getMap().get(node1).contains(node2);
	}
	
	public boolean isReachable(Node node1,Node node2) {
		return getReachable(node1).contains(node2);
	}
	public List<Node> getReachable(Node node1) {
		Set<Node> mapKey = map.keySet();
		List<Node> unlooked = new ArrayList<>();
		for (Node node : mapKey) {
			unlooked.add(node);
		}
		Set<Node> reached = new HashSet<>();
		List<Node> neighbors = getNeighbors(node1);
		unlooked.remove(node1);
		for (Node node : neighbors) {
			reached.add(node);
		}
		for (Node node : neighbors) {
			if (!(node.equals(node1))) {
				if(!unlooked.isEmpty())
					reached.addAll(getPriReachable(node,unlooked));
			}
		}
		return new ArrayList<Node>(reached);
	}
	
	public List<Node> getPriReachable(Node node1,List<Node> unlooked) {
		Set<Node> reached = new HashSet<>();
		List<Node> neighbors = getNeighbors(node1);
		if(unlooked.remove(node1)) {
			for (Node node : neighbors) {
				reached.add(node);
			}
			for (Node node : neighbors) {
				if (!(node.equals(node1))) {
					if(!unlooked.isEmpty())
						reached.addAll(getPriReachable(node,unlooked));
				}
			}
		}
		return new ArrayList<Node>(reached);
	}
}
