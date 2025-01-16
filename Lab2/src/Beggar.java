
public class Beggar extends Person implements Commandable {

	public Beggar(Location location) {
		super("beggar", location);
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		if (commands[0].equals("talk") && commands[1].equals(getName())) {
			System.out.println("I'm a " + getName() + ". Please give some coins");
		} else if (commands[0].equals("give") && commands[1].equals("coins") && commands[2].equals(getName())) {
			if (player.getGold() >= 10) {
				player.removeGold(10);
				System.out.println("You gave the " + getName() + " 10 gold");
			} else {
				System.out.println("You do not have enough gold");
			}

		}

	}


}
