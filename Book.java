
public class Book extends Item{

	//usable book class that will generate books that the "use" method will override	
	private String message;
	
	public Book(ItemType itemType, String name, int weight, int value, int strength, String message){
		super(ItemType.OTHER, name, weight, value, strength);
		this.message = message;
	}

	public void use(Player player){
		System.out.println(this.message);
	}




}
