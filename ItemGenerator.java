import java.util.Random;
import java.util.ArrayList;
//this class contains one static method that generates a random item
//the random item could be a Weapon, Armor, or Other miscellaneous items
//the weapons and armor are made of a specific material which is also randomly assigned to the item
//@author Justin
public class ItemGenerator{
	//generates a random item 
	public static Item generate(){


		//random number generator
		Random rng = new Random();
		 int rando = rng.nextInt(10);
		 int randMat = rng.nextInt(6);
		 int  smallArm = rng.nextInt(5);
		 int largeArm = rng.nextInt(4);
		 int smallWeap = rng.nextInt(5);
		 int largeWeap = rng.nextInt(6);


		//create an arrayList of miscellaneous objects
		ArrayList<String> others = new ArrayList<String>();
		others.add("Keys");
		others.add("Potions");
		others.add("Book");
		others.add("Scroll");
		others.add("Map");
		others.add("Bucket");
		others.add("Food");
		others.add("Tusk");
		others.add("Vase");

		//create an arrayList of Materials
		ArrayList<String> materials = new ArrayList<String>();
		materials.add("Wood");
		materials.add("Iron");
		materials.add("Gold");
		materials.add("Steel");
		materials.add("Forged");
		materials.add("DragonStone");

		//two array list split up between small and large armor
		//light weight armor
		ArrayList<String> smallArmor = new ArrayList<String>();
		smallArmor.add("Gloves");
		smallArmor.add("Elbow Guards");
		smallArmor.add("Shoes");
		smallArmor.add("Neck Guard");
		smallArmor.add("Foregaurds");

		//heavy weight armor
		ArrayList<String> largeArmor = new ArrayList<String>();
		largeArmor.add("Breastplate");
		largeArmor.add("Helmet");
		largeArmor.add("Shield");
		largeArmor.add("Backplate");

		//two arraylists split up by weapon weight
		//lightWeight weapons
		ArrayList<String> smallWeapon = new ArrayList<String>();
		smallWeapon.add("Dagger");
		smallWeapon.add("Hammer");
		smallWeapon.add("Fork");
		smallWeapon.add("Ball and Chain");
		smallWeapon.add("Pan");
		//heavyWeight weapons
		ArrayList<String> largeWeapon = new ArrayList<String>();
		largeWeapon.add("Sword");
		largeWeapon.add("Axe");
		largeWeapon.add("Mace");
		largeWeapon.add("Spear");
		largeWeapon.add("Lance");
		largeWeapon.add("Staff");

		Item words = null;
		if(rando<3){
			words  = new Item(ItemType.OTHER,others.get(rando), rng.nextInt(10), rando, 0); 
		}else if (rando>= 3 && rando<5){
			words  = new Item(ItemType.ARMOR, materials.get(randMat) + " " + smallArmor.get(smallArm),rng.nextInt(6)+5,rng.nextInt(6)+5,rng.nextInt(15) + 1);  
		}else if (rando>=5 && rando <7){
			words  = new Item(ItemType.ARMOR, materials.get(randMat) + " " + largeArmor.get(largeArm), rng.nextInt(30) +20, rng.nextInt(10) +10, rng.nextInt(35) +10);
		}else if (rando>=7 && rando <9){
			words = new Item(ItemType.WEAPON, materials.get(randMat) + " " + smallWeapon.get(smallWeap), rng.nextInt(20) + 10, rng.nextInt(30) + 20, rng.nextInt(25)+5); 
		}else {
			words = new Item(ItemType.WEAPON, materials.get(randMat) + " " + largeWeapon.get(largeWeap), rng.nextInt(50) +20, rng.nextInt(60) + 20, rng.nextInt(45) + 15);
		}

		return words; 

	}

}
