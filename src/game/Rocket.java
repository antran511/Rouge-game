package game;

import edu.monash.fit2099.engine.Item;

public class Rocket extends Item {
	
	// Rocket Body is always represented with ^
	public Rocket() {
		super("Rocket", '^');
		super.getAllowableActions().clear();
		// TODO Auto-generated constructor stub
	}
	
}
