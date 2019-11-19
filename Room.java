import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
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
	private ArrayList<Monster> monster = new ArrayList<Monster>();
	private Player player1;
	//private int random1 = 12;
	//private int random2 = 12;

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
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
		monster.add(MonsterGenerator.generate());
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
		Random random = new Random();
		int theNum = random.nextInt(monster.size());
		if(X == 1){
			//this.moveMonster();
			if(square[currentX-1][currentY] != '_'){//if it is not a wall
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
					//monster1 = MonsterGenerator.generate();//gene
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

		for(int t = 0; t < monster.size(); t++){
			monster.get(t).moveMonster(square);
		}
	}//end move player
	
	//this moves the monsters randomly around the room
	/*public void moveMonster(char[][] square){//moves the monster randomly around the map
		Random rand = new Random();
		
		for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if(square[x][y] == monster[t]){
					System.out.println("AAAA");
					square[x][y] = ' ';
				}
			}
		}
		if(random1 == 12 || random2 == 12){
			for(int i = 0; i < 4; i++){//this is to make 3 monsters
				random1 = rand.nextInt(8)+1;
				random2 = rand.nextInt(8)+1;
				if(square[random1][random2] == '_' || square[random1][random2] == '|'){
					System.out.println("BBBBBB");
					square[1][1] = monster[t];
				}
				else{
					square[random1][random2] = monster[t];
					System.out.println("CCCCCC");
				}
			}
		}//end if
		else{
			if(square[random1+1][random2] != '_' && square[random1+1][random2] != '|'){
					square[random1+1][random2] = monster[t];
					random1 = random1+1;
					System.out.println("MOVE");
				}
			else if(square[random1-1][random2] != '_' && square[random1-1][random2] != '|'){
					square[random1-1][random2] = monster[t];
					random1 = random1 - 1;
					System.out.println("MOVE");

				}
			else if(square[random1][random2+1] != '_' && square[random1][random2+1] != '|'){
					square[random1][random2+1] = monster[t];
					random2 = random2+1;
					System.out.println("MOVE");

				}
			else if(square[random1][random2-1] != '_' && square[random1][random2-1] != '|'){
					square[random1][random2-1] = monster[t];
					random2 = random2-1;
					System.out.println("MOVE");

				}
				else{
					random1 = 12;
					random2 = 12;
					square[1][1] = monster[t];
				}
		}



	}//end moveMonster()*/

}//end class Room
