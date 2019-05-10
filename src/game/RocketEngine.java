package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class RocketEngine extends Item{
	// Rocket Body is always represented with a e
	public RocketEngine(String name, char displayChar) {
		super(name, displayChar);
		super.allowableActions.clear();
		super.allowableActions = new Actions(new DropItemAction(this));
		
		// TODO Auto-generated constructor stub
	}
}
