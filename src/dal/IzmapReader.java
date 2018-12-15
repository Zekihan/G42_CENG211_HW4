package dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import business.BuildingNode;
import business.BuildingType;
import business.LandscapeNode;
import business.LandscapeType;
import business.Node;

public class IzmapReader {

	private String fileName;
	
	public IzmapReader(String fileName) {
		setFileName(fileName);
	}
	
	public HashMap<Node, List<Node>> read(){
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		HashMap<Integer,Node> nodes = new HashMap<>();
		fileIn.useDelimiter("\\W+");

		int nodeId = 0;
		while(fileIn.hasNext()) {
			nodeId = fileIn.nextInt();
			if (fileIn.hasNextInt()) {
				break;
			}
			String category = fileIn.next();
			String categoryType = fileIn.next();
			String name = fileIn.next();
			while(!fileIn.hasNextInt()) {
				name = name + " " + fileIn.next();
			}
			Node newNode = null;
			if(category.equals("Building")) {
				BuildingType type = null;
				switch(categoryType) {
				case "Department":
					type = BuildingType.DEPARTMENT;
					break;
				case "Cafeteria":
					type = BuildingType.CAFETERIA;
					break;
				case "Administrative":
					type = BuildingType.ADMINISTRATIVE;
					break;
				case "Facilities":
					type = BuildingType.FACILITIES;
					break;
				default:
					break;
				}
				newNode = new BuildingNode(nodeId, name, type);
			}else if(category.equals("Landscape")) {
				LandscapeType type = null;
				switch(categoryType) {
				case "Waterfall":
					type = LandscapeType.WATERFALL;
					break;
				case "Beach":
					type = LandscapeType.BEACH;
					break;
				case "Historical Ruin":
					type = LandscapeType.HISTORICAL_RUIN;
					break;
				default:
					break;
				}
				newNode = new LandscapeNode(nodeId, name, type);
			}else {
			}
			nodes.put(nodeId, newNode);
		}
		HashMap<Node, List<Node>> izmap = new HashMap<>();
		for (Node node : nodes.values()) {
			izmap.put(node, new ArrayList<Node>());
		}
		
		List<int[]> pairList = new ArrayList<>();
		int pairNodeId = fileIn.nextInt();
		

		int[] pair = {nodeId, pairNodeId};
		pairList.add(pair);			
		
		while(fileIn.hasNextInt()) {
			pair = new int[2];
			nodeId = fileIn.nextInt();
			pairNodeId = fileIn.nextInt();
			pair[0] = nodeId;
			pair[1] = pairNodeId;
			pairList.add(pair);
		}
		
		HashMap<Integer,List<Integer>> directedGraph = new HashMap<>();
		for(Node node: nodes.values()) {
			
			 directedGraph.put(node.getId(), new ArrayList<Integer>());
		}
		for(int[] aPair: pairList) {
			int node1 = aPair[0];
			int node2 = aPair[1];
			directedGraph.get(node1).add(node2);
			directedGraph.get(node2).add(node1);
		}
		for(int id : directedGraph.keySet()) {
			
			Node targetNode = nodes.get(id);
			for (int i : directedGraph.get(id)) {
				izmap.get(targetNode).add(nodes.get(i));
			}
		}	
		return izmap;
	}
	

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
