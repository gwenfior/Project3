import java.io.*;
//A class that holds the methods to get information for the Item Class
//it also holds the variables for Item objects
//@author Justin
public class Item 
{


	private ItemType type;
	private String name;
	private int weight;
	private int value;
	private int strength;

	/**
	 * Constructor for objects of class Item
	 */
	public Item(ItemType itemType, String name, int weight, int value, int strength)
	{
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
		this.type = itemType;

	}

	//gets the weight of an object
	public int getWeight(){
		return this.weight;
	}
	//gets strength of an object
	public int getStrength(){
	return this.strength;
	}

	//get the value of, or what an item can be solved for
	public int getValue(){
		return this.value;
	}	
	//get the name of the object
	public String getName(){
		return this.name;
	}
	//get the enum of the object
	public ItemType getType(){
		return this.type;
	}

	//allows items to be printed 
	public String toString(){
		return ("This " + this.name + " has a value of " + this.value + ", a strength of " + this.strength + " ,and a weight of " + this.weight + ".");  
	}
	//use method for generic objects that can't be used by the player	
	public void use(){
	System.out.println("You can't use that item here");
	}

}
