
public class Weapon extends Item implements Commandable{
	
	private int damage;
	
	public Weapon(String name, double weight, int price, int damage) {
		super(name, weight, price);
		this.damage = damage;
		// TODO Auto-generated constructor stub
	}
	
	public int getDamage() {
		return this.damage;
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		// TODO Auto-generated method stub
		
	}

}
