import java.io.PrintWriter;
import java.util.Scanner;

//this class creates a player object.
//It contains the variables of the player for it to battle,
//hold items, and wear armor.
//@author Justin
public class Player extends Character {

	private Inventory pack;
	private int goldDiamonds;

	/**This is the player Constructor*/
	public Player(String name, int health){
		super(name, health);	
		pack = new Inventory(200);
		Item initialWeapon = new Item(ItemType.WEAPON, "stick", 1, 0, 5);
		pack.add(initialWeapon);
		pack.setWeapon(initialWeapon);
		pack.add(ItemGenerator.generate());
		pack.add(ItemGenerator.generate());

	}

	public Player(Scanner s){
		this.name = s.nextLine();
		s.next();
		this.health = s.nextInt();
		s.next();
		this.goldDiamonds = s.nextInt();
		s.nextLine();
		s.nextLine();
		s.nextLine();
		s.nextLine();
	}

	public void persist(PrintWriter pw){
		//persisting basic player stuff
		pw.println(name);
		pw.println("Health: " + health);
		pw.println("Gold Diamonds: " + goldDiamonds);
		//begin inventory persistance with 5 hyphens
		pw.println("-----");
		pw.println("Player Inventory");
		pack.persist(pw);
		//finish inventory with 5 hyphens
		pw.println("-----");
		pw.println(".");
		//delimeter to signal that end of player persist method
	}

	//this returns the inventory
	public Inventory getInventory(){
		return pack;
	}

	//this returns the number of diamonds the player has found
	public int getDiamonds(){
		return this.goldDiamonds;
	}

	//this prints out the player's current stats
	public void stats(){
		System.out.println("Name: " + this.name + " | Health: " + this.health);
		if(pack.getEquippedArmor() != null){
			System.out.println("Armor: " + pack.getEquippedArmor().getName() + " | Strength: " + pack.getEquippedArmor().getStrength());
		}
		System.out.println("Weapon: " + pack.getEquippedWeapon().getName() + " | Weapon: " + pack.getEquippedWeapon().getStrength());
		System.out.println("Gold Diamonds Collected: " + goldDiamonds);
	}

	//attack method only in player that returns true if player kills monster, but false if player dies
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
