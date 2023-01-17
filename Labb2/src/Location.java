import java.util.ArrayList;
import java.util.Iterator;

public abstract class Location implements Commandable {
	private String name;
	private Boolean visited = false;
	private String description;
	private Location[] paths = new Location[4];
	private ArrayList<NPC> npcs = new ArrayList<NPC>();
	private ArrayList<Item> items = new ArrayList<Item>();

	public Location(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void describeYourself() {

		if (!visited) {
			System.out.println("\n" + description);
			this.visited = true;
		} else {
			System.out.println("\n" + name);
		}

		if (!(this.npcs.isEmpty())) {
			System.out.println("NPCs in this area:");
			for (NPC npc : npcs) {
				npc.describeYourself();
			}
		}

		if (!(this.items.isEmpty())) {
			System.out.println("\nItems in this area:");
			for (Item item : items) {
				item.describeYourself();
			}
		}

		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				if (this instanceof Room) {
					System.out.print("\nThere is a door leading ");
				} else if (this instanceof OutdoorsArea) {
					System.out.print("\nThere is a road leading ");
				}

				switch (i) {
				case 0:
					System.out.print("north.\n");
					break;
				case 1:
					System.out.print("east.\n");
					break;
				case 2:
					System.out.print("south.\n");
					break;
				case 3:
					System.out.print("west.\n");
					break;
				}
			}
		}
	}

	public void doCommand(String command, Player player) {
		String[] commands = command.split(" ");

		if (commands[0].equals("north") && paths[0] != null) {
			player.moveTo(paths[0]);
		}

		else if (commands[0].equals("east") && paths[1] != null) {
			player.moveTo(paths[1]);
		}

		else if (commands[0].equals("south") && paths[2] != null) {
			player.moveTo(paths[2]);
		}

		else if (commands[0].equals("west") && paths[3] != null) {
			player.moveTo(paths[3]);
		}

		if (commands[0].equals("take") && !items.isEmpty()) {

			for (int i = items.size()-1; i >= 0; i--){
			    if (items.get(i).getName().contains(commands[1])){
			    		player.giveItem(items.get(i));
			            items.remove(i);
			    }
			 }

//			for (Item item : items) {
//				if(item.getName().equals(commands[1])) {
//					player.giveItem(item);
//					System.out.println("You picked up: " + item.getName());
//					items.remove(item);
//				}
//			}
		}

	}

	public ArrayList<NPC> getNPCs() {
		// TODO Auto-generated method stub
		return npcs;
	}

	public void addNPC(NPC npc) {
		this.npcs.add(npc);
	}

	public void addNorth(Location location) {
		paths[0] = location;
	}

	public void addEast(Location location) {
		paths[1] = location;
	}

	public void addSouth(Location location) {
		paths[2] = location;

	}

	public void addWest(Location location) {
		paths[3] = location;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

}
