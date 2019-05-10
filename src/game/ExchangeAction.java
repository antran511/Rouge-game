package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.*;

public class ExchangeAction extends Action {

	private Actor subject;
	private Item item1;
	private Item item2;
	/**
	 * Constructor to create an actione of exchanging two items
	 * 
	 * @param actor the player who keeps item1
	 * @param subject the actor has item to be given for exchange
	 * @param item1 the item to exchange
	 * 
	 */
	public ExchangeAction(Actor actor, Actor subject, Item item1) {
		this.subject = subject;
		this.item1 = item1;
	}
	/**
	 * Follow the actor on GameMap
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a suitable description to display in the UI
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		System.out.println("Ok! Give me the rocket body");
		for (Item item : subject.getInventory()) {
			if (item instanceof RocketBody) {
				this.item2 = item;
			}
		}
		actor.removeItemFromInventory(item1);
		subject.removeItemFromInventory(item2);
		actor.addItemToInventory(item2);
		item2.getAllowableActions().add(new DropItemAction(item2));
		return menuDescription(actor);
		
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " exchange plans with " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}


}
