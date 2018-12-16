package dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
	
	private Scanner keyboard;
	
	public ConsoleInput() {
		setKeyboard(new Scanner(System.in));
	}
	
	public int readInt() {
		
		int inputValue = keyboard.nextInt();
		return inputValue;
	}
	
	public String readString() {
		
		String inputValue = keyboard.next();
		return inputValue;
	}
	
	public double readDouble() {
		
		double inputValue = keyboard.nextDouble();
		return inputValue;
	}
	
	public List<String> readLineOfString() {
		
		List<String> inputList = new ArrayList<String>();
		keyboard.useDelimiter(",");
		while(keyboard.hasNext()) {
			inputList.add(keyboard.next());
		}
		keyboard.reset();
		return inputList;
	}

	private void setKeyboard(Scanner keyboard) {
		this.keyboard = keyboard;
	}
	
	
}
