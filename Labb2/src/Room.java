
public class Room extends Location {

	private int size;

	public Room(String name, String description, int size) {
		super(name, description);
		this.size = size;
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		super.doCommand(commands, player);
	}

}
