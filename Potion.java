import java.util.Random;
public class Potion extends Item{

	Random rng = new Random();
	int rand = rng.nextInt(15)+ 5;

	//a usable potion class
	private ItemType type; 
	private int strength = rand;

	public Potion(ItemType itemType, String name, int weight, int value, int strength){
		super(ItemType.OTHER, name, weight, value,strength);

	}

	public void use(Player player){
		//add the value of the strength of the potion to the players health

		player.setHealth(player.getHealth() + this.strength);

	}


}
