package game;

import edu.monash.fit2099.engine.*;
/**
 * Class representing the Player which is able to be stunned by Ninja
 */
public class StunnedPlayer extends Player {
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
	
	private int stunTurn = 0;
	public void setStunTurn(int turn) {
		if(this.stunTurn<=0) {
			this.stunTurn = turn;
		}
	}
	/**
	 * Display a menu to the user and have them select an option.
	 * When the player is stuned, only "do nothing" option is available
	 * @param actions the Actions that the user can choose from
	 * @param display the I/O object that will display the map
	 * @return the Action selected by the user
	 */

	protected Action showMenu(Actions actions,Display display) {
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
}
