/**
This class makes a Magic Key object that inherits from Item.
It overrides the use method to launch the bonus level when obtained.
@author Dungeon Crawlers
  */
public class MagicKey extends Item {

	/**
	Constructor for Magic Key.
	@param itemType enum for item type
	@param name String
	@param weight int
	@param value int
	@param strength int
	  */
	public MagicKey(ItemType itemType, String name, int weight, int value, int strength) {
		super(ItemType.OTHER, name, weight, value, strength);		
	}

	/**
	Overridden method for using Magic Key.
	@return boolean 
	  */
	public boolean use() {
		return true;
	}
}
