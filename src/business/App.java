package business;

public class App {
	public static void main(String[] args) {
		BuildingNode aa = new BuildingNode(0, "aa", BuildingType.DEPARTMENT);
		LandscapeNode bb = new LandscapeNode(1, "aa", LandscapeType.BEACH);
		
		Node[] cc = new Node[2];
		cc[0] = aa;
		cc[1] = bb;
		Node n = cc[0];
		System.out.println(n.getClass());
	}

}