
public abstract class Item implements Commandable{
	private double weight;
	private String name;
	private int price;
	
	public Item (String name, double weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void describeYourself() {
		System.out.println(name + " (" + weight + " kg)");
	}

	@Override
	public abstract void doCommand(String[] commands, Player player);	
}
