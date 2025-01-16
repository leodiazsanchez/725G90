
public class Room extends Location {

	private int size;

	public Room(String name, String description, int size) {
		super(name, description);
		this.size = size;
	}

	@Override
	public void printLocationVariable() {
		System.out.println("Size: " + size + " square feet");
		
	}
	
	

}
