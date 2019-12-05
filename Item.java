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

	public Item(){
		this.name = "Default Item";
		this.weight = 0;
		this.value = 0;
		this.strength = 0;
		this.type = ItemType.OTHER;
	}

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
		if(this.name.equals("Book")){
		String page = MessageGenerator.generate();
		System.out.println(page);
		}else {
		System.out.println("You can't use that here!");
		}
	}
	public String getMessage(){
		return "no message";
	}

	//allows items to be printed 
	public String toString(){
		return ("This " + this.name + " has a value of " + this.value + ", a strength of " + this.strength + " ,and a weight of " + this.weight + ".");  
	}	

}
