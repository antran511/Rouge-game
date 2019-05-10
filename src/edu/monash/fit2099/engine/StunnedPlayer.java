package edu.monash.fit2099.engine;

public class StunnedPlayer extends Player{
	public StunnedPlayer(String name, char displayChar, int priority, int hitPoints) {
		super(name, displayChar, priority, hitPoints);
	}
	public Action playTurn(Actions actions, GameMap map, Display display) {
		return new SkipTurnAction();

	}
}
