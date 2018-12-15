package business;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dal.IzmapReader;

public class IzmapManager {
	
	Izmap map;
	private Scanner keyboard;

	public IzmapManager() {
		this.map = new Izmap(new IzmapReader("iztech.izmap").read());
		keyboard = new Scanner(System.in);
	}
	
	public void start() {
		System.out.println("Welcome to the Book & Movie Rent Application" );
		while(true) {
			System.out.println( System.lineSeparator() +
					"Menu:" + System.lineSeparator() + 
					"1) Find Shortest Path" + System.lineSeparator() +
					"2) Add/Remove Locations" + System.lineSeparator() + 
					"3) Possible reachable locations from a given location and distance" + System.lineSeparator() + 
					"4) Neighbors" + System.lineSeparator()+
					"5) Exit" + System.lineSeparator());
			int a = keyboard.nextInt();
			switch(a){
			case 1: 
				System.out.println( "Please write Id's of two locations" + System.lineSeparator());
				getShortestPath(map.getNodeById(keyboard.nextInt()), map.getNodeById(keyboard.nextInt()));
				break;
			case 2: 
				System.out.println( System.lineSeparator() +
						"Add/Remove:" + System.lineSeparator() + 
						"1) Add Location" + System.lineSeparator() +
						"2) Remove Location" + System.lineSeparator());
				int b = keyboard.nextInt();
				switch (b) {
				case 1:
					addNode();
					break;
				case 2:
					System.out.println( "Please write Id of a location" + System.lineSeparator());
					removeNode(map.getNodeById(keyboard.nextInt()));
					break;
				default:
					break;
				}
				break;
			case 3:
				System.out.println( "Please write Id of a location and the distance you want" + System.lineSeparator());
				getPossibleReachableLocationsFromGivenLocationDistance(map.getNodeById(keyboard.nextInt()), keyboard.nextDouble());
				break;
			case 4:
				System.out.println( "Please write Id of a location" + System.lineSeparator());
				getNeighbors(map.getNodeById(keyboard.nextInt()));
				break;
			case 5: 
				keyboard.close();
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
}
