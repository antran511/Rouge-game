package game;

import edu.monash.fit2099.engine.*;

public class Key extends Item{

	public Key(String name, char displayChar) {
		super("key", 'k');
		super.allowableActions.clear();
		super.allowableActions = new Actions(new DropItemAction(this));
	}
}
