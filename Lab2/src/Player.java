import java.util.ArrayList;

public class Player implements Commandable {
	private String name;
	private Location position;
	private int gold = 500;
	private int health = 10;
	private int damage = 5;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Player(String name, Location position) {
		this.name = name;
		this.position = position;
	}

	public void giveItem(Item item) {
		this.items.add(item);
		if(item instanceof Weapon) {
			this.damage = (((Weapon) item).getDamage());
			System.out.println("Your damage per hit is now: " + ((Weapon) item).getDamage());
		}
	}

	public void moveTo(Location location) {
		this.position = location;
	}

	public int getHealth() {
		return health;
	}

	public void addHealth(int health) {
		this.health += health;
	}

	public void removeHealth(int health) {
		this.health -= health;
	}

	public Location getLocation() {
		return position;
	}

	public int getGold() {
		return gold;
	}

	public void addGold(int gold) {
		this.gold += gold;
	}

	public void removeGold(int gold) {
		this.gold -= gold;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void doCommand(String[] commands, Player player) {

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

		else if (commands[0].equals("gold")) {
			System.out.println("You have " + gold + " gold.");
		}

		else if (commands[0].equals("health")) {
			System.out.println("Current HP: " + health);
		}

	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int getDamage() {
		return damage;
	}
}
