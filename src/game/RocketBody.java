package game;

import edu.monash.fit2099.engine.Item;

public class RocketBody extends Item {
	
	// Rocket Body is always represented with a b
	public RocketBody(String name, char displayChar) {
		super(name, displayChar);
		super.getAllowableActions().clear();
		// TODO Auto-generated constructor stub
	}
	
}
