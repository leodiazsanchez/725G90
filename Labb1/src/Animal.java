
public class Animal {

	private static int currentYear = 2019;
	private String name;
	private int birthyear;
	private Toy toy;
	private Animal friend;

	public Animal(String name, int age) {
		this.name = name;
		this.birthyear = Animal.currentYear - age;
	}

	public int getAge() {
		return Animal.currentYear - this.birthyear;
	}
	
	public String getName() {
		return name;
	}
	
	public void setFriend(Animal animal) {
		this.friend = animal;
	}
	
	
	public void print() {
	
	   if (friend != null) {
	       System.out.println("Här är uppgifter om min kompis:");
	       friend.introduceYourself();
	    } else {
	        System.out.println("Jag har ingen kompis.");
	    }
	
	}

	public void introduceYourself() {
		System.out.println(name);
	}
	
	public static void setYear(int year) {
		currentYear = year;
	}

	public Toy getToy() {
		return toy;
	}

	public void addToy(Toy toy) {
		this.toy = toy;
	}
}
