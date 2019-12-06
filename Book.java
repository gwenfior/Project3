import java.io.PrintWriter;
import java.util.Scanner;

public class Book extends Item{

	//usable book class that will generate books that the "use" method will override	

	public Book(ItemType itemType, String name, int weight, int value, int strength){
		super(ItemType.OTHER, name, weight, value, strength);
	}

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
