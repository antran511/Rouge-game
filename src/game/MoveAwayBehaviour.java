package game;

import edu.monash.fit2099.engine.*;


public class MoveAwayBehaviour implements ActionFactory {

	private Actor target;
	/**
	 * Constructor to create a behavior that allow Ninja to move away from
	 * player in 5 distance square
	 * 
	 * @param subject the actor to move away from
	 */
	public MoveAwayBehaviour(Actor subject) {
		this.target = subject;
	}
	/**
	 * Move one step away from the actor on GameMap
	 *
	 * @see Action#getAction(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a MoveActorAction which let the actor move one step away from
	 *  the subject if qualified
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		
		int currentDistance = distance(here, there);
		if (currentDistance <= 5) {
			for (Exit exit : here.getExits()) {
				Location destination = exit.getDestination();
				if (destination.canActorEnter(actor)) {
					int newDistance = distance(destination, there);
					if (newDistance > currentDistance ) {
						return new MoveActorAction(destination, exit.getName());
				}
			}
		}
		}
	return null;
	}

	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}