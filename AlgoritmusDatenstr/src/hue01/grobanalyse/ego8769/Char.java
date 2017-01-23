package hue01.grobanalyse.ego8769;

public class Char {
	private String _str;
	private char _ch;

	public Char(String str, char ch) {
		_str = str;
		_ch = ch;

	}

	/*
	 * Lösungsidee: von links lositariren bis die erste char gefunden wird. n
	 * muss gross sein, und ich nehme an dass es nur 26 Character gibt
	 */
	public int findeCharLeft() {
		int pos = 0;

		for (pos = 0; pos < _str.length(); pos++) {
			if (_str.charAt(pos) == _ch) {
				return pos;
			}
		}
		return -1;
	}

	/*
	 * Analyse: best case: O(1) trifft auf erste mal zu worst case: O(n) trifft
	 * zu letzt zu avarage case:25-26*(25/26)n
	 * 
	 * weil wir nur 26 Char vorkommen kann, bei genug grossen n haben alle char
	 * die selbe wahrscheinlichkeit
	 */

	/*
	 * Lösungsidee: // nicht von rechts anfangen // sondern man sollte die
	 * letzte Platz von links ermitteln diese sollte als return Wert dargestellt
	 * werden
	 */
	public int findeCharRight() {
		int remember = -1;
		int pos = 0;
		while (pos < _str.length()) {
			if (_str.charAt(pos) == _ch) {
				remember = pos;
				pos++;
			} else
				pos++;
		}
		return remember;

	}
	/*
	 * Analyse: best case: O(n) worst case: O(n) avarage case: O(n) man muss
	 * immer durch ittarieren
	 */
	// Random Aufgabestellung
	// zufalls Zahl kann öffters vorkommen
	// Mathemathise analyse des Problems
	// annahme der gesuchte Buchstabe kommt in den Array vor

	public int findCharRandom() {
		int posNummber = this.createRandomNummber();

		while (_str.charAt(posNummber) != _ch) {
			posNummber = this.createRandomNummber();
			System.out.println(posNummber);

		}
		return posNummber;

	}

	public int createRandomNummber() {
		int nummber = (int) Math.floor(Math.random() * _str.length());
		System.out.println(nummber);

		return nummber;

	}
	/*
	 * Analyse: best case: O(1) worst case: O(n) avarage case: ist ebenso wie
	 * bei der ertse.) es trifft in diese intervallum jede zahl mit dem selben
	 * wahrscheinlichkeit, und die vorkommende Char haben
	 * 
	 */
}
