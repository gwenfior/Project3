import java.util.Random;
import java.util.ArrayList;

/**
This class is a subclass of Item that makes a health potion for the Player to use.
@author Dungeon Crawlers
  */
public class Potion extends Item{

	/**
	Constructor for Potion.
	@param itemType enum of item type
	@param name String
	@param weight int
	@param value int
	@param strength int
	  */
	public Potion(ItemType itemType, String name, int weight, int value, int strength){	
		super(ItemType.OTHER, name, weight, value,new Random().nextInt(15)+5);

	}

	/**
	Overridden method for using a Potion.
	@param player Player Object
	@param index int
	  */
	public void use(Player player, int index){
		//add the value of the strength of the potion to the players health

		player.setHealth(player.getHealth() + this.strength);
		System.out.println(this.strength + " has been added to your health.");
		player.getInventory().delete(index);
	}


}
