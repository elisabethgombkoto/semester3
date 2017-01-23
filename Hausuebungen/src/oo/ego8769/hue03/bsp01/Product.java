/**ego8769
 * 
 */
package oo.ego8769.hue03.bsp01;

import oo.ego8769.hue01.bsp02.Point;;

/**
 * @author Elisabeth
 *
 */
public class Product {

	private int _weight;
	private String _name;
	private int _volume;
	private Point _point;

	public Product(int volume, String name, int weight, Point point) {
		
		_volume = volume;
		_name = name;
		_weight = weight;
		_point = point;
	}

	public int getVolume(){
		return _volume;
	}

	public String getName() {
		return _name;
	}

	public int getWeight() {
		return _weight;
	}
	
	//TODO JULIA fragen warum funktioniert getPoint nicht
	public Point getPoint(){
		return _point;
	}

}
