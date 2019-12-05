import java.util.Scanner;
import java.io.PrintWriter;

/**
This class is the parent class for player and monster, creates a base character to move and interact in the game.
@author Dungeon Crawlers
  */
public class Character{

	//parent class of monster and player
	protected String name;
	protected int health;

	/**
	Creates a character object with a name and health.
	@param name Name of Character
	@param health Health of character
	  */
	public Character (String name, int health){
		this.name = name;
		this.health = health;

	}

	/**
	Default constructor for character.
	  */
	public Character(){
		this.name = "default person";
		this.health = 100;

	}

	/**
	Hydration method for character.
	@param s Scanner object
	  */
	public Character(Scanner s){

		this.name = s.nextLine();
		this.health = s.nextInt();

	}

	/**
	Persistance method for Character.
	@param pw PrintWriter object
	  */
	public void persist(PrintWriter pw){
		pw.println(name);
		pw.println(health);
	}

	/**
	Method to get a character's name.
	@return name of character
	  */
	public String getName(){
		return this.name;
	}

	/**
	Method to get character's health.
	@return character's health stat
	  */
	public int getHealth(){
		return this.health;
	}

	/**
	Method to set health of a character.
	@param num amount of health points
	  */
	public void setHealth(int num){
		this.health = num;
	}

	/**
	Method that returns stats of a character.
	  */
	public void stats(){
		System.out.println("This " + this.name + " has a health of " + this.health + "."); 
	}
}
