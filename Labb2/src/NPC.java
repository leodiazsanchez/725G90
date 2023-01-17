
public class NPC implements Commandable{
	private String name;
	private Location position;
	private int health;
	
	public NPC(String name, Location position) {
		this.name = name;
		this.position = position;
	}
	
	public void describeYourself() {
		System.out.println(name);
	}
	

	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
