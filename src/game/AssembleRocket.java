package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class AssembleRocket extends Action {
	private RocketPad rocketPad;
	private Rocket rocket;
	private int haveParts;
	public AssembleRocket(RocketPad rocketPad, Rocket rocket) {
		this.rocketPad = rocketPad;
		this.rocket = rocket;
	}
	/**
	 * Assemble two parts of rocket
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a statement notify whether the rockets assembled sucessfully
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		haveParts = 0;
		for (Item item: actor.getInventory()) {
			if (item instanceof RocketEngine) {
				haveParts = haveParts + 1;
			}
			if (item instanceof RocketBody) {
				haveParts = haveParts + 1;
			}		
		}
		if (haveParts == 2 ) {
			for (Item item: actor.getInventory()) {
				if (item instanceof RocketEngine) {
					actor.removeItemFromInventory(item);
				}
				if (item instanceof RocketBody) {
					actor.removeItemFromInventory(item);
				}		
			}
		map.locationOf(actor).removeItem(rocketPad);
		map.locationOf(actor).addItem(rocket);
			return "Rocket successfully assembled";
		}else {
		return "You don't have enough parts to assemble ";
		}
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Start assemble the rocket";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}

}
