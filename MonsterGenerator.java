import java.util.Random;
import java.util.ArrayList;
//this class contains one static method that generates a random monster
//the monster can have a random name and random strength within reason
//higher chances of generating weaker monsters
//@author Justin

public class MonsterGenerator{

	//generates a random Monster
	public static Monster generate(){

		//random number generator
		Random rng = new Random();
			int rand = rng.nextInt(15);

		Monster enemy = null;

		if(rand<3){
			enemy = new Monster("Skeleton", rng.nextInt(5) + 1, rng.nextInt(5)+2);

		}else if(rand<6) {
			enemy = new Monster("Troll", rng.nextInt(6) + 2, rng.nextInt(5) + 5);
		}else if(rand<9) {
			enemy = new Monster("Thief", rng.nextInt(10) + 3, rng.nextInt(3) + 2);
		}else if(rand<11) {
			enemy = new Monster("Goblin", rng.nextInt(5) + 4, rng.nextInt(10) + 5);
		}else if(rand<13){
			enemy = new Monster("Golem", rng.nextInt(20) + 10, rng.nextInt(15) + 15);		
		}else if(rand<14){
			enemy = new Monster("Serpent", rng.nextInt(25) + 10, rng.nextInt(30) + 25);
		}else {
			enemy =  new Monster("Dragon", rng.nextInt(30) + 10, rng.nextInt(50)+25);
		}	

		return enemy;

	}

}
