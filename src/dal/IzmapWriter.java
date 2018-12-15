package dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import business.BuildingNode;
import business.Node;

public class IzmapWriter {

	private String fileName;
	
	public IzmapWriter(String fileName) {
		setFileName(fileName);
	}
	
	public void write(HashMap<Node, List<Node>> izmap) {
		PrintWriter fileOut;
		try {
			fileOut = new PrintWriter(new File("fileName"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Node node: izmap.keySet()) {
			if(node.getClass().equals(BuildingNode.class)) {
				
				String line = node.getId() + " [Building, " + node.getType().toString();
			}
			
		}
		
	}
	
	
	
	
	

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
