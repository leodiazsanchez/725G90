
public abstract class NPC implements Commandable{
	protected String name;
	private Location position;
	private int health;
	
	public NPC(String name, Location position) {
		this.name = name;
		this.setPosition(position);
	}
	
	public void describeYourself() {
		System.out.println(name);
	}
	

	public Location getPosition() {
		return position;
	}

	public void setPosition(Location position) {
		this.position = position;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
}
