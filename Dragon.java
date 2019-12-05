import java.util.ArrayList;
import java.util.Random;

public class Dragon extends Monster{

	private ArrayList<String> names;
 
	public Dragon(String name, int health, int strength){
	super(name, new Random().nextInt(45)+20, new Random().nextInt(50)+25);
	/*names = new ArrayList<String>();
	names.add("Silver Dragon");
	names.add("Lightning Dragon");
	names.add("Fire Dragon");
	names.add("Ice Dragon");
	names.add("Wind Dragon");
	names.add("Poison Dragon");
	names.add("Water Dragon");
	names.add("Skeleton Dragon");
	name = names.get(1);
	*/
	}









}
