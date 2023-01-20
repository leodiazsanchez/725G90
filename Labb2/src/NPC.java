
public abstract class NPC implements Commandable{
	private Location position;
	private int health = 10;
	
	public NPC(Location position) {
		this.setPosition(position);
	}
	
	public void describeYourself() {
		System.out.println(this.getClass().getName().toLowerCase());
		
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
