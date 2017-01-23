package hue03.Chees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheeseHole {
	public String pathName;
	public String fileName;
	int row = 7;
	int column = 19;
	int eyeCounter = 0;
	int biggestEye = 0;;
	char[][] cheese;

	int count = 0;

	CheeseHole(String _pathName, String _fileName) {
		pathName = _pathName;
		fileName = _fileName;
		cheese = new char[row][column];
	}

	public static void main(String[] args) {
		String pathName = "C:\\Users\\Elisabeth\\workspace\\AlgoritmusDatenstr\\bin\\hue03\\Chees";
		// String pathName ="C:
		// \Users\Elisabeth\workspace\AlgoritmusDatenstr\bin\hue03\Chees" ;
		String fileName = "cheese.txt";
		// String fileName = "cheese.txt";
		CheeseHole ct = new CheeseHole(pathName, fileName);

		try {
			ct.cheeseCreator();
		} catch (IOException e) {
			System.err.println("FILE NOT FOUND!!!!");

		}

		ct.printCheese();
		ct.findEye();
		ct.printCheese();

	}

	private void findEye() {

		for (int r = 0; r < cheese.length; r++) {
			for (int c = 0; c < cheese[r].length; c++) {
				if (cheese[r][c] == '*') {

					cheese[r][c] = '#';
					count++;
					eyeCounter++;

					findEyeMember(r, c);

				}

			}
		}
	}

	private boolean findEyeMember(int r, int c) {
		if (cheese[r + 1][c - 1] == '*') {
			cheese[r + 1][c - 1] = '+';
			r++;
			c--;
			count++;

		} else {
			if (cheese[r + 1][c] == '*') {
				cheese[r + 1][c] = '+';
				r++;
				count++;

			} else {
				if (cheese[r + 1][c + 1] == '*') {
					cheese[r + 1][c + 1] = '+';
					r++;
					c++;
					count++;

				} else {
					if (cheese[r][c + 1] == '*') {
						cheese[r][c + 1] = '+';
						c++;
						count++;

					} else {
						if (cheese[r - 1][c + 1] == '*') {
							cheese[r - 1][c + 1] = '+';
							r--;
							c++;
							count++;

						} else {
							if (cheese[r - 1][c] == '*') {
								cheese[r - 1][c] = '+';
								r--;
								count++;

							} else {

								if (cheese[r - 1][c - 1] == '*') {
									cheese[r - 1][c - 1] = '+';
									r--;
									c--;
									count++;

								} else {
									if (cheese[r][c - 1] == '*') {
										cheese[r][c - 1] = '+';
										c--;
										count++;
									}
								}
								if (biggestEye < count) {
									biggestEye = count;
								}
								count = 0;
								return false;
							}
						}
					}
				}
			}

		}
		return findEyeMember(r, c);
	}

	private void printCheese() {
		System.out.println(" Käse: ");
		System.out.println("-------------------");

		for (int r = 0; r < cheese.length; r++) {
			for (int c = 0; c < cheese[r].length; c++) {
				System.out.print(cheese[r][c]);
			}
			System.out.println("");
		}
		System.out.println("-------------------");
		System.out.println("");
		System.out.println("Anzahl der Löcher: " + eyeCounter);
		System.out.println("Umfang des größten Loches: " + biggestEye);

	}

	private void cheeseCreator() throws IOException {
		int ch = 0;

		FileReader fr = new FileReader(pathName + fileName);
		BufferedReader br = new BufferedReader(fr);

		for (int r = 0; r < cheese.length; r++) {
			for (int c = 0; c < cheese[r].length; c++) {

				ch = br.read();
				cheese[r][c] = (char) ch;

			}
		}
		br.close();
	}
}
