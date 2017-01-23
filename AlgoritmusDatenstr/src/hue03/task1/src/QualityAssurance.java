package hue03.task1.src;

import java.util.ArrayList;
import java.util.List;

public class QualityAssurance {
	public void check(char[][] field) throws HoleException {
		char spCh = '*';
		int holeCount = 0;
		boolean holeAvailable = false;
		List<Hole> holeList = new ArrayList<>();
		Hole temp;

		// rows
		for (int i = 0; i < field.length; i++) {
			holeAvailable = false;

			// column
			for (int n = 0; n < field[i].length; n++) {
				if (field[i][n] == spCh) {
					if (!holeAvailable) {
						holeList.add(new Hole(i, n));
						holeAvailable = true;
					} else {
						for (int j = 0; j < holeList.size(); j++) {
							temp = holeList.get(j);

							// if(temp.getLeft() + temp.getWidth())
						}
					}
				} else {
					holeAvailable = false;
				}
			}
		}
	}
}
