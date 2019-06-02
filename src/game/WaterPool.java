package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class WaterPool extends Ground{
	// WaterPool where player can fill up water 
	public WaterPool() {
		super('W');
	}
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		return new Actions(new AddWaterAction());
	}
}
