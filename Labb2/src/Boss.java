
public class Boss extends Monster {

	public Boss() {
		super("torbj�rn", 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		
		if (commands[0].equals("attack") && commands[1].equals(getName())){
			player.removeHealth(getDamage());
		}

	}

}