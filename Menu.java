/**
This class prints the menu, it has one static method that prints the options the player may do.
@author Dungeon Crawlers
 **/
public class Menu {
	public static void printMenu() throws InterruptedException {
		System.out.println("------------------");
		Thread.sleep(50);
		System.out.println("w: move up");
		Thread.sleep(50);
		System.out.println("s: move down");
		Thread.sleep(50);
		System.out.println("a: move left");
		Thread.sleep(50);
		System.out.println("d: move right");
		Thread.sleep(50);
		System.out.println("p: print inventory");
		Thread.sleep(50);
		System.out.println("e: equip weapon");
		Thread.sleep(50);
		System.out.println("r: equip armor");
		Thread.sleep(50);
		System.out.println("f: drop item");
		Thread.sleep(50);
		System.out.println("i: print player stats");
		Thread.sleep(50);
		System.out.println("u: use an item");
		Thread.sleep(50);
		System.out.println("q: quit");
		Thread.sleep(50);
		System.out.println("------------------");
	}
}

