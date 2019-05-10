package game;
import edu.monash.fit2099.demo.WindowSmashAction;
import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


public class DoctorMaybe extends Actor {

	public DoctorMaybe(String name, Actor player) {
		super(name, 'd', 6, 25);
		// TODO Auto-generated constructor stub
	}
	
	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();
	
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (Action each: actions) {
			if (each instanceof MoveActorAction) {
				actions.remove(each);
			}
			if (each instanceof DropItemAction) {
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
