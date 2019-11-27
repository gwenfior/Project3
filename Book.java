import java.io.PrintWriter;
import java.util.Scanner;

public class Book extends Item{

	//usable book class that will generate books that the "use" method will override	
	private String message;

	public Book(ItemType itemType, String name, int weight, int value, int strength, String message){
		super(ItemType.OTHER, name, weight, value, strength);
		this.message = message;
	}

	public Book(Scanner s)throws NoMoreItemsException{
		this.name = "Book";
		s.nextLine();
		if(name.equals("-End-")){
		throw new NoMoreItemsException();
		}
		this.type = ItemType.OTHER;
		s.nextLine();
		this.weight = s.nextInt();
		this.value = s.nextInt();
		this.strength = s.nextInt();
		this.message = "";
		String words = s.nextLine();

		while(!words.equals(".")) {
			message = message + words + "\n";
			words = s.nextLine();
		}
			
	}

	public void persist(PrintWriter pw){
		pw.println("Book");
		pw.println("ItemType.OTHER");
		pw.print("Weight: ");
		pw.println(weight);
		pw.print("Value: ");
		pw.println(value);
		pw.print("Strength: ");
		pw.println(strength);
		pw.println(message);
		pw.println(".");
	
	}

	public String getMessage(){
	return this.message;
	}

	public void use(Player player, int index){
		String words = player.getInventory().getItem(index).getMessage();
	}




}
