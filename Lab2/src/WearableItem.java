
public abstract class WearableItem extends Item{
	
	private int protection;
	
	public WearableItem(String name, double weight, int price, int protection) {
		super(name, weight, price);
		this.protection = protection;
	}

	public void putOn(Player player) {
		System.out.println("You put on the " + getName());
		player.addHealth(protection);
		player.removeItem(this);
	}
	
	public int getProtection() {
		return protection;
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		
		if ((commands[0].equals("wear") && commands[1].equals(getName()))) {
			putOn(player);
		}
		
	}

}
