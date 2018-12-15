package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dal.IzmapReader;

public class App {
	public static void main(String[] args) {
		
		IzmapReader mapReader = new IzmapReader("iztech.izmap");
		HashMap<Node, List<Node>> izmap = mapReader.read();
		System.out.println(izmap);
		
		Izmap map = new Izmap(izmap);
		List<Node> aa = new ArrayList<>();
		aa.addAll(izmap.keySet());
		Node node1 = aa.get(0);
		Node node2 = aa.get(1);
		System.out.println(node1);
		System.out.println(node2);
		
		System.out.println(map.getShortestDistance(node1, node2));
		
	}

}
