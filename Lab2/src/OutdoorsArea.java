import java.util.Random;

public class OutdoorsArea extends Location implements Commandable {

	private String[] weatherConditions = { "sunny", "cloudy", "rainy", "snowy", "windy" };

	public OutdoorsArea(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printLocationVariable() {
		Random rand = new Random();

		int randomNum = rand.nextInt(weatherConditions.length);
		String weather = weatherConditions[randomNum];
		System.out.println("The weather is currently " + weather + ".");

	}

}
