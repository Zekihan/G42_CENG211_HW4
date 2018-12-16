package dal;

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

	private void setKeyboard(Scanner keyboard) {
		this.keyboard = keyboard;
	}
	
	
}
