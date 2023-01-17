
public abstract class Item implements Commandable{
	protected double weight;
	protected String name;
	private int price;
	
	public Item (String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public void describeYourself() {
		System.out.println(name + " (" + weight + " kg)");
	}

	@Override
	public void doCommand(String command, Player player) {
		
	}
}
