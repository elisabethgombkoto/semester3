package hue02.SortierAlgorithmen;

public class QuickSort implements Sort {

	@SuppressWarnings("rawtypes")
	@Override
	public Comparable[] sort(Comparable[] sortieren) {

		return quicksort(sortieren, 0, sortieren.length - 1);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Comparable[] quicksort(Comparable[] daten, int left, int right) {
		int anzahlFeldzugriff = 0;
		int anzahlSchleifen = 0;

		if (left < right) {
			int l = left;
			int r = right;
			Comparable pivot = daten[(l + r) / 2];
			anzahlFeldzugriff++;
			while (l <= r) {
				anzahlSchleifen++;
				while (daten[l].compareTo(pivot) < 0) {
					anzahlFeldzugriff++;
					anzahlSchleifen++;
					l++;
				}
				while (daten[r].compareTo(pivot) > 0) {
					anzahlFeldzugriff++;
					anzahlSchleifen++;

					r--;
				}
				if (l <= r) {
					Comparable temp = daten[l];
					daten[l] = daten[r];
					daten[r] = temp;
					l++;
					r--;
					anzahlFeldzugriff += 4;
				}
			}

			quicksort(daten, left, r);
			quicksort(daten, l, right);
		}
		System.out.println("Gesamtanzahl der Schleifendurchlaeufe bei QuickSort: " + anzahlSchleifen);
		System.out.println("Gesamtanzahl der Feldzugriffe bei QuickSort: " + anzahlFeldzugriff);
		return daten;
	}

}
