package business;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import dal.ConsoleInput;
import dal.IzmapReader;
import view.IzmapManagerView;

public class IzmapManager {
	
	private Izmap map;
	private IzmapManagerView view;
	private ConsoleInput consoleIn;

	public IzmapManager() {
		setMap(new Izmap(new IzmapReader("iztech.izmap").read()));
		setView(new IzmapManagerView());
		setConsoleIn(new ConsoleInput());
	}
	
	public void start() {
		view.startMessage();
		while(true) {
			view.menu();
			int a = consoleIn.readInt();
			switch(a){
			case 1: 
				view.menuCase1();
				getShortestPath(map.getNodeById(consoleIn.readInt()), map.getNodeById(consoleIn.readInt()));
				break;
			case 2: 
				int b = consoleIn.readInt();
				switch (b) {
				case 1:
					view.menuCase2Case1();
					addNode();
					break;
				case 2:
					view.menuCase2Case2();
					removeNode(map.getNodeById(consoleIn.readInt()));
					break;
				default:
					break;
				}
				break;
			case 3:
				view.menuCase3();
				getPossibleReachableLocationsFromGivenLocationDistance(map.getNodeById(consoleIn.readInt()), consoleIn.readDouble());
				break;
			case 4:
				view.menuCase4();
				getNeighbors(map.getNodeById(consoleIn.readInt()));
				break;
			case 5: 
				view.menuCase5();
				System.exit(0);
				break;
			default: 
				break;
			}
		}
	}
	
	private void addNode() {
		
	}
	
	private void removeNode(Node node) {
		HashMap<Node, List<Node>> izmap = map.getMap();
		List<Node> neighbors = izmap.get(node);
		for (Node node1 : neighbors) {
			int index = izmap.get(node1).indexOf(node);
			izmap.get(node1).remove(index);
		}
		izmap.remove(node);
	}
	
	private void getShortestPath(Node node1,Node node2) {
		System.out.println(map.getShortestDistance(node1, node2));
	}
	
	private void getPossibleReachableLocationsFromGivenLocationDistance(Node node,double distance) {
		List<Node> reachable = map.getReachable(node);
		for (Node node1 : reachable) {
			double calcDistance = map.getShortestDistance(node, node1);
			if(calcDistance > 0) {
				if(calcDistance<=distance) {
					System.out.println(node1+" Distance : "+calcDistance);
				}
			}
		}
	}
	
	private void getNeighbors(Node node) {
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

	private void setMap(Izmap map) {
		this.map = map;
	}

	private void setView(IzmapManagerView view) {
		this.view = view;
	}

	private void setConsoleIn(ConsoleInput consoleIn) {
		this.consoleIn = consoleIn;
	}
}
