import java.io.PrintWriter;
import java.util.Scanner;

/**
This class creates a player object that inherits from Character, it has a name, health, inventory, and can wear armor and use weapons.
@author Dungeon Crawlers
  */
public class Player extends Character {

	private Inventory pack;
	private int goldDiamonds;

	/**
	Constructor for Player object.
	@param name String
	@param health int
	  */
	public Player(String name, int health){
		super(name, health);	
		pack = new Inventory(200);
		Item initialWeapon = new Item(ItemType.WEAPON, "stick", 1, 0, 5);
		pack.add(initialWeapon);
		pack.setWeapon(initialWeapon);
		Item initialArmor = new Item(ItemType.ARMOR, "clothes", 0,0,0);
		pack.setArmor(initialArmor);
		pack.add(ItemGenerator.generate());
		Item book = new Item(ItemType.OTHER, "Book", 1,4,6);
		pack.add(book);
		pack.add(new Book(ItemType.OTHER, "Book", 5, 10, 0));
	}

	/**
	Hydration method for a Player object.
	@param s Scanner object
	  */
	public Player(Scanner s){
		this.name = s.nextLine();
		System.out.println("name: " + name);
		String thing = s.next();
		this.health = s.nextInt();
		System.out.println("health: " + health);
		//thing = nextLine();
		thing = s.next() + s.next();
		this.goldDiamonds = s.nextInt();	
		System.out.println("Gold Diamonds: " + goldDiamonds);
		pack = new Inventory(s);
		//thing = s.nextLine();
	}

	/**
	Persistance method for a Player object.
	@param pw PrintWriter
	  */
	public void persist(PrintWriter pw){
		//persisting basic player stuff
		pw.println(name);
		pw.print("Health: ");
		pw.println(health);
		pw.print("Gold Diamonds: ");
		pw.println(goldDiamonds);
		pw.println("-----");
		//begin inventory persistance with 5 hyphens
		pack.persist(pw);

	}

	/**
	Method for getting Inventory.
	@return Player's inventory
	  */
	public Inventory getInventory(){
		return pack;
	}

	/**
	Method for getting number of Gold Diamonds a Player has.
	@return int
	  */
	public int getDiamonds(){
		return this.goldDiamonds;
	}

	/**
	Method for printing out Player's current stats.
	  */
	public void stats(){
		System.out.println("Name: " + this.name + " | Health: " + this.health);
		if(pack == null){
			System.out.println("Inventory object is null");
		}

		if(pack.getEquippedArmor() != null){
			System.out.println("Armor: " + pack.getEquippedArmor().getName() + " | Strength: " + pack.getEquippedArmor().getStrength());
		}
		System.out.println("Weapon: " + pack.getEquippedWeapon().getName() + " | Weapon: " + pack.getEquippedWeapon().getStrength());
		System.out.println("Gold Diamonds Collected: " + goldDiamonds);
	}

	/**
	Method for Player to attack a monster, returns true if they win and false if they die.
	@param monster Monster object
	@return boolean
	  */
	public boolean attack(Monster monster){
		Scanner sc = new Scanner(System.in);
		boolean result = true;
		String choice = "a";
		int monsterHealth = monster.getHealth();
		if(pack.getEquippedArmor() != null){
			this.health = this.health + pack.getEquippedArmor().getStrength();
		}
		while(this.health >= 0 && monsterHealth >= 0 && !choice.equals("r")){

			//player attacks monster
			monsterHealth -= this.pack.getEquippedWeapon().getStrength();
			System.out.println(this.name + " has hit the " + monster.getName() + " for " + this.pack.getEquippedWeapon().getStrength() + " damage.");
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {

			}	
			if(monsterHealth <= 0){
				result = true;
				System.out.println(monster.getName()+ " has been killed by "+ this.name + ".");
				goldDiamonds++;
				return result;
			}
			//monster attacks player	
			this.health -= monster.getStrength();
			System.out.println(monster.getName() + " has hit " + this.name + " for " + monster.getStrength() + " damage.");
			if(this.health <= 0){
				result = false;
				System.out.println(this.name + " has been killed by the " + monster.getName());
				return result;

			}
			System.out.println("would you like to keep battling? (a - attack) (r - run)");
			choice = sc.next();
			if(choice.equals("r")){
				System.out.println("You ran away!");
				result = false;
			}

		}	
		return result;
	}//end attack()


}//end player class
