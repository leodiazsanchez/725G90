
public class Room extends Location{
	
	private int size;
	
	public Room(String name, String description, int size) {
		super(name, description);
		this.size = size;
	}

	@Override
	public void doCommand(String command, Player player) {
		super.doCommand(command, player);
	}

	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}




}
