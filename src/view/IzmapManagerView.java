package view;

public class IzmapManagerView {

	public void startMessage() {
		System.out.println("Welcome to the Iztech Map Application");
	}
	
	public void menu() {
		System.out.println( System.lineSeparator() +
				"Menu:" + System.lineSeparator() + 
				"1) Find Shortest Path" + System.lineSeparator() +
				"2) Add/Remove Locations" + System.lineSeparator() + 
				"3) Possible reachable locations from a given location and distance" + System.lineSeparator() + 
				"4) Neighbors" + System.lineSeparator()+
				"5) Exit" + System.lineSeparator());
	}
	
	public void menuCase1() {
		System.out.println( "Please enter Id's of two locations" + System.lineSeparator());
	}
	
	public void menuCase2() {
		System.out.println( System.lineSeparator() +
				"Add/Remove:" + System.lineSeparator() + 
				"1) Add Location" + System.lineSeparator() +
				"2) Remove Location" + System.lineSeparator());
	}
	
	public void menuCase2Case1() {
		System.out.println();
		
	}
	public void menuCase2Case2() {
		System.out.println( "Please write Id of a location" + System.lineSeparator());
	}
	
	public void menuCase3() {
		System.out.println( "Please write Id of a location and the distance you want" + System.lineSeparator());
	}
	
	public void menuCase4() {
		System.out.println( "Please write Id of a location" + System.lineSeparator());
	}
	
	public void menuCase5() {
		System.out.println( "Thanks for using our application!" + System.lineSeparator());
	}
}
