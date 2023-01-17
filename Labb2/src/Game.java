import java.util.*;

public class Game {
	private Scanner keyboard;
	private ArrayList<Location> locations;
	private Player player;
	private ArrayList<Commandable> allCommandableObjects;

	public Game() {
		keyboard = new Scanner(System.in);
		locations = new ArrayList<>();
		locations.add(new Room("You are at the pub.",
				"You are sitting in a dimly lit pub in the late 1700s, surrounded by the warm glow of candles and the low murmur of conversation. The air is thick with the smell of ale and tobacco smoke, and the wooden beams overhead are dark with age. You sip your ale slowly, savoring the rich, malty flavor and listening to the locals gossip and tell tall tales. The pub is filled with a mix of people, from merchants and tradesmen to sailors and farmers, all enjoying a respite from their daily lives. The mood is relaxed and convivial, and you feel at ease as you savor your drink and take in the sights and sounds of the lively establishment.\n",
				100));
		locations.add(new OutdoorsArea("You are at the town square.","You stand in the bustling town square, surrounded by the hustle and bustle of daily life. The sounds of chatter and laughter fill the air, as vendors sell their wares and people go about their business. The sun shines down on the cobblestone streets, adding to the lively atmosphere. You take in the sights and sounds of the square, feeling the energy of the community around you."));
		locations.get(0).addNorth(locations.get(1));
		locations.get(0).addNPC(new Person("drunken_man", locations.get(0)));
		locations.get(0).addNPC(new Person("bartender", locations.get(0)));
		locations.get(0).addNPC(new Person("brute", locations.get(0)));
		
		
		locations.get(1).addSouth(locations.get(0));
		locations.get(1).addNPC(new Person("merchant", locations.get(1)));
		locations.get(1).addItem(new WearableItem("helmet", 2.2));
		locations.get(1).addItem(new WearableItem("elven_robe", 3));
		locations.get(1).addItem(new Shovel("shovel",3));
	}

	public void run() {
		String name;

		System.out.println("Welcome to the adventure game!\nWhat is your name?");
		name = keyboard.nextLine();
		player = new Player(name, locations.get(0));

		System.out.println("\nHello " + name
				+ ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

		while (true) {
			String command;
			player.getLocation().describeYourself();
			System.out.print("What do you want to do? ");
			command = keyboard.nextLine();
			player.getLocation().doCommand(command,player);
			
			player.doCommand(command,player);
			
			for (int i = player.getItems().size()-1; i >= 0; i--){
				player.getItems().get(i).doCommand(command,player);
			 }
			
//			for (Item it : player.getItems()) {
//				it.doCommand(command,player);
//			}
			
			for (NPC npc : player.getLocation().getNPCs()) {
				npc.doCommand(command,player);
			}
		}
	}
}