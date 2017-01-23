package oo.ego8769.hue08.bsp3.Zip;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InvalidePhadeExeption, InvalideZipParameterException {
		System.out.println(args.length);
		for (String current : args) {
			System.out.println(current);
		}

		ZipUtil zipUtil = null;
		File archive = null;
		File entpackt = null;

		if (args.length == 5 && args[0].equals("-f")) {

			if (args[1].equals("zip")) {
				File file = new File("oo");

				zipUtil = new ZipUtil();
				archive = new File(args[4] + ".zip");
				try {
					zipUtil.zip(file, archive, args[3]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (args[1].equals("gzip")) {
				// GzipUtil.enGzipArcive(archive, entpackt);// TODO gzip machen
			} else {
				throw new InvalideZipParameterException("Parameter do not exist");
			}
		} else if (args.length == 4) {
			entpackt = new File("entpackt");

			try {
				zipUtil.enZip(archive, entpackt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else
			throw new InvalidePhadeExeption("Phade do not exist");

		//
		// TODO warum wird die root directory auch
		// mit gezipt??? wenn
		// C:\Users\Elisabeth\workspace\Hausuebungen\oo
		// eingegeben wird
		// System.out.println(file.getAbsolutePath());

		// TODO Auto-generated method stub
		// file mit file phade erzeugen :
		// f=C:\Users\Elisabeth\workspace\Hausuebungen\oo
		// aufrufen mit f.zip()
		// es erscheint ein zip packet auf der linke seite
		//
		// entzip versuchen zu implementieren
		//
		//
		// gzip sollte einfacher sein, ein versuch ist es wert

	}

}
