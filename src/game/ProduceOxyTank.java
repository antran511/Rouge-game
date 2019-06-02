package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class ProduceOxyTank extends Action {
	private String direction;
	private Location lockedDoor;
	/**
	 * Constructor to create an action of open a locked door
	 * 
	 * @param direction the direction of the destination from actor
	 * @param lockedDoor the door is being locked
	 * 
	 */
	public ProduceOxyTank(String direction, Location lockedDoor) {
		this.direction = direction;
		this.lockedDoor = lockedDoor;
	}
	/**
	 * Open a locked door on game map
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a statement notify whether the door is open
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		for(Item item: actor.getInventory()) {
			if(item instanceof Key) {
				map.add(new OpenedDoor(), lockedDoor);
				actor.removeItemFromInventory(item);
				return "The door is opened";
			}
		}
		return "You need a key to open this door";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " open the door to " + direction;
	}

	@Override
	public String hotKey() {
		return "";
	}
}

