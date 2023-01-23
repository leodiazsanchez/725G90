
public class Sword extends Weapon implements Commandable {

	public Sword() {
		super("sword", 2, 500, 10);
		// TODO Auto-generated constructor stub
	}

	public void doCommand(String[] commands, Player player) {

		if (commands[0].equals("kill")) {

			for (int i = player.getLocation().getNPCs().size() - 1; i >= 0; i--) {
				if (player.getLocation().getNPCs().get(i).getClass().getName().toLowerCase().equals(commands[1])) {
					System.out.println("You killed: " + player.getLocation().getNPCs().get(i).getName());
					player.getLocation().getNPCs().remove(i);
				}
			}

		}
	}

}
