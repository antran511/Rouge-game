package game;

import edu.monash.fit2099.demo.WindowSmashAction;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class RocketPad extends Ground {
	// Rocket Body is always represented with a 0
	public RocketPad() {
		super('0');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return true;
	}
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new AssembleRocket(actor));
	}
}
