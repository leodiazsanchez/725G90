
public class Dog extends Animal {

	public Dog(String name, int age) {
		super(name, age);
	}

	public void introduceYourself() {
		System.out.println("Woof. Jag �r en hund som heter " + getName() + ".");
		System.out.println("Jag �r " + getAge() + " �r gammal.");
	}
	
	public String makesound() {
		return "Woof woof.";
	}

}
