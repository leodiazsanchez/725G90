import java.util.ArrayList;

public class Merchant extends Person implements Commandable {

	public Merchant() {
		super("merchant");
		// TODO Auto-generated constructor stub
	}

	ArrayList<Item> trades = new ArrayList<>();

	public void addTrade(Item item) {
		this.trades.add(item);
	}

	public void removeTrade(Item item) {
		this.trades.remove(item);
	}

	@Override
	public void doCommand(String[] commands, Player player) {
		if (commands[0].equals("trades") && commands[1].equals(getName())) {
			intractWith();
		}
		
		if (commands[0].equals("buy")) {
			buy(commands[1],player);
		}
	}

	public void buy(String name, Player player) {
		for (int i = trades.size() - 1; i >= 0; i--) {
			
			if (trades.get(i).getName().equals(name) && (player.getGold() < trades.get(i).getPrice())){
				System.out.println("You do not have enougt gold to buy that item");
			}
			else if (trades.get(i).getName().equals(name) && (player.getGold() >= trades.get(i).getPrice())) {
				player.giveItem(trades.get(i));
				player.removeGold(trades.get(i).getPrice());
				System.out.println("You bought up: " + trades.get(i).getName());
				trades.remove(i);
			}
		}
		
	}
	
	@Override
	public void intractWith() {
		if (trades.isEmpty()) {
			System.out.println("No trades available");
		} else {
			System.out.println("Trades:");
			for (Item item : trades) {
				System.out.println(item.getName() + ": " + item.getPrice() + " gold");
			}
		}

	}

	@Override
	public void interact(Player player) {
		// TODO Auto-generated method stub
		
	}

}