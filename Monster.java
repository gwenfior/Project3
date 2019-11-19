import java.util.Random;
//This class creates a monster object.
//It holds the variables necessary for a monster to do battles.
//@author Justin
public class Monster extends Character{

	private int strength;
	private int random1 = 12;
	private int random2 = 12;
	private char character;
	
	/**This is the Constructor for a Monster**/
	public Monster(String name, int health, int strength){
		super(name, health);
		this.strength = strength;
		this.character = '!';

	}
	
	//when the monster dies, it must drop an item
	public Item dropItem(){
		Item thing  = null;
		thing = ItemGenerator.generate();
		return thing;
	}
	
	//this returns the monsters strength
	public int getStrength(){
		return this.strength;
	}



	//this moves the monsters randomly around the room
	public char[][] moveMonster(char[][] square){//moves the monster randomly around the map
		Random rand = new Random();
		
	/*	for(int x = 0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				if(square[x][y] == this.character){
					System.out.println("AAAA");
					square[x][y] = ' ';
				}
			}
		}*/
		if(random1 == 12 || random2 == 12){
			for(int i = 0; i < 4; i++){//this is to make 3 monsters
				random1 = rand.nextInt(8)+1;
				random2 = rand.nextInt(8)+1;
				if(square[random1][random2] == '_' || square[random1][random2] == '|'){
					//System.out.println("BBBBBB");
					square[1][1] = this.character;
				}
				else{
					square[random1][random2] = this.character;
					//System.out.println("CCCCCC");
				}
			}
		}//end if
		else{
			if(square[random1+1][random2] != '_' && square[random1+1][random2] != '|'){
					square[random1+1][random2] = this.character;
					random1 = random1+1;
					//System.out.println("MOVE");
				}
			else if(square[random1-1][random2] != '_' && square[random1-1][random2] != '|'){
					square[random1-1][random2] = '!';
					random1 = random1 - 1;
					//System.out.println("MOVE");

				}
			else if(square[random1][random2+1] != '_' && square[random1][random2+1] != '|'){
					square[random1][random2+1] = this.character;
					random2 = random2+1;
					//System.out.println("MOVE");

				}
			else if(square[random1][random2-1] != '_' && square[random1][random2-1] != '|'){
					square[random1][random2-1] = this.character;
					random2 = random2-1;
					//System.out.println("MOVE");

				}
		}
		return square;
	}//end move monster

}//end monster
