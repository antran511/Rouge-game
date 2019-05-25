package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;


public class TalkAction extends Action{

	private Actor subject;
	/**
	 * Constructor to create an action of open a locked door
	 * 
	 * @param actor the person is talking
	 * @param subject the person is listening
	 */
	public TalkAction(Actor actor, Actor subject) {
		this.subject = subject;
	}
	/**
	 * Talk with Q to exchange for a rocket body
	 *
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a statement notify the state of the conversation
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "I can give you something that will help, but I’m going to need the plans.";
		for (Item item : actor.getInventory()) {
			if (item instanceof RocketPlans) {
				System.out.println("Hand them over, I don’t have all day");
				item.getAllowableActions().add(new ExchangeAction(actor, subject, item));
				for (Action action: item.getAllowableActions()) {
					if (action instanceof ExchangeAction) {
						action.execute(actor, map);
					}
				}
				result = "Good luck my man. All the best!!";
				map.removeActor(subject);
				return result;
				
			}else {
			result = "I can give you something that will help, but I’m going to need the plans.";
			}
	}return result;
	}
	
	@Override
	public String menuDescription(Actor actor) {
		return actor + " talks to " + subject;
	}

	@Override
	public String hotKey() {
		return "";
	}

	
	}

	

	

