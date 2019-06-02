package game;


import edu.monash.fit2099.engine.Item;

public class RocketPad extends Item {
	
	// Rocket Body is always represented with a p
	public RocketPad() {
		super("Rocket Pad", '~');
		super.getAllowableActions().clear();
		// TODO Auto-generated constructor stub
	}
	
}