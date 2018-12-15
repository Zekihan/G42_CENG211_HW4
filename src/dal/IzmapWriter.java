package dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import business.BuildingNode;
import business.CategoryType;
import business.Node;

public class IzmapWriter {

	private String fileName;
	
	public IzmapWriter(String fileName) {
		setFileName(fileName);
	}
	
	public void write(HashMap<Node, List<Node>> izmap) {
		PrintWriter fileOut = null;
		try {
			fileOut = new PrintWriter(new File("fileName"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Node node: izmap.keySet()) {
			
			CategoryType categoryType = node.getType();
			String type;
			switch(categoryType) {
			case DEPARTMENT :
				type = "Department" ;
				break;
			case CAFETERIA:
				type = "Cafeteria";
				break;
			case ADMINISTRATIVE:
				type = "Administrative";
				break;
			case FACILITIES:
				type = "Facility";
				break;
			case WATERFALL:
				type = "Waterfall";
				break;
			case BEACH:
				type = "Beach";
				break;
			case HISTORICAL_RUIN:
				type = "Historical Ruin";
				break;
			default:
				type = null;
				break;
			}
			if(node.getClass().equals(BuildingNode.class)) {
				String line = node.getId() + " [Building, " + type + ", " + node.getName() + "]";
				fileOut.println(line);
			}else {
				String line = node.getId() + " [Landscape, " + type + ", " + node.getName() + "]";
				fileOut.println(line);
			}
		}
		
		
	}
	
	
	
	
	

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
