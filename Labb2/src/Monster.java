import java.util.Random;

public abstract class Monster extends NPC implements Commandable{
	
	private int damage;

	public Monster(String name, int damage) {
		super(name);
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void interact(Player player) {
		if (new Random().nextInt(10 - 1 + 1) + 1 == 10) {
			player.removeHealth(this.getDamage());
		}

	}

}
