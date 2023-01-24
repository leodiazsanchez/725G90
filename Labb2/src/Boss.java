
public class Boss extends Monster {

	public Boss() {
		super("torbjörn", 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		
		if (commands[0].equals("attack") && commands[1].equals(getName())){
			player.removeHealth(getDamage());
		}

	}

}
