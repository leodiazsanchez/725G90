
public class Beggar extends Person implements Commandable{

	public Beggar() {
		super("beggar");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		if (commands[0].equals("talk") && commands[1].equals(getName())) {
			intractWith();
		}

	}

	@Override
	public void intractWith() {
		System.out.println("I'm a " + getName() + ". Please give some coins");
		
	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		
	}

}
