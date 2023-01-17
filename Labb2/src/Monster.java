
public class Monster extends NPC{

	public Monster(String name, Location position) {
		super(name, position);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Player player) {
		player.setHealth(player.getHealth() - 1); 
	}

}
