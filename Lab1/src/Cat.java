
public class Cat extends Animal {
	Cat(String name, int age) {
		super(name, age); // Animals konstruktor anropas

	}

	public void introduceYourself() {
		System.out.println("Mjau. Jag �r en katt som heter " + getName() + ".");
		System.out.println("Jag �r " + getAge() + " �r gammal.");
	}

	public String makesound() {
		return "Mjau maju.";
	}

}
