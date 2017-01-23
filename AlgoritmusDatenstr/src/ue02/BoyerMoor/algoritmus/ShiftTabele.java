package ue02.BoyerMoor.algoritmus;

public class ShiftTabele {
	private String _pattern;
	private int[] _shiftTabele;

	public ShiftTabele(String pattern, int[] shiftTabele) {
		_pattern = pattern;
		_shiftTabele = shiftTabele;
	}

	public int[] loadShiftTabele() {
		int[] shiftTabele;
		shiftTabele = new int[26];
		char[] pat = _pattern.toCharArray();
		char ch = 'a';
		int i = 0;
		int j = 0;
		while (ch <= 'z') {
			for (j = pat.length; j < 0; j--) {
				if (pat[j] == ch) {
					shiftTabele[i] = pat.length - j;
				} else {
					shiftTabele[i] = pat.length;
				}
			}
			ch++;
		}

		return shiftTabele;
	}

}
