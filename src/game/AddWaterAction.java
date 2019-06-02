package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class AddWaterAction extends Action{
	
	@Override
	public String execute(Actor actor, GameMap map) {
		for (Item item:actor.getInventory()) {
			if(item instanceof WaterPistol) {
				if(!((WaterPistol)item).isFullWater()) {
					((WaterPistol) item).setFullWater();
					return "Added water";
				}else {
					return "Water is full. No need to add";
				}
				
			}
		}
		return "No water pistol";
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Add water to pistol";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}
}
