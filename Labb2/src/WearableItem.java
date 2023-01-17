
public class WearableItem extends Item{
	
	public WearableItem(String name, double weight) {
		super(name, weight);
	}

	public void putOn(Player player) {
		System.out.println("You put on the " + name);
		player.removeItem(this);
	}

	@Override
	public void doCommand(String command, Player player) {
		String[] commands = command.split(" ");
		
		if (commands.length == 2 && (commands[0].equals("wear") && commands[1].equals(name))) {
			putOn(player);
		}
		
	}

}
