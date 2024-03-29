import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
This class creates a room to print too the screen.
It also allows the player to move around the room.
It also moves monsters around the room.
@author Dungeon Crawlers
 **/
public class Room{

	private char[][] square;
	private char player;
	private int currentX;
	private int currentY;
	private ArrayList<Monster> monster = new ArrayList<Monster>();
	private Player player1;
	private int currentRoom;

	/**
	Constructor for the room.
	@param player2 Player object
	  */
	public Room(Player player2){
		currentRoom = 1;
		square = World.getRoom(currentRoom); 
		player = '@';
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		currentX = 1;
		currentY = 1;
		player1 = player2;
	}//end constructor

	/**
	Hydration method for room.
	@param s Scanner object
	@param player2 Player object
	  */
	public Room(Scanner s, Player player2){
		this.player1 = player2;
		String thing = s.nextLine();
		thing = s.nextLine();
		thing = s.next();
		//System.out.println(thing);
		this.currentRoom = s.nextInt();
		//System.out.println(currentRoom);
		this.player = '@';
		thing = s.next();
		this.currentX = s.nextInt();
		//System.out.println(currentX);
		thing = s.next();
		this.currentY = s.nextInt();
		//System.out.println(currentY);
		
		square = World.getRoom(currentRoom);
		square[currentX][currentY] = player;

		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());

		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				System.out.print(square[x][y]);
			}
			System.out.println(" ");
		}

	}

	/**
	Persistance method for room.
	@param pw PrintWriter object
	  */
	public void persist(PrintWriter pw){
		//player1.persist(pw);
		//delimeter seperating player stuff and room stuff
		pw.print("CurrentRoom: ");
		pw.println(currentRoom);
		pw.print("currentX: ");
	        pw.println(currentX);
		pw.print("currentY: ");
		pw.println(currentY);

		/*for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				pw.print(square[x][y]);
				pw.print(".");
			}
			pw.println();
		}*/
	}

	/**
	Method that generates original room.
	  */
	public void generateRoom(){
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if(x == 1 && y == 1){
					square[x][y] = player;
				}
				System.out.print(square[x][y]);
			}
			System.out.println(" ");
		}

	}//end generateRoom

	/**
	This moves the player and updates the board depending on that movement.
	If the spot is a monster, it initates a battle before updating.
	@param X x-coordinate of Player
	@param Y y-coordinate of Player
	  */
	public void movePlayer(int X, int Y){
		Random random = new Random();
		int theNum = random.nextInt(monster.size());
		if(square[currentX-1][currentY] == 'P' || square[currentX+1][currentY] == 'P' || square[currentX][currentY-1] == 'P' 
				|| square[currentX][currentY+1] == 'P'){
			if(currentRoom < 3){
				currentRoom = currentRoom+1;
				square = World.getRoom(currentRoom);
				this.generateRoom();
				currentX = 1;
				currentY = 1;
			}else{
				currentRoom = 1;
				square = World.getRoom(currentRoom);
				this.generateRoom();
				currentX = 1;
				currentY = 1;
			}
		}
		else if(X == 1){
			if(square[currentX-1][currentY] != '_' && square[currentX-1][currentY] != '|'){//if it is not a wall
				if(square[currentX-1][currentY] != '!'){ //if it is not a monster
					System.out.println(" ");
					square[currentX][currentY] = ' ';
					square[currentX-1][currentY] = player;
					currentX = currentX - 1;
					for(int x = 0; x < 10; x++){
						for(int y = 0; y < 10; y++){
							System.out.print(square[x][y]);
						}
						System.out.println(" ");
					}//end printing the map again
				}
				else if(square[currentX-1][currentY] == '!'){//if it is a monster
					boolean win = player1.attack(monster.get(theNum));//fight happens here
					if(win == true){//if they win, they step on the monster
						square[currentX][currentY] = ' ';
						square[currentX-1][currentY] = player;
						currentX = currentX - 1;
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again
						Item item = monster.get(theNum).dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");
						monster.remove(theNum);
						monster.add(MonsterGenerator.generate());

					}//end winning
					else if(win == false && player1.getHealth() > 0){
						System.out.println("try to gain more health using potions.");
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again

					}//end if they ran

					else{
						System.out.println("End game :(((((");
						System.exit(1);
					}//end game 
				}

			}//end if not a ceiling
			else{
				System.out.println("You can't move there!");
			}
		}//end if going up

		else if(X == -1){
			if(square[currentX+1][currentY] != '_' && square[currentX+1][currentY] != '|'){//if it is not a wall
				if(square[currentX+1][currentY] != '!'){ //if it is not a monster
					System.out.println(" ");
					square[currentX][currentY] = ' ';
					square[currentX+1][currentY] = player;
					currentX = currentX + 1;
					for(int x = 0; x < 10; x++){
						for(int y = 0; y < 10; y++){
							System.out.print(square[x][y]);
						}
						System.out.println(" ");
					}//end printing the map again
				}
				else if(square[currentX+1][currentY] == '!'){//if it is a monster
					boolean win = player1.attack(monster.get(theNum));//fight happens here
					if(win == true){//if they win, they step on the monster
						square[currentX][currentY] = ' ';
						square[currentX+1][currentY] = player;
						currentX = currentX + 1;
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again
						Item item = monster.get(theNum).dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");
						monster.remove(theNum);
						monster.add(MonsterGenerator.generate());

					}//end winning
					else if(win == false && player1.getHealth() > 0){
						System.out.println("try to gain more health using potions.");
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again

					}//end if they ran


					else{
						System.out.println("End game :(((((");
						System.exit(1);
					}//end game 
				}

			}//end if not a floor
			else{
				System.out.println("You can't move there!");
			}
		}//end if going down

		else if(Y == 1){
			if(square[currentX][currentY-1] != '_' && square[currentX][currentY-1] != '|'){//if it is not a wall
				if(square[currentX][currentY-1] != '!'){ //if it is not a monster
					System.out.println(" ");
					square[currentX][currentY] = ' ';
					square[currentX][currentY-1] = player;
					currentY = currentY - 1;
					for(int x = 0; x < 10; x++){
						for(int y = 0; y < 10; y++){
							System.out.print(square[x][y]);
						}
						System.out.println(" ");
					}//end printing the map again
				}
				else if(square[currentX][currentY-1] == '!'){//if it is a monster
					boolean win = player1.attack(monster.get(theNum));//fight happens here
					if(win == true){//if they win, they step on the monster
						square[currentX][currentY] = ' ';
						square[currentX][currentY-1] = player;
						currentY = currentY - 1;
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again
						Item item = monster.get(theNum).dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");
						monster.remove(theNum);
						monster.add(MonsterGenerator.generate());

					}//end winning
					else if(win == false && player1.getHealth() > 0){
						System.out.println("try to gain more health using potions.");
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again

					}//end if they ran


					else{
						System.out.println("End game :(((((");
						System.exit(1);
					}//end game 
				}

			}//end if not a wall
			else{
				System.out.println("You can't move there!");
			}
		}//end if going right


		else if(Y == -1){
			if(square[currentX][currentY+1] != '_' && square[currentX][currentY+1] != '|'){//if it is not a wall
				if(square[currentX][currentY+1] != '!'){ //if it is not a monster
					System.out.println(" ");
					square[currentX][currentY] = ' ';
					square[currentX][currentY+1] = player;
					currentY = currentY + 1;
					for(int x = 0; x < 10; x++){
						for(int y = 0; y < 10; y++){
							System.out.print(square[x][y]);
						}
						System.out.println(" ");
					}//end printing the map again
				}
				else if(square[currentX][currentY+1] == '!'){//if it is a monster
					boolean win = player1.attack(monster.get(theNum));//fight happens here
					if(win == true){//if they win, they step on the monster
						square[currentX][currentY] = ' ';
						square[currentX][currentY+1] = player;
						currentY = currentY + 1;
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again
						Item item = monster.get(theNum).dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");
						monster.remove(theNum);
						monster.add(MonsterGenerator.generate());

					}//end winning
					else if(win == false && player1.getHealth() > 0){
						System.out.println("try to gain more health using potions.");
						for(int x = 0; x < 10; x++){
							for(int y = 0; y < 10; y++){
								System.out.print(square[x][y]);
							}
							System.out.println(" ");
						}//end printing the map again

					}//end if they ran


					else{
						System.out.println("End game :(((((");
						System.exit(1);
					}//end game 
				}

			}//end if not a wall
			else{
				System.out.println("You can't move there!");
			}
		}//end if going left

		invisibleMonster();
		for(int t = 0; t < monster.size(); t++){
			monster.get(t).moveMonster(square);
		}
	}//end move player


	/**
	Method for removing monsters from room when moved.
	  */
	public void invisibleMonster(){
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if(square[x][y] == '!'){
					square[x][y] = ' ';
				}
			}
		}
	}//end removing monsters from board


}//end class Room
