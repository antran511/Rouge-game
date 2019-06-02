package game;

import edu.monash.fit2099.demo.WindowSmashAction;
import edu.monash.fit2099.engine.*;

public class OpenedDoor extends Ground{
	
	public OpenedDoor() {
		super('O');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return true;
	}

	
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}
	
}
