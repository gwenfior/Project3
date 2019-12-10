import java.util.Random;
import java.util.ArrayList;

/**
This class contains one static method that generates a random item,
the random item could be a Weapon, Armor, or Other miscellaneous item, and
the weapons and armor are made of a specific material which is also randomly assigned to the item.
@author Dungeon Crawlers
 */
public class ItemGenerator{
	
        /**
	This method generates a random item and is static.
	@return the item that was generated
	*/	  
	public static Item generate(){


		//random number generator
		Random rng = new Random();
		int rando = rng.nextInt(11);
		int randMat = rng.nextInt(6);
		int  smallArm = rng.nextInt(5);
		int largeArm = rng.nextInt(4);
		int smallWeap = rng.nextInt(5);
		int largeWeap = rng.nextInt(6);


		//create an arrayList of miscellaneous objects
		ArrayList<String> others = new ArrayList<String>();
		others.add("Keys");
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
		if(rando<=1){
			words  = new Potion(ItemType.OTHER,"Potion", rng.nextInt(10), rando, rng.nextInt(15)+5); 
		}else if(rando<=2){

			words = new Book(ItemType.OTHER,"Book",rng.nextInt(10), rando,0);
		}else if(rando<=3){

			words = new Item(ItemType.OTHER,others.get(rng.nextInt(7)), rando, rng.nextInt(5), 0);

		}else if (rando>= 4 && rando<6){
			words  = new Item(ItemType.ARMOR, materials.get(randMat) + " " + smallArmor.get(smallArm),rng.nextInt(6)+5,rng.nextInt(6)+5,rng.nextInt(15) + 1);  
		}else if (rando>=6 && rando <8){
			words  = new Item(ItemType.ARMOR, materials.get(randMat) + " " + largeArmor.get(largeArm), rng.nextInt(30) +20, rng.nextInt(10) +10, rng.nextInt(35) +10);
		}else if (rando>=8 && rando <10){
			words = new Item(ItemType.WEAPON, materials.get(randMat) + " " + smallWeapon.get(smallWeap), rng.nextInt(20) + 10, rng.nextInt(30) + 20, rng.nextInt(25)+5); 
		}else {
			words = new Item(ItemType.WEAPON, materials.get(randMat) + " " + largeWeapon.get(largeWeap), rng.nextInt(50) +20, rng.nextInt(60) + 20, rng.nextInt(45) + 15);
		}

		return words; 

	}

}

