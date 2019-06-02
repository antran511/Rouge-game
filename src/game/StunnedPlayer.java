package game;

import edu.monash.fit2099.engine.*;

import java.util.Map;

import edu.monash.fit2099.demo.*;
/**
 * Class representing the Player which is able to be stunned by Ninja
 */
public class StunnedPlayer extends Player {
	private GameMap earthMap;
	/**
	 * Constructor.
	 *
	 * @param name Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param priority How early in the turn the player can act
	 * @param hitPoints Player's starting number of hitpoints
	 */

	public StunnedPlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	private boolean isWin = false;
	private int oxyLevel = 0;
	private int stunTurn = 0;
	public void setStunTurn(int turn) {
		if(this.stunTurn<=0) {
			this.stunTurn = turn;
		}
	}
	/****
	 *This method return the oxy level left of player 
	 *It is called when the player is on Mars
	 * @return oxyLevel
	 */
	public int getOxyLevel() {
		// TODO Auto-generated method stub
		return this.oxyLevel;
	}

	/**
	 * Display a menu to the user and have them select an option.
	 * When the player is stuned, only "do nothing" option is available
	 * @param actions the Actions that the user can choose from
	 * @param display the I/O object that will display the map
	 * @return the Action selected by the user
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		// Remember the earthMap before going to Mars
		if (map.groundAt(map.locationOf(this)) instanceof Floor) {
			for (Item item: map.locationOf(this).getItems()) {
				if (item instanceof Rocket) {
					this.earthMap = map;
				}
			}
		}
		// When oxyLevel is 0, Player can only have an option to return to Earth
		if (map.groundAt(map.locationOf(this)) instanceof Crater) {
			this.oxyLevel -= 1;
			if (this.oxyLevel == 0) {
				actions = new Actions(new MoveActorAction(this.earthMap.at(1,1), "back to Earth because run out of oxygen"));
			}
		}
		// Game over when Player is defeated
		if (!this.isConscious()) {
			System.out.print("Game over");
			System.exit(0);
		}
		// Player wins when player bring back Yugo to the Earth
		for(Item item: getInventory()) {
			if(item.toString().equals("Sleeping Yugo Maxx")) {
				if (map.groundAt(map.locationOf(this)) instanceof Floor) {
					System.out.print("Win");
					System.exit(0);
				}	
			}
		}
		return showMenu(actions, display);
	}
	
	@Override
	protected Action showMenu(Actions actions,Display display) {
		
		actions.add(new EndAction());
		if(stunTurn>0) {
			System.out.println("You stuned for "+ stunTurn+" turn(s)");
			stunTurn-=1;
			actions=new Actions(new SkipTurnAction());
			return super.showMenu(actions, display);
		}
		else {
			return super.showMenu(actions, display);
		}
		
	}
	public void addOxyLevel(int i) {
		// TODO Auto-generated method stub
		this.oxyLevel += 10;
	}
}

