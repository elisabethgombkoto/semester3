package oo.ego8769.hue06.labirinth;

import static org.junit.Assert.assertEquals;

import oo.ego8769.hue04.bsp1.Gender;

public class Test {

	// @org.junit.Test
	// public void testWallEnter() {
	// IdGenerator id = IdGenerator.getGenerator();
	// Field f0 = new Field(id, "start", new Apple(1), "Welcome to the game! Let
	// your adventure beginn!");
	// Wall w1 = new Wall();
	// Player p = new Player("p", Gender.female, new Life(3), f0);
	// w1.enter(p, Direction.east);
	// int c = p.get_lifeCounter().get_values();
	//
	// int exepted = 2;
	// assertEquals(true, c == exepted);
	//
	// }
	//
	// @org.junit.Test
	// public void testKeep() {
	// IdGenerator id = IdGenerator.getGenerator();
	// Item l = new Life(1);
	// Field f1 = new Field(id, "Feld", l, "beschreibung");
	// Player p = new Player("p", Gender.male, new Life(3), f1);
	// l.keep(p);
	// int c = p.get_lifeCounter().get_values();
	// int exepted = 4;
	// assertEquals(exepted, c);
	//
	// }
	//
	// @org.junit.Test
	// public void TestEnterField() {
	// Field start = new Field(IdGenerator.getGenerator(), "start", null,
	// "Welcome to the game! Let your adventure beginn!");
	// Field f1 = new Field(IdGenerator.getGenerator(), "f1", new Life(3),
	// "hfjf");
	// Wall w = new Wall();
	// Player p1 = new Player("steve", Gender.male, new Life(3), start);
	//
	// start.set_neighbor(f1, Direction.south);
	// start.set_neighbor(w, Direction.east);
	// start.set_neighbor(w, Direction.west);
	// start.set_neighbor(w, Direction.north);
	//
	// f1.set_neighbor(w, Direction.south);
	// f1.set_neighbor(w, Direction.east);
	// f1.set_neighbor(w, Direction.west);
	// f1.set_neighbor(start, Direction.north);
	//
	// f1.enter(p1, Direction.south);
	// Field exepted = p1.get_position();
	// assertEquals(f1, exepted);
	// }
	//
	// @org.junit.Test
	// public void TestEnterDoor() {
	// Field start = new Field(IdGenerator.getGenerator(), "start", null,
	// "Welcome to the game! Let your adventure beginn!");
	// Field f1 = new Field(IdGenerator.getGenerator(), "f1", new Life(3),
	// "hfjf");
	// Door d1 = new Door("d1", DoorStatus.open, f1, start, "hgdtedjez");
	// Wall w = new Wall();
	//
	// Player p1 = new Player("steve", Gender.male, new Life(3), start);
	//
	// start.set_neighbor(d1, Direction.south);
	// start.set_neighbor(w, Direction.east);
	// start.set_neighbor(w, Direction.west);
	// start.set_neighbor(w, Direction.north);
	//
	// f1.set_neighbor(w, Direction.south);
	// f1.set_neighbor(w, Direction.east);
	// f1.set_neighbor(w, Direction.west);
	// f1.set_neighbor(d1, Direction.north);
	//
	// d1.enter(p1, Direction.south);
	// Field a = p1.get_position();
	// assertEquals(a, f1);
	// }
	//
	// @org.junit.Test
	// public void TestMoveFromFieldToFiel() {
	// Field start = new Field(IdGenerator.getGenerator(), "start", null,
	// "Welcome to the game! Let your adventure beginn!");
	// Field f1 = new Field(IdGenerator.getGenerator(), "f1", new Life(3),
	// "hfjf");
	// Wall w = new Wall();
	// Player p1 = new Player("steve", Gender.male, new Life(3), start);
	//
	// start.set_neighbor(f1, Direction.south);
	// start.set_neighbor(w, Direction.east);
	// start.set_neighbor(w, Direction.west);
	// start.set_neighbor(w, Direction.north);
	//
	// f1.set_neighbor(w, Direction.south);
	// f1.set_neighbor(w, Direction.east);
	// f1.set_neighbor(w, Direction.west);
	// f1.set_neighbor(start, Direction.north);
	//
	// p1.move(Direction.south);
	// assertEquals(p1.get_position(), f1);
	// }

	// @org.junit.Test
	// public void TestMoveFromFieldThroughDoorToFiel() {
	// Field start = new Field(IdGenerator.getGenerator(), "start", null,
	// "Welcome to the game! Let your adventure beginn!");
	// Field f1 = new Field(IdGenerator.getGenerator(), "f1", new Life(3),
	// "hfjf");
	// Door d1 = new Door("d1", DoorStatus.open, f1, start, "hgdtedjez");
	// Wall w = new Wall();
	// Player p1 = new Player("steve", Gender.male, new Life(3), start);
	//
	// start.set_neighbor(d1, Direction.south);
	// start.set_neighbor(w, Direction.east);
	// start.set_neighbor(w, Direction.west);
	// start.set_neighbor(w, Direction.north);
	//
	// f1.set_neighbor(w, Direction.south);
	// f1.set_neighbor(w, Direction.east);
	// f1.set_neighbor(w, Direction.west);
	// f1.set_neighbor(d1, Direction.north);
	//
	// p1.move(Direction.south);
	// assertEquals(p1.get_position(), f1);
	// }
	//
	// @org.junit.Test
	// public void TestMoveFromFieldAgainstWall() {
	// Field start = new Field(IdGenerator.getGenerator(), "start", null,
	// "Welcome to the game! Let your adventure beginn!");
	// Field f1 = new Field(IdGenerator.getGenerator(), "f1", new Life(3),
	// "hfjf");
	// Door d1 = new Door("d1", DoorStatus.open, f1, start, "hgdtedjez");
	// Wall w = new Wall();
	// Player p1 = new Player("steve", Gender.male, new Life(3), start);
	//
	// start.set_neighbor(d1, Direction.south);
	// start.set_neighbor(w, Direction.east);
	// start.set_neighbor(w, Direction.west);
	// start.set_neighbor(w, Direction.north);
	//
	// f1.set_neighbor(w, Direction.south);
	// f1.set_neighbor(w, Direction.east);
	// f1.set_neighbor(w, Direction.west);
	// f1.set_neighbor(d1, Direction.north);
	//
	// p1.move(Direction.east);
	// assertEquals(2, p1.get_lifeCounter().get_values());
	// }

	@org.junit.Test
	public void TestgetNextField() {
		GameLevel gl = new GameLevel();

		IdGenerator generator = IdGenerator.getInstance();
		Field start = new Field(generator.getNextID(), "start", null,
				"Welcome to the game! Let your adventure beginn!");
		Field f1 = new Field(generator.getNextID(), "f1", new Life(3), "hfjf");
		Door d1 = new Door("d1", DoorStatus.open, start, f1, "hgdtedjez");
		Player p1 = new Player("steve", Gender.male, new Life(3), start);
		Player p2 = new Player("ina", Gender.male, new Life(3), f1);

		Field a = d1.getNextField(p1);
		assertEquals(f1, a);

	}
}
