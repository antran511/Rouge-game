package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Actor{
	
	public Ninja(String name, Actor player) {
		super(name, 'n', 3, 50);
		addBehaviour(new ThrowBagBehaviour(player));
		addBehaviour(new MoveAwayBehaviour(player));
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (Action each: actions) {
			if (each instanceof MoveActorAction) {
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
}
