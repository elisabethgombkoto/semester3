package hue01.CompressText.ego8769;

public class CoDeCompress {
	public CoDeCompress() {
	}

	public String compress(String str) throws InvalidStringException {
		if (checkValidityCompress(str)) {

			StringBuilder sb = new StringBuilder();
			int[] count = new int[2];

			for (int i = 0; i < str.length(); i++) {

				count = getNrOfOccurences(str, i);

				if (count[1] > 2) {
					sb.append(str.charAt(i));
					sb.append(count[1]);
				}
				if (count[1] == 2) {
					sb.append(str.charAt(i));
					sb.append(str.charAt(i));
				}
				if (count[1] == 1) {
					sb.append(str.charAt(i));
				}
				i = count[0];
			}
			return sb.toString();
		}
		throw new InvalidStringException();
	}

	/**
	 * @param result[0]
	 *            = last position of the letter (helps the FOR loop to jump over
	 *            to the next valid char)
	 * @param result[1]
	 *            = how many times the letter appears
	 */
	private int[] getNrOfOccurences(String str, int pos) {
		int start = pos;
		int end = -1;
		int i = pos;
		int[] result = new int[2];
		while (str.charAt(pos) == str.charAt(i) && i < str.length() - 1) {
			i++;
			end = i;
		}
		if (str.charAt(end) == str.charAt(pos)) {
			end++;
		}
		result[0] = end - 1;
		result[1] = end - start;
		return result;
	}

	/**
	 * @param number[0]
	 *            = value of number (integer)
	 * @param number[1]
	 *            = length of number (integer)
	 */
	public String decompress(String str) throws InvalidStringException {
		if (checkValidityDecompress(str)) {
			int[] number = new int[2];
			StringBuilder sb = new StringBuilder();
			char temp = str.charAt(0);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 49 && str.charAt(i) <= 57) { // from 49=1
																	// to 57=9
					number = getNumber(str, i);
					if (number[0] > 2) {
						for (int j = 0; j < number[0] - 1; j++) {
							sb.append(temp);
						}
					}
					if (number[0] == 2) {
						sb.append(temp);
					}
				} else {
					temp = str.charAt(i);
					sb.append(temp);
				}
			}
			return sb.toString();
		}
		throw new InvalidStringException();
	}

	/**
	 * @param result[0]
	 *            = value of number (integer)
	 * @param result[1]
	 *            = length of number (integer)
	 */
	private int[] getNumber(String str, int index) {
		int[] result = new int[2];
		int count = 0;
		int i = index;
		while (str.charAt(i) >= 48 && str.charAt(i) <= 57 && i < str.length()) {
			count++;
			i++;
			if (i == str.length())
				break;
		}
		String s = str.substring(index, index + count);
		result[0] = Integer.parseInt(s);
		result[1] = count;
		return result;
	}

	private boolean checkValidityDecompress(String str) {
		if ((str.charAt(0) >= 48 && str.charAt(0) <= 57))
			return false;
		return true;
	}

	private boolean checkValidityCompress(String str) {
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 48 && str.charAt(i) <= 57)) // from 0 to 9
				return false;
		}
		return true;
	}
}
