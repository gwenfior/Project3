import java.util.Random;

/**
This class creates a Monster object and inherits from Character.
@author Dungeon Crawlers
  */
public class Monster extends Character{

	protected int strength;
	private int random1 = 12;
	private int random2 = 12;
	private char character;
	private int numMoves = 0;
	
	/**
	Constructor for Monster.
	@param name String
	@param health int
	@param strength int
	  */
	public Monster(String name, int health, int strength){
		super(name, health);
		this.strength = strength;
		this.character = '!';

	}
	
	/**
	Method that generates a random object to be dropped by monster when it's killed.
	@return random item
	  */
	public Item dropItem(){
		Item thing  = null;
		thing = ItemGenerator.generate();
		return thing;
	}
	
	/**
	Method for getting Monster's strength.
	@return int
	  */
	public int getStrength(){
		return this.strength;
	}



	/**
	Method to make monsters move around room.
	@return char[][] of room
	@param square char[][]
	  */
	public char[][] moveMonster(char[][] square){//moves the monster randomly around the map
		Random rand = new Random();
		
		if(random1 == 12 || random2 == 12){
			for(int i = 0; i < 4; i++){//this is to make 3 monsters
				random1 = rand.nextInt(8)+1;
				random2 = rand.nextInt(8)+1;
				if(square[random1][random2] == '_' || square[random1][random2] == '|'){
					square[1][1] = this.character;
				}
				else{
					square[random1][random2] = this.character;
				}
			}
		}//end if
		else{
			//System.out.println("Monster has moved: " + numMoves);
			if(numMoves == 9){
				numMoves = 0;
			}
			if(numMoves <= 4){
				if(square[random1+1][random2] != '_' && square[random1+1][random2] != '|'){
					square[random1+1][random2] = this.character;
					random1 = random1+1;
					
				}
				else if(square[random1-1][random2] != '_' && square[random1-1][random2] != '|'){
					square[random1-1][random2] = '!';
					random1 = random1 - 1;

				}
				else if(square[random1][random2+1] != '_' && square[random1][random2+1] != '|'){
					square[random1][random2+1] = this.character;
					random2 = random2+1;

				}
				else if(square[random1][random2-1] != '_' && square[random1][random2-1] != '|'){
					square[random1][random2-1] = this.character;
					random2 = random2-1;

				}
				numMoves++;
			}
			if(numMoves > 4 && numMoves <= 8){
				if(square[random1-1][random2] != '_' && square[random1-1][random2] != '|'){
					square[random1-1][random2] = this.character;
					random1 = random1-1;
				}
				else if(square[random1+1][random2] != '_' && square[random1+1][random2] != '|'){
					square[random1+1][random2] = '!';
					random1 = random1 + 1;

				}
				else if(square[random1][random2+1] != '_' && square[random1][random2+1] != '|'){
					square[random1][random2+1] = this.character;
					random2 = random2+1;

				}
				else if(square[random1][random2-1] != '_' && square[random1][random2-1] != '|'){
					square[random1][random2-1] = this.character;
					random2 = random2-1;

				}
				numMoves++;
			}

		}//end else
		return square;
	}//end move monster

}//end monster
