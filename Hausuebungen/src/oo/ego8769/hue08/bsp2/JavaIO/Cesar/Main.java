package oo.ego8769.hue08.bsp2.JavaIO.Cesar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		CeaserWriter ceaserWriter = null;

		File decodedFile = new File("decodedFile.txt");
		try {
			ceaserWriter = new CeaserWriter(new FileWriter(decodedFile));
			ceaserWriter.write("diese ist mein test string");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ceaserWriter.flush();
				ceaserWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Read form file");

		FileReader fileReader = null;

		try {
			fileReader = new FileReader(decodedFile);
			int ch = 0;
			while (ch != -1) {
				ch = fileReader.read();
				System.out.print((char) ch);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();

		CeaserReader ceaserReader = null;

		try {
			ceaserReader = new CeaserReader(new FileReader(decodedFile));
			int ch = 0;
			while (ch != -1) {
				ch = ceaserReader.read();
				System.out.print((char) ch);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ceaserReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
