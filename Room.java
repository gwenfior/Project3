import java.util.Scanner;
import java.util.Random;
/**This class creates a room to print too the screen.
 * It also allows the player to move around the room.
 * It also moves monsters around the room.
 * @author Sally Burkley
 * */

public class Room{

	private char[][] square;
	private char player;
	private int currentX;
	private int currentY;
	private char monster;
	private Player player1;
	private Monster monster1 = null;

	/**this is the room constructor**/
	public Room(Player player2){
		square = new char[][]{
			{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
			{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_'}
		};
		player = '@';
		monster = '!';
		currentX = 1;
		currentY = 1;
		player1 = player2;
	}//end constructor
	
	//this prints out the original empty room
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
	
	//this moves the player and updates the board depending on that movement.
	//If the spot is a monster, it initates a battle before updating.
	public void movePlayer(int X, int Y){
		if(X == 1){
			//this.moveMonster();
			if(square[currentX-1][currentY] != '_'){//if it is not a wall
				if(square[currentX-1][currentY] != monster){ //if it is not a monster
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
				else if(square[currentX-1][currentY] == monster){//if it is a monster
					monster1 = MonsterGenerator.generate();//generates a monster for the battle
					boolean win = player1.attack(monster1);//fight happens here
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
						Item item = monster1.dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");

					}//end winning
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
		if(X == -1){
			//this.moveMonster();
			if(square[currentX+1][currentY] != '_'){//if it is not a wall
				if(square[currentX+1][currentY] != monster){ //if it is not a monster
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
				else if(square[currentX+1][currentY] == monster){//if it is a monster
					monster1 = MonsterGenerator.generate();//generates a monster for the battle
					
					boolean win = player1.attack(monster1);//fight happens here
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
						Item item = monster1.dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");


					}//end winning
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

		if(Y == 1){
			//this.moveMonster();
			if(square[currentX][currentY-1] != '|'){//if it is not a wall
				if(square[currentX][currentY-1] != monster){ //if it is not a monster
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
				else if(square[currentX][currentY-1] == monster){//if it is a monster
					monster1 = MonsterGenerator.generate();//generates a monster for the battle
					boolean win = player1.attack(monster1);//fight happens here
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
						Item item = monster1.dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");


					}//end winning
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

		
		if(Y == -1){
			//this.moveMonster();
			if(square[currentX][currentY+1] != '|'){//if it is not a wall
				if(square[currentX][currentY+1] != monster){ //if it is not a monster
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
				else if(square[currentX][currentY+1] == monster){//if it is a monster
					monster1 = MonsterGenerator.generate();//generates a monster for the battle
					boolean win = player1.attack(monster1);//fight happens here
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
						Item item = monster1.dropItem();
						boolean pickedUp = player1.getInventory().add(item);
						System.out.println("You also gained a gold diamond!");

					}//end winning
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

		this.moveMonster();
	}//end move player
	
	//this moves the monsters randomly around the room
	public void moveMonster(){//moves the monster randomly around the map
		Random rand = new Random();

		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if(square[x][y] == monster){
					square[x][y] = ' ';
				}
			}
		}
		
		for(int i = 0; i < 4; i++){//this is to make 3 monsters
			int random1 = rand.nextInt(8)+1;
			int random2 = rand.nextInt(8)+1;
			if(square[random1][random2] == '_' || square[random1][random2] == '|'){
				square[1][1] = monster;
			}
			else{
				square[random1][random2] = monster;
			}
		}//end for

	}//end moveMonster()

}//end class Room
