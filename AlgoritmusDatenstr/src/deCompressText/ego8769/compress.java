package deCompressText.ego8769;

public class compress {
	/*
	 * String name = "admin"; // String to check it's value int nameLenght =
	 * name.length(); // length of the string used for the loop
	 * 
	 * for(int i = 0; i < nameLenght ; i++){ // while counting characters if
	 * less than the length add one char character = name.charAt(i); // start on
	 * the first character int ascii = (int) character; //convert the first
	 * character System.out.println(character+" = "+ ascii); // print the
	 * character and it's value in ascii }
	 */
	private String _text;

	public compress(String text) {
		_text = text;
	}

	public String compressText() {
		String compressText = null;

		for (int i = 0; i < _text.length(); i++) {// nem ott folytatja az
													// olvasász ahol a másik
													// befejezte az átváltást
													// mert stringbuffer a
													// returnwert
			// hogyan adom vissza a megemelt i countert?!
			int ascii = _text.charAt(i);
			if ((48 < ascii) && (ascii < 57)) {
				this.compressNummber(i);
			} else {
				this.compressLetter(i);

			}
		}

		return compressText;
	}

	private StringBuilder compressLetter(int i) {
		char choriginal = _text.charAt(i);
		int counter = 3;
		StringBuilder sb = new StringBuilder("");

		if ((_text.charAt(i) == _text.charAt(i + 1)) && (_text.charAt(i + 2) == _text.charAt(i))) {
			int k = i + 2;
			while (_text.charAt(k) == _text.charAt(k + 1)) {
				counter++;
			}
			return sb.append(choriginal).append(counter);
		} else
			return sb.append(choriginal);
	}

	private String compressNummber(int i) {
		return _text;

	}
}
