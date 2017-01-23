package oo.ego8769.hue06.labirinth;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import oo.ego8769.hue04.bsp1.Gender;

public class Game implements Serializable {

	public static void main(String[] args) throws IOException {
		GameLevel gl = new GameLevel();

		IdGenerator generator = IdGenerator.getInstance();
		Field start = new Field(generator.getNextID(), "Start Field", null,
				"Welcome to the game! Let your adventure beginn!");
		Field f1 = new Field(generator.getNextID(), "Squaer", new Life(3),
				"Squar, and you have to choose the right direction.Straigth one ist not allways the shortest one.");
		Field f2 = new Field(generator.getNextID(), "Street", null, " The way to the Church. Go a head!");
		Field f3 = new Field(generator.getNextID(), "Corner", null, "The way to the Church. Go a head!");
		Field f4 = new Field(generator.getNextID(), "Small House", new Key("Key to the Exit Door"),
				"Now go and find Church, you will be abel to open the door.");
		Field f5 = new Field(generator.getNextID(), "This is a deadlock", new Milk(1), "description");
		Field f6 = new Field(generator.getNextID(), "Front of the Church door", new Apple(1),
				"Enter in to the Church, and you will finish this level.");

		Wall w = new Wall();
		Door d1 = new Door("Door in to a House", DoorStatus.open, f1, f2, "A small door, from a small Home.");
		Door exitDoor = new Door("exitDoor", DoorStatus.close, f6, "description");

		Player p1 = new Player("steve", Gender.male, new Life(3), start);
		Player p2 = new Player("ina", Gender.female, new Life(3), start);
		gl.addPlayer(p1);
		gl.addPlayer(p2);
		// Neighborhood n = new Neighborhood();
		// n.conect(f1, f2, Direction.east);
		// f1.set_neighbor(d1);

		start.set_neighbor(f1, Direction.south);
		start.set_neighbor(w, Direction.east);
		start.set_neighbor(w, Direction.west);
		start.set_neighbor(w, Direction.north);

		f1.set_neighbor(d1, Direction.south);
		f1.set_neighbor(f2, Direction.east);
		f1.set_neighbor(w, Direction.west);
		f1.set_neighbor(start, Direction.north);

		f2.set_neighbor(w, Direction.south);
		f2.set_neighbor(f3, Direction.east);
		f2.set_neighbor(f1, Direction.west);
		f2.set_neighbor(w, Direction.north);

		f3.set_neighbor(f6, Direction.south);
		f3.set_neighbor(w, Direction.east);
		f3.set_neighbor(f2, Direction.west);
		f3.set_neighbor(w, Direction.north);

		f4.set_neighbor(w, Direction.south);
		f4.set_neighbor(w, Direction.east);
		f4.set_neighbor(w, Direction.west);
		f4.set_neighbor(d1, Direction.north);

		f5.set_neighbor(w, Direction.south);
		f5.set_neighbor(f6, Direction.east);
		f5.set_neighbor(w, Direction.west);
		f5.set_neighbor(w, Direction.north);

		f6.set_neighbor(exitDoor, Direction.south);
		f6.set_neighbor(w, Direction.east);
		f6.set_neighbor(f5, Direction.west);
		f6.set_neighbor(f3, Direction.north);

		gl.addMapeSite(start);// TODO alle hinzufügen dann woe bei sem
		gl.addMapeSite(f1);// serializieren
		gl.addMapeSite(f2);
		gl.addMapeSite(f3);
		gl.addMapeSite(f4);
		gl.addMapeSite(f5);
		gl.addMapeSite(f6);
		gl.addMapeSite(w);
		gl.addMapeSite(d1);
		gl.addMapeSite(exitDoor);

		gl.addPlayer(p1);
		gl.addPlayer(p2);

		p1.move(Direction.north);
		p2.move(Direction.west);

		p1.move(Direction.south);
		p1.move(Direction.north);
		// TODO !!!hier!!! writer and read
		// irgenwie von

		File fileGameLevel = new File("fileGameLevel.txt");

		try {
			fileGameLevel.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ObjectOutputStream oos = null;

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileGameLevel);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);

			oos.writeObject(gl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ObjectInputStream ois = null;
		GameLevel chargedGameLevel = null;
		ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileGameLevel)));
		try {
			chargedGameLevel = (GameLevel) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		p1 = chargedGameLevel.getPlayers().get(0);
		p1.move(Direction.east);
		p1.move(Direction.east);
		p1.move(Direction.south);

	}
}
