/**This class prints the menu.
 * It has one static method that prints the options the player may do.
 *@author Gwen
 **/
public class Menu {
	public static void printMenu() throws InterruptedException {
		System.out.println("------------------");
		Thread.sleep(100);
		System.out.println("w: move up");
		Thread.sleep(100);
		System.out.println("s: move down");
		Thread.sleep(100);
		System.out.println("a: move left");
		Thread.sleep(100);
		System.out.println("d: move right");
		Thread.sleep(100);
		System.out.println("p: print inventory");
		Thread.sleep(100);
		System.out.println("e: equip weapon");
		Thread.sleep(100);
		System.out.println("r: equip armor");
		Thread.sleep(100);
		System.out.println("f: drop item");
		Thread.sleep(100);
		System.out.println("i: print player stats");
		Thread.sleep(100);
		System.out.println("u: use an item");
		Thread.sleep(100);
		System.out.println("q: quit");
		Thread.sleep(100);
		System.out.println("------------------");
	}
}

