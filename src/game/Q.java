package game;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Q extends Actor{
	
	// Q have 0 hitpoints and are always represented with a q
	public Q(String name, Actor player) {
		// Grunts have 0 hitpoints and are always represented with a q
		super(name, 'q', 2, 0);
		// TODO Auto-generated constructor stub
	}
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (Action each: actions) {
			if (each instanceof AttackAction) {
				actions.remove(each);
			}
		}
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new TalkAction(otherActor, this));
	}
}
