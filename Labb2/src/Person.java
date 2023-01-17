
public class Person extends NPC {

	public Person(String name, Location position) {
		super(name, position);
		// TODO Auto-generated constructor stub
	}

	public void describeYourself() {
		System.out.println(name);
	}

	public void interactWith() {
		System.out.println(name + ": Hello there!");
	}

	@Override
	public void doCommand(String command, Player player) {
		String[] commands = command.split(" ");

		if (commands.length == 2 && (commands[0].equals("talk") && commands[1].equals(name))) {
			interactWith();
		}

	}

}
