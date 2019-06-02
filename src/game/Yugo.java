package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class Yugo extends Actor{
	//Yugo wears exoskeleton and cannot be attacked as normal
	private boolean exoskeleton=true;
	// Yugo have 50 hitpoints and are always represented with a Y
	public Yugo(Actor player) {
		super("Yugo Maxx", 'Y', 2, 50);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		if(exoskeleton) {
			return new Actions(new DestroyExoskeltonAction(otherActor, this, exoskeleton));
		}
		return super.getAllowableActions(otherActor, direction, map);
	}
}
