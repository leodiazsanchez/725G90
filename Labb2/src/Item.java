
public class Item implements Commandable{
	private double weight;
	private String name;
	private int price;
	
	
	public void describeYourself() {
		System.out.println(name);
	}

	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}
}
