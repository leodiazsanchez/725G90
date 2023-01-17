
public class Shovel extends Tool implements Commandable{

	public Shovel(String name, double weight) {
		super(name,weight);
	}
	
	public void doCommand(String command,Player player) {
		String[] commands = command.split(" ");
		
		if (commands[0].equals("dig")) {
			System.out.println("You dig a hole in the ground, but you find nothing here.");
		}
	}
	
}