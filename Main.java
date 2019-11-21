// This is the main method that allows a user to interact with the program. It creates a menu and then calls the methods specified by the user.
// @author Gwen

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name;

		System.out.println("What would you like to name your character?");
		name = input.nextLine();
		Player player = new Player(name, 200);
		Room newRoom = new Room(player);
		System.out.println(" ");
		System.out.println("Welcome to Dungeon Crawler!");
		System.out.println("---------------------------");
		System.out.println("You are a scavenger on a mission to find the rare magical Gold Diamond.");  
		System.out.println("This diamond is hidden deep in a dungeon guarded by vicious trolls."); 
		System.out.println("Your job is to defeat the trolls and obtain 10 pieces of the Gold Diamond to make it complete. Good luck!");
		System.out.println("P.S. watch out for portals!! being by them will take you to a new room.");
		System.out.println("---------------------------");
		newRoom.generateRoom();
		String command  = "";
		while(!command.equals("q")) {
			try{
				Menu.printMenu();
			}catch(InterruptedException e){
				
			}
			System.out.println("Please enter a command:");
			command  = input.next();

			switch(command) {
				case "w":
					newRoom.movePlayer(1,0);
					break;
				case "s":
					newRoom.movePlayer(-1,0);
					break;
				case "a":
					newRoom.movePlayer(0,1);
					break;
				case "d":
					newRoom.movePlayer(0,-1);
					break;
				case "p":
					player.getInventory().print();
					break;
				case "e":
					player.getInventory().equipWeapon();
					break;
				case "r":
					player.getInventory().equipArmor();
					break;
				case "f":
					player.getInventory().drop();
					break;
				case "i":
					player.stats();
					break;
				case "u":
					Item item = player.getInventory().getItem();
					int index = player.getInventory().getIndex(item);
					item.use(player, index);	
					break;
				case "q":
					System.out.println("Your progress will not be saved, you're quitting with " + player.getDiamonds() + " gold diamonds.");
					System.out.println("Bye!");
					break;
				default:
	                System.out.println("No match.");
					break;
			}
			if(player.getDiamonds() == 10){
				System.out.println("You won!!");
				System.out.println("If you want to keep playing, go forth. But if you want to leave, hit q. Your progress will not be saved.");
			}
		}//end while



	}//end main method	
}//end main class
