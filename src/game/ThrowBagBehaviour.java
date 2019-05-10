package game;

import game.ActionFactory;

import java.util.Random;

import javax.security.auth.Subject;

import edu.monash.fit2099.engine.*;

public class ThrowBagBehaviour implements ActionFactory{

	private Actor target;
	private int stuntimes;
	private Random rand = new Random();

	public ThrowBagBehaviour(Actor subject) {
		this.target = subject;
	}
	

	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);
		
		if (stuntimes > 0) {
		
			stuntimes = stuntimes -1 ;
			return null;
			
		}
		
		
		int currentDistance = distance(here, there);
		if (currentDistance <= 5) {
			if(rand.nextBoolean()) {
				Range xs, ys;
				if (here.x() == there.x() || here.y() == there.y()) {
					xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
					ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

					for (int x : xs) {
						for (int y : ys) {
							if(map.at(x, y).getGround().blocksThrownObjects())
								return null;

						}
					}
				}
				if (target instanceof StunnedPlayer) {
					System.out.println(actor+" throw to "+target);
					((StunnedPlayer) target).setStunTurn(2);
					stuntimes = 2;
				} 
			return null;
			}
		}
		return null;
	}

	// Manhattan distance.
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}


	}
	


