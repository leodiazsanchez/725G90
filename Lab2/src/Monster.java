
public abstract class Monster extends NPC implements Commandable {

	private int damage;
	private int hp;

	public Monster(String name, Location location, int hp, int damage) {
		super(name, location);
		this.damage = damage;
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void doCommand(String[] commands, Player player) {
		if (commands[0].equals("attack") && commands[1].equals(getName())) {
			hp -= player.getDamage();
			if (hp <= 0) {
				System.out.println("You killed " + getName());

				for (int i = this.getPosition().getNPCs().size() - 1; i >= 0; i--) {
					if (this.getPosition().getNPCs().get(i) == this) {
						getPosition().getNPCs().remove(i);
					}
				}

				if (this instanceof Boss) {
					System.out.println(
							"Congratulations! You triumphantly win the game, a feeling of accomplishment wash over you as you celebrate your victory.");
					System.exit(0);
				}

				player.getLocation().getNPCs().remove(this);
			} else {
				System.out.println("You dealt " + player.getDamage() + " damage to " + getName());
				System.out.println(getName() + " attacked you back for " + getDamage() + " damage");
				player.removeHealth(getDamage());
			}

		}

	}

}
