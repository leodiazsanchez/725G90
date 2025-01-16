
public class Dog extends Animal {

	public Dog(String name, int age) {
		super(name, age);
	}

	public void introduceYourself() {
		System.out.println("Woof. Jag är en hund som heter " + getName() + ".");
		System.out.println("Jag är " + getAge() + " är gammal.");
	}
	
	public String makesound() {
		return "Woof woof.";
	}

}
