
public class Shovel extends Tool implements Commandable{

	public Shovel() {
		super("shovel",3, 300);
	}
	
	public void doCommand(String[] commands,Player player) {
		
		if (commands[0].equals("dig")) {
			System.out.println("You dig a hole in the ground, but you find nothing here.");
		}
	}
	
}