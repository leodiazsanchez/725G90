
public class Butterfly extends Animal {

	public Butterfly(String name, int age) {
		super(name, age);
	}
	
	public void introduceYourself() {
		System.out.println("Hej, jag �r fj�rlien " + getName() + ".");
		System.out.println("Jag �r " + getAge() + "�r gammal");
	}
	
	public void fly() {
		System.out.println("Flax flax, jag flaxar med vingarna");
	}

}
