
public class Bird extends Animal {

	public Bird(String name, int age) {
		super(name, age);

		// TODO Auto-generated constructor stub
	}

	public void introduceYourself() {
		System.out.println("Pip pip! Jag är en fågel vid namn " + getName() + ".");
		System.out.println("Jag är " + getAge() + "år gammal");
	}

	public String makesound() {
		return "Pip pip";
	}

	public void fly() {
		System.out.println("Flax flax, jag flaxar med vingarna");
	}

}
