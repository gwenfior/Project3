import java.util.ArrayList;
import java.util.Random;

/**
  This class is a subclass of Monster that makes a Dragon monster.
  @author Dungeon Crawlers
  */
public class Dragon extends Monster{

	private ArrayList<String> names;
	private static int nextDragon = 0; 
	/**
	  Constructor for Dragon.
	  @param name String
	  @param health int
	  @param strength int
	  */
	public Dragon(String name, int health, int strength){
		super(name, new Random().nextInt(45)+20, new Random().nextInt(50)+25);

	}

	public String getName(){

		return this.name;
	}

	public void setName(){

		names = new ArrayList<String>();
		names.add("Silver Dragon");
		names.add("Lightning Dragon");
		names.add("Fire Dragon");
		names.add("Ice Dragon");
		names.add("Wind Dragon");
		names.add("Poison Dragon");
		names.add("Water Dragon");
		names.add("Skeleton Dragon");
		names.add("Metal Dragon");
		names.add("Rock Dragon");
		this.name = names.get(nextDragon);
		names.remove(nextDragon);
		nextDragon++;

	}


}
