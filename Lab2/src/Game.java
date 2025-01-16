import java.util.*;

public class Game {
	private Scanner keyboard;
	private ArrayList<Location> locations;
	private Player player;
	private ArrayList<Commandable> allCommandableObjects = new ArrayList<>();

	public Game() {
		keyboard = new Scanner(System.in);
		addObjects();
	}

	public void addObjects() {
		locations = new ArrayList<>();

		locations.add(new OutdoorsArea("trading market",
				"You're in a busy trading market, surrounded by vendors calling out their wares, haggling customers and the smell of spices. The sun is shining and vendors are selling various goods, including armors and gear. The market is bustling with people from different cultures. You feel excited to explore and find good deals on the armors and gear you need."));
		locations.add(new OutdoorsArea("town square",
				"You stand in the bustling town square, surrounded by the hustle and bustle of daily life. The sounds of chatter and laughter fill the air, as vendors sell their wares and people go about their business. The sun shines down on the cobblestone streets, adding to the lively atmosphere. You take in the sights and sounds of the square, feeling the energy of the community around you."));
		locations.add(new OutdoorsArea("plains",
				"You're on a hostile plain, with cracked, dry earth and dark, ominous clouds. The wind is cold and fierce, and you feel exposed and vulnerable. The plain is barren and empty, with no sign of shelter. The only sounds are the howling wind and distant thunder."));
		locations.add(new Room("cave",
				"You are in a dim cave, holding a torch. The walls are rough and jagged, and the air is musty and cold. The cave is filled with glittering piles of gold nuggets, some as big as your fist. You feel a mix of excitement and fear as you stand among the treasure, the only sound the dripping water and your own breath.",500));
		locations.add(new Room("boss room",
				"You are standing in a dimly lit room, facing Torbjörn, your boss. Torbjörn is a middle-aged man with a thick beard and a stern expression. He is dressed in a crisp suit and tie, and his arms are crossed over his chest. He towers over you, radiating an air of authority and power. The room is silent, except for the sound of Torbjörn's heavy breathing and the ticking of the clock on the wall. You feel a mix of nervousness and determination as you stand before him, ready to defend your position.",
				200));

		locations.get(0).addNorth(locations.get(1));

		locations.get(1).addSouth(locations.get(0));
		locations.get(1).addEast(locations.get(2));
		locations.get(1).addNorth(locations.get(3));

		locations.get(2).addWest(locations.get(1));
		locations.get(2).addEast(locations.get(4));

		locations.get(3).addSouth(locations.get(1));

		Merchant merchant = new Merchant(locations.get(0));
		merchant.addTrade(new Sword());
		merchant.addTrade(new Helmet());
		
		new Beggar(locations.get(1));

		locations.get(2).addItem(new Elven_Robe());
		new Boar(locations.get(2));

		locations.get(3).addItem(new Shovel());

		new Boss(locations.get(4));

	}

	public void addCommandableObjects(Player player) {
		allCommandableObjects.add(player.getLocation());
		allCommandableObjects.addAll(player.getItems());
	}

	public void run() {
		String name;

		System.out.println("Welcome to the adventure game!\nWhat is your name?");
		name = keyboard.nextLine();
		player = new Player(name, locations.get(1));

		System.out.println("\nHello " + name
				+ ", welcome to this magical world of wonder! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

		while (true) {
			String input;
			Location currentLocation = player.getLocation();
			player.getLocation().describeYourself();

			while (player.getLocation() == currentLocation) {
				allCommandableObjects.clear();
				allCommandableObjects.add(player);
				addCommandableObjects(player);

				System.out.print("\nWhat do you want to do? ");
				input = keyboard.nextLine();
				String[] commands = input.split(" ");

				for (Commandable com : allCommandableObjects) {
					try {
						com.doCommand(commands, player);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Too few arguments given in command!");
					}

				}

				if (player.getHealth() <= 0) {
					System.out.println("You died!");
					System.exit(0);
				}

			}

		}
	}
}