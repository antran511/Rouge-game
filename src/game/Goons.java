package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Goons extends Actor{
	
	/**
	 * Constructor.
	 *
	 * @param name Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param priority How early in the turn the player can act
	 * @param hitPoints Player's starting number of hitpoints
	 */
	// Grunts have 50 hitpoints and are always represented with a G
	public Goons(String name, Actor player) {
		super(name, 'G', 4, 25);
		addBehaviour(new FollowBehaviour(player));
	}

	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	/**
	 * Play a turn. Doing this means displaying a menu to the user and getting their selected option.
	 *
	 * Ignores more than 26 options. We could do better. We could also roll out a
	 * dedicated menu class instead of having it here. Player is 90% menu.
	 *
	 * @param actions the actions to display
	 * @param map the map to display
	 * @param display the object that performs the console I/O
	 * @return an insult
	 */
	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		int max = 10; 
		int min = 1;
		Random random = new Random();
        int randNum = random.nextInt(max)%(max-min+1) + min;
        if(randNum == 1) {
        	display.println("Give me your blood");
        }
		
        return super.playTurn(actions,  map,  display);
	}

}
