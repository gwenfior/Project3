//this class creates a player object.
//It contains the variables of the player for it to battle,
//hold items, and wear armor.
//@author Justin
public class Player {

	private Inventory pack;
	private String name;
	private int health;
	private int goldDiamonds;
	
	/**This is the player Constructor*/
	public Player(String name, int health){

		pack = new Inventory(200);
		Item initialWeapon = new Item(ItemType.WEAPON, "stick", 1, 0, 5);
		pack.add(initialWeapon);
		pack.setWeapon(initialWeapon);
		pack.add(ItemGenerator.generate());
		pack.add(ItemGenerator.generate());
		this.name = name;
		this.health = health;

	}
	
	//this returns the inventory
	public Inventory getInventory(){
		return pack;
	}
	
	//this returns the name
	public String getName(){
		return this.name;
	}
	
	//this returns the health
	public int getHealth(){
		return this.health;
	}
	
	//this returns the number of diamonds the player has found
	public int getDiamonds(){
		return this.goldDiamonds;
	}
	
	//this prints out the player's current stats
	public void stats(){
		System.out.println("Name: " + name + " | Health: " + health);
		if(pack.getEquippedArmor() != null){
			System.out.println("Armor: " + pack.getEquippedArmor().getName() + " | Strength: " + pack.getEquippedArmor().getStrength());
		}
		System.out.println("Weapon: " + pack.getEquippedWeapon().getName() + " | Weapon: " + pack.getEquippedWeapon().getStrength());
		System.out.println("Gold Diamonds Collected: " + goldDiamonds);
	}

	//attack method only in player that returns true if player kills monster, but false if player dies
	public boolean attack(Monster monster){
		boolean result = true;
		int monsterHealth = monster.getHealth();
		if(pack.getEquippedArmor() != null){
			this.health = health + pack.getEquippedArmor().getStrength();
		}
		while(this.health >= 0 && monsterHealth >= 0){

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

		}	
		return result;
	}//end attack()

public void setHealth(int health){
this.health = health;
}

}//end player class
