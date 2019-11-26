import java.io.PrintWriter;
import java.util.Scanner;

public class Book extends Item{

	//usable book class that will generate books that the "use" method will override	
	private String message;

	public Book(ItemType itemType, String name, int weight, int value, int strength, String message){
		super(ItemType.OTHER, name, weight, value, strength);
		this.message = message;
	}

	public Book(Scanner s){
		this.name = s.nextLine();
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
		s.nextLine();
	}

	public void persist(PrintWriter pw){
		pw.println(name);
		pw.println("ItemType.OTHER");
		pw.println(weight);
		pw.println(value);
		pw.println(strength);
		pw.println(message);
		pw.println(".");
	}

	public void use(Player player){
		System.out.println(this.message);
	}




}
