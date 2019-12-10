import java.util.Random;
import java.util.ArrayList;

/**
A class that randomly generates a monster, of which could be weak or strong, from one static method.
@author Dungeon Crawlers
  */
public class MonsterGenerator{

	//generates a random Monster
	public static Monster generate(){

		//random number generator
		Random rng = new Random();
			int rand = rng.nextInt(15);

		Monster enemy = null;

		if(rand<3){
			enemy = new Monster("Skeleton", rng.nextInt(10) + 2, rng.nextInt(7)+5 );

		}else if(rand<6) {
			enemy = new Monster("Troll", rng.nextInt(12) + 5, rng.nextInt(8) + 5);
		}else if(rand<9) {
			enemy = new Monster("Thief", rng.nextInt(15) + 10, rng.nextInt(5) + 10);
		}else if(rand<11) {
			enemy = new Monster("Goblin", rng.nextInt(12) + 2, rng.nextInt(10) + 5);
		}else if(rand<13){
			enemy = new Monster("Golem", rng.nextInt(100) + 50, rng.nextInt(20) + 15);		
		}else if(rand<14){
			enemy = new Monster("Serpent", rng.nextInt(40) + 50, rng.nextInt(30) + 25);
		}else {
			enemy =  new Monster("Dragon", rng.nextInt(50) + 50, rng.nextInt(50) +30);
		}	

		return enemy;

	}

}
