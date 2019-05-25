package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.demo.LockedDoor;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...+....#....#....",
				"....#####....##+###....",
				".......................",
				".....................0.",
				".......................",
				".......................",
				".......................",
				".......................");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new StunnedPlayer("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);
		
		Goons goons = new Goons("Goons", player);
		gameMap.addActor(goons, 6, 6);
		
		Q q = new Q("Q", player);
		gameMap.addActor(q, 10, 7);
		
		Ninja ninja = new Ninja("Ninja", player );
		gameMap.addActor(ninja, 15, 0);
		
		DoctorMaybe doctormaybe = new DoctorMaybe("Maybe Maybe", player);
		gameMap.addActor(doctormaybe, 5, 2);
		
		Key key = new Key("key 1", 'k');
		grunt.addItemToInventory(key);
		Key key2 = new Key("key 2", 'k');
		grunt2.addItemToInventory(key2);
		
		RocketPlans rocketplans = new RocketPlans("Plans", 'p');
		RocketBody rocketbody = new RocketBody("Body", 'b');
		RocketEngine rocketengine = new RocketEngine("Engine", 'e');
		gameMap.addItem(rocketplans, 14, 2);
		q.addItemToInventory(rocketbody);
		doctormaybe.addItemToInventory(rocketengine);
		
	
		
		world.run();
	}
}
