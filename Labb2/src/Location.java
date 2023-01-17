import java.util.ArrayList;

public abstract class Location implements Commandable {
	private String name;
	private Boolean visited = false;
	private String description;
	private Location[] paths = new Location[4];
	private ArrayList<NPC> npcs = new ArrayList<NPC>();

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

		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				if (this instanceof Room) {
					System.out.print("There is a door leading ");
				} else if (this instanceof OutdoorsArea) {
					System.out.print("There is a road leading ");
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
	}

	public ArrayList<NPC> getNPCs() {
		// TODO Auto-generated method stub
		return npcs;
	}

	public void addNorth(Location location) {
		paths[0] = location;
	}

	public void addSouth(Location location) {
		paths[2] = location;

	}

}
