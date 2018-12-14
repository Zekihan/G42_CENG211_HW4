package dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import business.Node;

public class IzmapReader {

	private String fileName;
	
	public IzmapReader(String fileName) {
		setFileName(fileName);
	}
	
	public HashMap<Node, List<Node>> read(){
		Scanner fileIn;
		try {
			fileIn = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	

	
	private void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
