import java.util.ArrayList;

public class Player implements Commandable{
	private String name;
	private Location position;
	private int gold;
	private int health;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Player(String name, Location position) {
		this.name = name;
		this.position = position;
	}

	public void giveItem(Item item) {
		this.items.add(item);
	}

	public void moveTo(Location location) {
		this.position = location;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Location getLocation() {
		return position;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void doCommand(String command, Player player) {
		String[] commands = command.split(" ");

		if (commands[0].equals("items")) {
			if (!items.isEmpty()) {
				System.out.println("\nYou have the following items:");
				for (Item item : items) {
					item.describeYourself();
				}
			} else {
				System.out.println("\nInventory is empty!");
			}

		}

	}

	public void removeItem(Item item) {
		this.items.remove(item);
		
	}

}
