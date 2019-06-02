package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class FillOxyLevel extends Action  {
	
	private int capacity;
	private Item oxyTank;
	public FillOxyLevel(Item item) {
		this.oxyTank = item;
	}
	
	public String execute(Actor actor, GameMap map) {
		if (actor instanceof StunnedPlayer) {
			this.capacity = ((StunnedPlayer) actor).getOxyLevel();
				if (this.capacity + 10 > 40) {
					return "Please use up oxygen before filling";
				}else {
					((StunnedPlayer) actor).addOxyLevel(10);
					map.locationOf(actor).removeItem(oxyTank);
					return "Your oxy level filled";
				}					
			}
		return null;
	}
	

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Use the oxy tank to fill oxy level";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}

}
