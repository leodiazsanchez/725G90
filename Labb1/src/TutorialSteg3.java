
public class TutorialSteg3 {

	public static void main(String[] args) {
        Animal.setYear(2019); 
        
        Animal kurre = new Cat("Kurre", 6);
        Animal vilma = new Dog("Vilma", 3);
        
        kurre.introduceYourself();
        vilma.introduceYourself();

        Animal.setYear(2013); 

        kurre.introduceYourself();
        vilma.introduceYourself();
    }

}
