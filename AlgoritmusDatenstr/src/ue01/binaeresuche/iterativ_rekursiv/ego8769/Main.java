package ue01.binaeresuche.iterativ_rekursiv.ego8769;

public class Main {
	/*
	 * Laufzeitanalyse: Zählen der Anzahl der Vergleiche
	 * 
	 * • Best-Case: sofortiger Treffer: T(n) = 1, also T(n) = O(1) • Worst-Case:
	 * Suchbereich muss solange halbiert werden, bis er nur noch 1 Element
	 * enthält, • also im schlechtesten Fall logarithmisch oft : T(n) = T(n/2)
	 * <= -1 = log(n + 1), T(n) = ˆ(log n)
	 */

	/*
	 * Binäre suche wird empfohlen wenn, Statische, nicht oder sehr selten
	 * ändernde, kleine Datenmenge,mit häufige Zugriffe/Suchoperationen darauf
	 * Lösung: Vorsortiertes O(n log n) Feld, binäres Suchen O(log n)
	 */

	public int binaereSucheIterativ(int searchNummber, int[] array)
			throws NummberNotFoundExceptions, ArrayIsEmptyException {

		int pos = 0;
		int length = array.length;
		if ((length == 0) || (array == null)) {
			throw new ArrayIsEmptyException();
		}
		while (searchNummber != array[pos]) {
			if (searchNummber < array[pos]) {
				pos = pos - (pos / 2);
			} else {
				pos = pos + (pos / 2);
			}
		}
		if (searchNummber == array[pos])
			return pos;
		else
			throw new NummberNotFoundExceptions();
	}

	/*
	 * Rekursive Algorithmen:  zu jedem rekursiv formulierten Algorithmus gibt
	 * es einen äquivalenten iterativen Algorithmus Vorteile rekursiver
	 * Algorithmen kürzere Formulierung leichter verständliche Lösung Einsparung
	 * von Variablen teilweise sehr effiziente Problemlösungen (z.B. Quicksort)
	 * Bei rekursiven Datenstrukturen (zum Beispiel Bäume, Graphen) besonders
	 * empfehlenswert Nachteile rekursiver Algorithmen weniger effizientes
	 * Laufzeitverhalten (Overhead bei Funktionsaufruf) Verständnisprobleme bei
	 * Programmieranfängern Konstruktion rekursiver Algorithmen
	 * "gewöhnungsbedürftig"
	 */
	public boolean binaereSucheRekursive(int searchNummber, int[] array, int lowerBound, int upperBound)
			throws ArrayIsEmptyException {
		int middle = 0;

		if ((array.length == 0) || (array == null)) {
			throw new ArrayIsEmptyException();
		}

		while (upperBound >= lowerBound) {
			middle = (lowerBound + upperBound) / 2;
			if (array[middle] == searchNummber) {
				return true;
			} else if (array[middle] > searchNummber)
				return binaereSucheRekursive(searchNummber, array, lowerBound, middle - 1);
			return binaereSucheRekursive(searchNummber, array, middle + 1, upperBound);
		}
		return false;
	}

}
