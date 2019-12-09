import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;

/**
This is the main method of the game, and it calls all the methods from the rest of the program.
@author Dungeon Crawlers
  */
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name;
		Player player = new Player("default", 200);
		Room newRoom = new Room(player);
		boolean givenKey = false;
		boolean usedKey = false;

		System.out.println(" ");
		System.out.println("Welcome to Dungeon Crawler!");
		System.out.println("---------------------------");
		System.out.println("You are a scavenger on a mission to find the rare magical Gold Diamond.");  
		System.out.println("This diamond is hidden deep in a dungeon guarded by vicious trolls."); 
		System.out.println("Your job is to defeat the trolls and obtain 20 pieces of the Gold Diamond to make it complete. Good luck!");
		System.out.println("P.S. watch out for portals!! Being near them will take you to a new room.");
		System.out.println("---------------------------");
		System.out.println("Would you like to restore from a previously saved game? \n (yes - y) (no - n)");
		String cmd = input.nextLine();
		if(cmd.equals("y")){

			//start with progress
			System.out.println("What is the name of file you want to restore from?");
			String restoreFile = input.nextLine();
			try{
				Scanner s = new Scanner(new FileReader(restoreFile));
				
				 
				Player player2 = new Player(s);
				player = player2;
				newRoom = new Room(s, player);
				s.close();
			}catch (Exception f){
				System.out.println("This file is not a valid save.");
				f.printStackTrace();
				System.exit(1);
			}

		}else {
			//start from scratch
			System.out.println("What would you like to name your character?");
			String title = input.nextLine();
			Player player1 = new Player(title,200);
			player = player1;
			newRoom = new Room(player);
			newRoom.generateRoom();
			
		}
		
		String command  = "";
		while(!command.equals("q") && usedKey == false) {
			try{
				Menu.printMenu();
			}catch(InterruptedException e){

			}
			System.out.println("Please enter a command:");
			command  = input.nextLine();

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
					Inventory i = player.getInventory();
					i.print();
					//player.getInventory().print();
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
					System.out.println("Which item would you like to use?");

					Item item = player.getInventory().getItem();
					int index = player.getInventory().getIndex(item);
					item.use(player, index);
					/*TODO if the item's name is magic key, then set a boolean to true to go to a new while loop for bonus level*/
					if(item.getName().equals("Magic Key")) {
						usedKey = true;
					}
					break;
				case "q":
					System.out.println("Would you like to save your progress? \n (s - save)	(q - quit without saving)");
					String choice = input.nextLine();
					if(choice.equals("s")){
						//save the game state
						System.out.println("Enter the name of the file you want to save to: ");
						String fileName = input.nextLine();
						try{	
							PrintWriter p = new PrintWriter(fileName);
							//newRoom.persist(p);
							player.persist(p);
							newRoom.persist(p);	
							p.close();        					
						}catch(Exception e){
						System.out.println("That name is invalid");
						}	

						System.exit(1);
					}else if (choice.equals("q")){
						//quit without saving		
						System.out.println("Your progress will not be saved, you're quitting with " + player.getDiamonds() + " gold diamonds.");
						System.out.println("Bye!");
						System.exit(1);
					}
				default:
					System.out.println("No match.");
					break;
			}
			if(player.getDiamonds() == 20 && givenKey == false){
				System.out.println("You won!!");
				givenKey = true;
				player.getInventory().add(new MagicKey(ItemType.OTHER, "Magic Key", 0, 0 ,0));
				System.out.println("If you want to keep playing, go forth. But if you want to leave, hit q. Your progress will not be saved.");
			}
		}//end while

		BonusLevel bonusLevel = new BonusLevel(player);

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
		String quitAns = " ";

		System.out.println("You have entered the Blind Battle Bonus Level!");
		System.out.println("It's dark in here, you will not be able to see walls, floors, yourself, or monsters.");
		System.out.println("There are ten dragons in the room, and if you die, you die. If you win, you win the entire game!");
		System.out.println("All the commands are the same.");
		System.out.println("Have fun!");

		Dragon dragon = new Dragon("blank", 0, 0);

		while(dragon.getNum() != 0 && !quitAns.equals("y") && player.getHealth() > 0) {
			
			try {
				Menu.printMenu();
			} catch(InterruptedException e){

			}

			System.out.println("Please enter a command:");
                        command  = input.nextLine();

			switch(command) {
				case "w":
					bonusLevel.moveBonus(dragon);
					break;
				case "s":
					bonusLevel.moveBonus(dragon);
					break;
				case "a":
					bonusLevel.moveBonus(dragon);
					break;
				case "d":
					bonusLevel.moveBonus(dragon);
					break;
				case "p":
					Inventory i = player.getInventory();
					i.print();
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
					System.out.println("Which item would you like to use?");

                                        Item item = player.getInventory().getItem();
                                        int index = player.getInventory().getIndex(item);
                                        item.use(player, index);
					break;
				case "q":
					System.out.println("If you quit now, your Bonus Level Progress will not be saved. Do you still want to quit? (y) - yes (n) - no");
					quitAns = input.nextLine();	
					break;
				default: 
					System.out.println("No match.");
					break;
			}
		
		}
		if(dragon.getNum() == 0){
				System.out.println("You won!! You are the king of the dungeon.");
				System.exit(1);
		}
		else if(player.getHealth() == 0){
			System.out.println("The dungeon is a scary place, try again next time!!");
			System.exit(1);
		}
		else{
			System.out.println("bye bye!");
		}


	}//end main method	
}//end main class
