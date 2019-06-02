package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class DestroyExoskeltonAction extends Action{
	private Random rand;
	private Actor actor;
	private Actor subject;
	private boolean exoskeleton;
	/**
	 * Constructor of a special attack action to Yugo
	 * @param actor: player who attacked Yugo
	 * @param subject: Yugo itself
	 * @param exoskeleton: boolean value representatioin of exolkeleton
	 */
	public DestroyExoskeltonAction(Actor actor, Yugo subject, boolean exoskeleton) {
		this.actor = actor;
		this.subject = subject;
		this.exoskeleton = exoskeleton;
	}
	/**
	 * Execute method of DestroyExoskeltonAction
	 * PLayer has 70% chance of destroy the armor
	 * 
	 * @param actor: player who attacked Yugo
	 * @param map: the curren gameMap, mars paritculaly
	 */
	
	@Override
	public String execute(Actor actor, GameMap map) {
		for (Item item : actor.getInventory()) {
			if(item instanceof WaterPistol) {
				if(((WaterPistol) item).isFullWater()) {
					((WaterPistol) item).setFullWater();
					if(rand.nextInt(100)<70) {//70%
						exoskeleton = false;
						return "destroy exoskeleton";
					}else {
						return "miss the exoskeleton";
							}
					}else{
						return "need water";
						
					}
				}
			}
			return "need water pistol";
		}
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Shoot water to yugo";
	}
	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
		}
}