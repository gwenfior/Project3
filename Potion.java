import java.util.Random;
import java.util.ArrayList;
public class Potion extends Item{
	
	//a usable potion class 

	public Potion(ItemType itemType, String name, int weight, int value, int strength){	
		super(ItemType.OTHER, name, weight, value,new Random().nextInt(15)+5);

	}

	public void use(Player player, int index){
		//add the value of the strength of the potion to the players health

		player.setHealth(player.getHealth() + this.strength);
		System.out.println(this.strength + " has been added to your health.");
		player.getInventory().delete(index);
	}


}
