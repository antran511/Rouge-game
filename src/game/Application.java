package game;

import java.util.Arrays;
import java.util.List;
import edu.monash.fit2099.engine.*;


import edu.monash.fit2099.demo.Crater;
import edu.monash.fit2099.demo.DemoSkills;
import edu.monash.fit2099.demo.LockedDoor;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(),
				 new Crater(), new WaterPool());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				".W..#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		List<String> marsMap = Arrays.asList(
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo",
				"ooooooooooooooooooooooo");
		GameMap mars = new GameMap(groundFactory, marsMap);
        world.addMap(mars);
		
		Actor player = new StunnedPlayer("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		Actor yugomaxx = new Yugo(player);
		yugomaxx.addSkill(DemoSkills.SPACETRAVELLER);
		mars.addActor(yugomaxx, 10,10);
		
		Rocket rocket = new Rocket();
        rocket.getAllowableActions().add(new MoveActorAction(mars.at(7, 2), "to Mars!"));
		
        Rocket rocket2 = new Rocket();
        rocket2.getAllowableActions().add(new MoveActorAction(gameMap.at(1, 1), "to Earth!"));
        mars.addItem(rocket2, 7, 2);
      
        RocketPad rocketPad = new RocketPad();
		rocketPad.getAllowableActions().add(new AssembleRocket(rocketPad, rocket));
        gameMap.addItem(rocketPad, 1, 1);
        
        Item spaceSuit = new Item("space suit", '[');
        spaceSuit.addSkill(DemoSkills.SPACETRAVELLER);
        gameMap.addItem(spaceSuit, 5, 6);
        
        Item oxyContainer = Item.newFurniture("Tank", 'y');
        oxyContainer.getAllowableActions().add(new FillOxyLevel(oxyContainer));
        Item oxyDispenser = Item.newFurniture("Dispenser", '&');
        oxyDispenser.getAllowableActions().add(new CreateTank(oxyContainer));
        gameMap.addItem(oxyDispenser, 6, 5);
        
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		mars.addActor(grunt2,  10, 9);
		
		Goons goons = new Goons("Garlic", player);
		gameMap.addActor(goons, 6, 6);
		Goons goons2 = new Goons("Bumpy", player);
		mars.addActor(goons2, 6, 6);
		
		Q q = new Q("Q", player);
		gameMap.addActor(q, 10, 7);
		
		Ninja ninja = new Ninja("Naruto", player );
		gameMap.addActor(ninja, 15, 0);
		Ninja ninja2 = new Ninja("Sasuke", player );
		mars.addActor(ninja2, 15, 0);
		
		DoctorMaybe doctormaybe = new DoctorMaybe("Maybe Maybe", player);
		gameMap.addActor(doctormaybe, 5, 2);
		
		Key key = new Key("key 1", 'k');
		grunt.addItemToInventory(key);
		Key key2 = new Key("key 2", 'k');
		goons.addItemToInventory(key2);
		
		RocketPlans rocketplans = new RocketPlans("Plans", 'p');
		RocketBody rocketbody = new RocketBody("Body", 'b');
		RocketEngine rocketengine = new RocketEngine("Engine", 'e');
		
		gameMap.addItem(rocketplans, 14, 2);
		q.addItemToInventory(rocketbody);
		doctormaybe.addItemToInventory(rocketengine);
		
		WaterPistol waterpistol = new WaterPistol();
		mars.addItem(waterpistol, 2, 2);
		
		
		
		
		world.run();
	}
}
