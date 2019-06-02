package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class PressButtonAction extends Action  {
	private int waitTime = 1; 
	private Item oxyTank;
	private int count;
	public PressButtonAction(Item oxyTank) {
		this.oxyTank = oxyTank;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		for (Item item: map.locationOf(actor).getItems()) {
			if (item.equals(oxyTank)) {
				return "Please use the current oxytank before produce another one";
			}
		}
		this.count = 0;
		
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
