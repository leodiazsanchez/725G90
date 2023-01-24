
public class Shovel extends Tool implements Commandable{
	
	private boolean goldFound = false;

	public Shovel() {
		super("shovel",3, 300);
	}
	
	public void doCommand(String[] commands,Player player) {
		
		if (commands[0].equals("dig") && player.getLocation().getName().equals("cave") && !goldFound) {
			System.out.println("You dig a hole and find some gold");
			goldFound = true;
			player.addGold(500);
		}
		
		else if (commands[0].equals("dig")){
			System.out.println("You dig a hole in the ground, but you find nothing here.");
		}
	}
	
}