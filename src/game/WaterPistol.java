package game;

import edu.monash.fit2099.engine.Item;

public class WaterPistol extends Item{
	// A specialized weapon to attack Yugo
	private boolean fullWater=false;
	public WaterPistol() {
		super("Water Pistol", 'w');
		// TODO Auto-generated constructor stub
	}
	
	public boolean isFullWater() {
		/***
		 * A function to check if water in the Pistol is full or not
		 * Return boolean value
		 */
		return fullWater;
	}
	public void setFullWater() {
		/***
		 * Set the Water in the pistol to full. The pistol can be used
		 * only when it is full
		 */
		if(fullWater) {
			fullWater=false;
		}
		fullWater=true;
	}

}
