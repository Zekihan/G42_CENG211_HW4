package business;

import java.util.Comparator;
import java.util.List;

import dal.IzmapReader;

public class IzmapManager {
	
	Izmap map;

	public IzmapManager() {
		this.map = new Izmap(new IzmapReader("iztech").read());
	}
	
	public void addNode() {
		
	}
	
	public void removeNode() {
		
	}
	public double getShortestPath(Node node,double distance) {
		List<Node> reachable = map.getReachable(node);
		for (Node node1 : reachable) {
			if(map.getDistance(node, node1) <= distance) {
				System.out.println(node1);
			}
		}
		return 0;
	}
	public void getNeighbors(Node node) {
		List<Node> neighbors = map.getNeighbors(node);
		neighbors.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (Node node1 : neighbors) {
			System.out.println(node1);
		}
	}
}
