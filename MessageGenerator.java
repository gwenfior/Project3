import java.util.Random;

/**
This class generates a message for a book to have when used from one static method.
@author Dungeon Crawlers
  */
public class MessageGenerator {


	public static String generate(){

		Random rng = new Random();
		int rand = rng.nextInt(8);


		String s = "";
		if(rand <2){
			s = "You flipped to page 110. It says 'Remember, to win the game, you must collect 10 gold diamonds that you get by killing monsters.'";
		} else if(rand <3){
			s = "You flipped to page 240. It says 'When you get a new item, check to see if you can use it.'";
		} else if(rand < 4){
			s = "You flipped to page 220. It says 'Always remember to check your equipped weapon and armor to make sure the best possible armor or weapon is equipped.'";
		} else if(rand <5){
			s = "You flipped to page 284. It says 'Make sure to save and quit before you leave the game so your progress doesn't get lost.'";
		} else if(rand <6){
			s = "You flipped to page 340. It says 'Some enemies are more common than others, so do your best to avoid powerful ones like dragons or serpents.'";
		} else if(rand <7){
			s = "You flipped to page 415. It says 'Drop items that you can't use to make room for other items that can help you.'";	
		} else {
			s = "You flipped to page 430. It says 'When you get to the end of the game, you can keep playing to get the best weapons and armor.'";
		}
		return s;

	}
}
