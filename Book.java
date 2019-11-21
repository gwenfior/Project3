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
	s.next();
	this.weight = s.nextInt();
	s.next();
	this.value = s.nextInt();
	s.next();
	this.strength = s.nextInt();
	this.message = "";
	String words = s.nextLine();
	
	while(!words.equals(".")) {
	message = message + words + "\n";
	words = s.nextLine();
	}
}

	public void persist(PrintWriter pw){
		pw.println(name);
		pw.println("ItemType.OTHER");
		pw.println("Weight: " + weight);
		pw.println("Value: " + value);
		pw.println("Strength: " + strength);
		pw.println(message);
		pw.println(".");
	}

	public void use(Player player){
		System.out.println(this.message);
	}




}
