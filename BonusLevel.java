import java.util.Scanner;
import java.util.Random;

public class BonusLevel{
	Player player1;
	Dragon dragon;

	public BonusLevel(Player player){
		player1 = player;
	}

	public boolean bonusBattle(){
		dragon = new Dragon();
		dragon.setName();
		Scanner sc = new Scanner(System.in);
		boolean result = true;
		String choice = "a";
		System.out.println("You have encountered a " + dragon.getName() + "!");
		int monsterHealth = dragon.getHealth();
		if(pack.getEquippedArmor() != null){
			int health  = player1.getHealth() + pack.getEquippedArmor().getStrength();
			player1.setHealth(health);
		}
		while(player1.getHealth() >= 0 && monsterHealth >= 0 && !choice.equals("r")){

			//player attacks monster
			monsterHealth -= player1.getInventory().getEquippedWeapon().getStrength();
			System.out.println(player1.getName()+ " has hit the " + dragon.getName() + " for " + 
					player1.getInventory().getEquippedWeapon().getStrength() + " damage.");
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {

			}	
			if(monsterHealth <= 0){
				result = true;
				System.out.println(dragon.getName()+ " has been killed by "+ player1.getName() + ".");
				return result;
			}
			//monster attacks player	
			health -= monster.getStrength();
			player1.setHealth(health);
			System.out.println(dragon.getName() + " has hit " + player1.getName() + " for " + dragon.getStrength() + " damage.");
			if(player.getHealth() <= 0){
				result = false;
				System.out.println(player1.getName() + " has been killed by the " + dragon.getName());
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
	}//end BonusBattle

	public void moveBonus(){
		Random rand = new Random();
		randomNum = rand.nextInt(10);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		
		if(randomNum >= 0 && randomNum < 6){
			System.out.println("The spot you tried to go to was empty so you moved successfully!");

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		}
		else if(randomNum >= 6 && randNum < 9){
			System.out.println("You hit a wall, try to move again.");
		}
		else if(randomNum >= 9){
			System.out.prinln("You ran into something scaly cold...");
			this.BonusBattle();
		}
		else{
			System.out.println("Something loud crashed infront of you!! don't move there.");
		}
	}//end moveBonus



}//end bonusBattle
