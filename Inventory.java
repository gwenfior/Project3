import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

//The inventory class holds all the methods for inventory and its instance variables
//@author Justin
public class Inventory {

	private int maxWeight;
	private Item equippedWeapon;
	private Item equippedArmor;
	private ArrayList<Item> items;
	Scanner sc = new Scanner(System.in);
	private Item hands = new Item(ItemType.WEAPON, "hands", 0, 0, 1);

	/**
	 * Constructor for Objects of class Inventory
	 */
	public Inventory (int maxWeight){
		items = new ArrayList<Item>();
		this.maxWeight = maxWeight;
	}

	public Inventory(Scanner s)throws Exception{
		try {
			items = new ArrayList<Item>();
			while(true) {
			Item thing = new Item(s);
			items.add(thing);
			}
		}catch(NoMoreItemsException e){

		}	
		maxWeight = s.nextInt();
		this.equippedWeapon = new Item(s);
		while(!s.next().equals(".")){
			equippedArmor = new Item(s);
		}
		s.nextLine();
		
	}


	public void persist(PrintWriter pw){
		//iterate over and store each item in the inventory ArrayList
		for(Item r : items){
			//persist each item
			r.persist(pw);
		}
		pw.println("-End-");
		pw.println(maxWeight);
		equippedWeapon.persist(pw);

		//if armor is equipped
		if(equippedArmor != null){
			equippedArmor.persist(pw);
		}

		//delimeter to signal the end of the ArrayList
		pw.println(".");

	}

	//adds an item to the inventory if the item won't put the inventory over the weight limit
	public boolean add (Item item){
		boolean canAdd = false;
		int totalWeight = 0;

		if(this.items.isEmpty()) {
			totalWeight = totalWeight + item.getWeight();

		}else{

			for(int i = 0; i<this.items.size();i++){
				totalWeight = totalWeight + this.items.get(i).getWeight();
			}

			totalWeight = totalWeight + item.getWeight();
		}

		char cmd = 'Y';

		while(totalWeight > this.maxWeight && cmd == 'Y'){
			canAdd = false;
			System.out.println("Adding " + item.getName() + " will put you over the weight limit");
			System.out.println("Do you want to drop an item from your pack so you can add this item?");
			System.out.println("Y or N?");
			cmd = sc.next().toUpperCase().charAt(0);
			if(cmd == 'Y'){
				this.drop();
				totalWeight = this.totalWeight();
			}
		}//end of else

		if(totalWeight<=this.maxWeight){
			canAdd = true;
			this.items.add(item);
			System.out.println("You added the " + item.getName() + " to your inventory.");
		}//end of if

		return canAdd;
	}//end of add()

	//gets the total weight of the items in the inventory
	public int totalWeight(){
		int total = 0;
		for(int i = 0; i <this.items.size();i++){
			total = total + this.items.get(i).getWeight();
		}
		return total;
	}
	//drops an item from the inventory object
	public void drop(){
		if(this.items.size()<1){
			System.out.println("You can't drop an item if you don't have any!");
			return;
		}else{
			int num = 0;
			for(int i = 0; i<this.items.size();i++){
				num = i +1;
				System.out.println("Item #" + num + ": " + this.items.get(i).getName());
			}
			System.out.println("Which item would you like to drop?");
			System.out.print(": ");
			try{
				int choice = sc.nextInt();
				choice = choice -1;
				System.out.println("The " + this.items.get(choice).getName() + " : removed.");
				if(items.get(choice).equals(equippedWeapon)){
					equippedWeapon = hands;
				}
				if(items.get(choice).equals(equippedArmor)){
					equippedArmor = null;
				}
				this.items.remove(choice);
			}catch(Exception e){
				System.out.println("That is not an option.");
			}
		}

	}

	//removing item without drop method
	public void delete(int index){
		this.items.remove(index);
	}

	//prints out all the items in the inventory
	public void print(){
		int num = 1;
		int choose = 0;
		if(this.items.size()>=1){
			for(int i = 0; i<this.items.size();i++){
				choose  = num + i;
				System.out.println("Item #"+ choose + " : " + this.items.get(i).getName());
			}
		}else {
			System.out.println("You have no items in the inventory to print out.");
			return;
		}
	}
	//equips a weapon from all the weapons in the inventory
	public void equipWeapon(){
		ArrayList<Item> weaponList = new ArrayList<Item>();
		if(this.items.size()<1){
			System.out.println("You can't equip a weapon when you don't have any in your inventory.");
			return;
		}else
			for(int i = 0; i<this.items.size();i++){
				if(this.items.get(i).getType().equals(ItemType.WEAPON)){
					weaponList.add(this.items.get(i));
				}
			}

		if(weaponList.size()<1){
			System.out.println("There aren't any weapons in your inventory.");
			return;
		}else {
			for(int i=0;i<weaponList.size();i++){
				int num = i+1;
				System.out.println("Weapon " + num  + " : " + weaponList.get(i).getName() + " | Strength : " + weaponList.get(i).getStrength());
			}

			System.out.println("Choose a Weapon to Equip from the List: ");
			System.out.print(": ");
			int select = sc.nextInt();
			select = select -1;
			this.equippedWeapon = weaponList.get(select);
			System.out.println("The " + this.equippedWeapon.getName() + ": equipped.");
		}
	}//end equipWeapon()	

	//returns what weapon the player is using
	public Item getEquippedWeapon(){
		return equippedWeapon;

	}

	//returns what armor the player is wearing
	public Item getEquippedArmor(){
		return equippedArmor;
	}

	//for the programmer, sets the intial weapon for the player
	public void setWeapon(Item item){
		this.equippedWeapon = item;
	}//end setWeapon

	//equips armor from the inventory
	public void equipArmor(){
		ArrayList<Item> armorList = new ArrayList<Item>();
		if(this.items.size()<1){
			System.out.println("You can't equip armor when you don't have any in your inventory.");
			return;
		}else 
			for(int i = 0;i<this.items.size();i++){
				if(this.items.get(i).getType().equals(ItemType.ARMOR)){
					armorList.add(this.items.get(i));
				}
			}
		if(armorList.size()<1){
			System.out.println("There aren't any armor pieces in your inventory.");
			return;
		}else{
			for(int i=0;i<armorList.size();i++){
				int num = i+1;
				System.out.println("Armor " + num + " : " + armorList.get(i).getName() + " | Strength : " + armorList.get(i).getStrength());
			}

			System.out.println("Choose an Armor to Equip from the List: ");
			System.out.print(": ");
			int choice = sc.nextInt();
			choice = choice -1;
			this.equippedArmor = armorList.get(choice);
			System.out.println("The " + this.equippedArmor.getName() + ": equipped.");
		}

	}

	public Item getItem(){
		this.print();
		System.out.print("which item would you like? ");
		int choice = sc.nextInt();
		return items.get(choice-1);
	}

	public int getIndex(Item item){
		int index = 0;
		for(int i = 0; i < items.size(); i++){
			if(items.get(i).equals(item)){
				index = i;
			}
		}
		return index;
	}//end return index
}
