
public abstract class Monster extends NPC{

	public Monster(Location position) {
		super(position);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(Player player) {
		player.setHealth(player.getHealth() - 1); 
	}

	@Override
	public void doCommand(String command, Player player) {
		// TODO Auto-generated method stub
		
	}

}
