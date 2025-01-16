import java.util.ArrayList;

public class House {

	private ArrayList<Animal> animalList = new ArrayList<Animal>();

	public void addAnimal(Animal animal) {
		animalList.add(animal);
	}

	public void print() {
		System.out.println("Följande djur finns i huset:");

		for (Animal animal : animalList) {
			animal.print();
		}
	}

}
