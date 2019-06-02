package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class EndAction extends Action{
	/**
	 * Constructor to create an action of open a locked door
	 */
	public EndAction() {
	}
	
	/**
	 * Execute method of EndAction. Player can choose to exit the gam
	 * whenever the player want
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		System.exit(0);
		System.out.println("Game over");
		return null;
	}
	/**
	 * Menu description of EndGame action
	 */
	@Override
	public String menuDescription(Actor actor) {
		return "End Game";
	}

	@Override
	public String hotKey() {
		return "0";
	}
}