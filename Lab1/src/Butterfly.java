
public class Butterfly extends Animal {

	public Butterfly(String name, int age) {
		super(name, age);
	}
	
	public void introduceYourself() {
		System.out.println("Hej, jag är fjärlien " + getName() + ".");
		System.out.println("Jag är " + getAge() + "år gammal");
	}
	
	public void fly() {
		System.out.println("Flax flax, jag flaxar med vingarna");
	}

}
