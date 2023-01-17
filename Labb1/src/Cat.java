
public class Cat extends Animal {
	Cat(String name, int age) {
		super(name, age); // Animals konstruktor anropas

	}
	
	public void introduceYourself() {
	    System.out.println("Mjau. Jag är en katt som heter " + getName() + ".");
	    System.out.println("Jag är " + getAge() + " är gammal.");
	}
}
