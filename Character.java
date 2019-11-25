import java.util.Scanner;
<<<<<<< HEAD
import java.io.PrintWriter;
=======
>>>>>>> 78862b6975292868ab733fbcdfc58acb4aee3695

public class Character{

	//parent class of monster and player
	protected String name;
	protected int health;

	public Character (String name, int health){
		this.name = name;
		this.health = health;

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
