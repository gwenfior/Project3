import java.io.*;
import java.util.Scanner;
//A class that holds the methods to get information for the Item Class
//it also holds the variables for Item objects
//@author Justin
public class Item 
{


	protected ItemType type;
	protected String name;
	protected int weight;
	protected int value;
	protected int strength;

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

	public Item(Scanner s){
		this.name = s.nextLine();
		String category = s.nextLine();
		if(category.equals("ARMOR")){
			this.type = ItemType.ARMOR;
		}else if (category.equals("WEAPON")){
			this.type = ItemType.WEAPON;
		}else {
			this.type = ItemType.OTHER;
		}
		s.next();
		this.weight = s.nextInt();
		s.next();
		this.value = s.nextInt();
		s.next();
		this.strength = s.nextInt();
		
	}

	public void persist(PrintWriter pw){

		pw.println(name);
		String category = String.valueOf(type);
		pw.println(category);
		pw.println("Weight: " + weight);
		pw.println("Value: " + value);
		pw.println("Strength: " + strength);
		//delimeter is a period signaling the end of all the information for this Item
		pw.println(".");
		pw.close();
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

	//use method for generic objects that can't be used by the player
	public void use(Player player, int index){
		System.out.println("You can't use that here!");
	}

	//allows items to be printed 
	public String toString(){
		return ("This " + this.name + " has a value of " + this.value + ", a strength of " + this.strength + " ,and a weight of " + this.weight + ".");  
	}	

}
