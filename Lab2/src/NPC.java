
public abstract class NPC implements Commandable {
	private Location position;
	private int health = 10;
	private String name;
	
	public NPC (String name, Location location) {
		this.name = name;
		this.position = location;
		location.addNPC(this);
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

	public String getName() {
		return name;
	}

}
