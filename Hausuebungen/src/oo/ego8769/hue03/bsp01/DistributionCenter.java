/**ego8769
 * 
 */
package oo.ego8769.hue03.bsp01;

import java.util.ArrayList;

/**
 * @author Elisabeth
 *
 */
public class DistributionCenter {
	private int _minX;
	private int _minY;
	private int _maxX;
	private int _maxY;
	private ArrayList<Trolly>_trollys;
	private ArrayList<Product>_godsStored;
	
	
	
	public DistributionCenter(int minX, int minY, int maxX, int maxY){
		//rechte seite von = ist was von ausenkommt, was zugewiesen wird
		_minX= minX;
		_minY=minY;
		_maxX=maxX;
		_maxY=maxY;
		_trollys= new ArrayList<Trolly>();
		
	}
	public boolean isLegal(int x, int y) {
		if((_minX<= x && x<=_maxX)&&(_minY<=y && y<=_maxY)){
			return true;
		}
		return false;
		
	}
	
	public void MoveToCargoArea(){//TODO Implementieren
		
	}
	public void MoveToUnLoadingArea(){ //TODO Implemnetieren
		
		
		
	}

}
