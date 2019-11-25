import java.util.Scanner;
import java.io.PrintWriter;

public class Character{

	//parent class of monster and player
	protected String name;
	protected int health;

	public Character (String name, int health){
		this.name = name;
		this.health = health;

	}

	public Character(){
		this.name = "default person";
		this.health = 100;

	}

	public Character(Scanner s){

		this.name = s.nextLine();
		this.health = s.nextInt();

	}

	public void persist(PrintWriter pw){
		pw.println(name);
		pw.println(health);
	}

	public String getName(){
		return this.name;
	}

	public int getHealth(){
		return this.health;
	}

	public void setHealth(int num){
		this.health = num;
	}

	public void stats(){
		System.out.println("This " + this.name + " has a health of " + this.health + "."); 
	}
}
