//This class creates a monster object.
//It holds the variables necessary for a monster to do battles.
//@author Justin
public class Monster {

	private int strength;	
	private int health;
	private String name;
	
	/**This is the Constructor for a Monster**/
	public Monster(String name, int health, int strength){

		this.health = health;
		this.name = name;
		this.strength = strength;

	}
	
	//when the monster dies, it must drop an item
	public Item dropItem(){
		Item thing  = null;
		thing = ItemGenerator.generate();
		return thing;
	}
	
	//this returns the monsters strength
	public int getStrength(){
		return this.strength;
	}
	
	//this returns the monsters health
	public int getHealth(){
		return this.health;
	}

	//this returns the monsters name
	public String getName(){
		return this.name;
	}

}
