import java.io.*;
import java.util.Scanner;

/**
This class makes Item objects that a character can use or place in their inventory.
@author Dungeon Crawlers
 */
public class Item 
{


	protected ItemType type;
	protected String name;
	protected int weight;
	protected int value;
	protected int strength;

	/**
	 * Constructor for objects of class Item
	 @param itemType enum of item
	 @param name String name of item
	 @param weight weight of item
	 @param value value of item
	 @param strength strength of item
	 */
	public Item(ItemType itemType, String name, int weight, int value, int strength)
	{
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.strength = strength;
		this.type = itemType;

	}

	/**
	Default constructor for Item object.
	  */
	public Item(){
		this.name = "Default Item";
		this.weight = 0;
		this.value = 0;
		this.strength = 0;
		this.type = ItemType.OTHER;
	}

	/**
	Hydration method for items.
	@param s Scanner object
	@throws NoMoreItemsException if there are no more items to be read.
	  */
	public Item(Scanner s) throws NoMoreItemsException{
		s.nextLine();

		this.name = s.nextLine();
		if(name.equals("-End-") || name.equals(".")){

			this.name = "-End-";
			try{}
			catch(Exception e){
				throw new NoMoreItemsException();

			}
		}
		else{

			String category = s.nextLine();
			if(category.equals("WEAPON")){
				this.type = ItemType.WEAPON;
			}else if(category.equals("ARMOR")){
				this.type = ItemType.ARMOR;
			}else {
				this.type = ItemType.OTHER;
			}

			String thing = s.next();
			this.weight = s.nextInt();

			thing = s.next();
			this.value = s.nextInt();

			thing = s.next();
			this.strength = s.nextInt();
			/*if(name.equals("Book")){
				String message = s.nextLine();
				this = new Book(type, name, weight, value, strength, message);
			}*/
			thing = s.nextLine();
		}
	}

	public class NoMoreItemsException extends Exception{
	}

	/**
	Persistance method for item object.
	@param pw PrintWriter Object
	  */
	public void persist(PrintWriter pw){

		pw.println(name);
		String category = String.valueOf(type);
		pw.println(category);
		pw.print("Weight: ");
		pw.println(weight);
		pw.print("Value: ");
		pw.println(value);
		pw.print("Strength: ");
		pw.println(strength);
		pw.println(".");	
	}

	/**
	Method to get weight of an item.
	@return weight of item as int
	  */
	public int getWeight(){
		return this.weight;
	}

	/**
	Method to get strength of an object.
	@return strength of item as int
	  */
	public int getStrength(){
		return this.strength;
	}

	/**
	Method to get value of an item.
	@return value as an int 
	  */
	public int getValue(){
		return this.value;
	}

	/**
	Method to get the name of an item.
	@return name as String
	  */
	public String getName(){
		return this.name;
	}

	/**
	Method to get enum of item type.
	@return type of item as ItemType enum.
	  */
	public ItemType getType(){
		return this.type;
	}

	/**
	Method for trying to "use" generic items.
	@param player Player object
	@param index integer as index of item in inventory
	  */
	public void use(Player player, int index){
		if(this.name.equals("Book")){
		String page = MessageGenerator.generate();
		System.out.println(page);
		}else {
		System.out.println("You can't use that here!");
		}
	}

	/**
	Method for trying to get a message from a generic item.
	@return String
	  */
	public String getMessage(){
		return "no message";
	}

	/**
	Method for printing item.
	@return String
	  */
	public String toString(){
		return ("This " + this.name + " has a value of " + this.value + ", a strength of " + this.strength + " ,and a weight of " + this.weight + ".");  
	}	

}
