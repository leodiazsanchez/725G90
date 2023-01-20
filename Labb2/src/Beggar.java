
public class Beggar extends Person {

	public Beggar(Location position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String command, Player player) {
		// TODO Auto-generated method stub
		
	}

	public void talk() {
		System.out.println("I'm a " + this.getClass().getName().toLowerCase() + ". Give me money!");
		
	}


}
