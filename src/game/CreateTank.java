package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class CreateTank extends Action  {
	private int waitTime = 1; 
	private Item oxyTank;
	/**
	 * Constructor to create an action of press oxy dispenser
	 * 
	 * @param oxyTank a tank in which contains 10 points of oxygen
	 * 
	 */
	public CreateTank(Item oxyTank) {
		this.oxyTank = oxyTank;
	}
	@Override
	/**
	 * Execute a button action to oxy dispenser
	 * Oxydispenser works if oxyTank is not at the location
	 * @see Action#execute(Actor, GameMap)
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a statement notify whether the door is open
	 */
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		for (Item item: map.locationOf(actor).getItems()) {
			if (item.equals(oxyTank)) {
				return "Please use the current oxytank before produce another one";
			}
		}
		
		if (waitTime != 0) {
			this.waitTime = this.waitTime - 1;
			return "Oxygen is being produced";
		} else {
			this.waitTime = 1;
			map.locationOf(actor).addItem(this.oxyTank);
			return "Oxy tank production done!";
		}
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Press the button to produce oxygen tank";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}

}
