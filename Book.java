import java.io.PrintWriter;
import java.util.Scanner;

/**
Provides a book object that can be used, and extends from Item.
@author Dungeon Crawlers
  */
public class Book extends Item{

	//usable book class that will generate books that the "use" method will override	
	private String message;
	
	/**
	Creates a book item.
	@param itemType Other item type
	@param name Name of book
	@param weight Weight of book
	@param value Value of book
	@param strength strength of book
	@param message String containing book message
	  */
	public Book(ItemType itemType, String name, int weight, int value, int strength, String message){
		super(ItemType.OTHER, name, weight, value, strength);
		this.message = message;
	}

	/**
	Hydration method for a book.
	@param s Scanner object
	@throws NoMoreItemsException if there are no more items
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
	Perstistance method for a book.
	@param pw PrintWriter object
	  */
	public void persist(PrintWriter pw){
		pw.println("Book");
		pw.println("ItemType.OTHER");
		pw.print("Weight: ");
		pw.println(weight);
		pw.print("Value: ");
		pw.println(value);
		pw.print("Strength: ");
		pw.println(strength);
		pw.println(".");
	
	}

	/**
	Method that returns a book's message.
	@return a book's message as a string
	  */
	public String getMessage(){
	return this.message;
	}

	/**
	Use method overridden from Item.
	@param player a player object
	@param index index of book in inventory
	  */
	public void use(Player player, int index){
		String words = player.getInventory().getItem(index).getMessage();
	}




}
