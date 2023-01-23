
public class OutdoorsArea extends Location implements Commandable{

	private String weather;

	public OutdoorsArea(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		super.doCommand(commands, player);
	}

}
