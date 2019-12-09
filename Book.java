import java.io.PrintWriter;
import java.util.Scanner;

/**
This class creates a Book Item obejct that inherits from Item.
It overrides the generic use method and returns a message from a page inside the book.
@author Dungeon Crawlers
  */
public class Book extends Item{

	/**
	Constructor for Book object.
	@param itemType enum for type of Item
	@param name String
	@param weight int
	@param value int
	@param strength int
	  */
	public Book(ItemType itemType, String name, int weight, int value, int strength){
		super(ItemType.OTHER, name, weight, value, strength);
	}

	/**
	Hydration method for Book obejcts.
	@param s Scanner object
	@throws NoMoreItemsException if there are no more items to be read in
	  */
	public Book(Scanner s)throws NoMoreItemsException{
		this.name = "Book";
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
		String message = s.nextLine();
		thing = s.nextLine();	
	}

	/**
	Peristance method for saving Book obejects.
	@param pw PrintWriter object
	  */
	public void persist(PrintWriter pw){
		pw.println("Book");
		pw.println("OTHER");
		pw.print("Weight: ");
		pw.println(weight);
		pw.print("Value: ");
		pw.println(value);
		pw.print("Strength: ");
		pw.println(strength);
		pw.println(".");
	
	}


}
