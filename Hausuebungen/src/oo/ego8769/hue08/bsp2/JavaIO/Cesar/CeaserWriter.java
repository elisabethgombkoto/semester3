package oo.ego8769.hue08.bsp2.JavaIO.Cesar;

import java.io.IOException;
import java.io.Writer;

public class CeaserWriter extends Writer {
	private Writer _predecessor;

	public CeaserWriter(Writer predecessor) {
		_predecessor = predecessor;
	}

	@Override
	public void close() throws IOException {

		_predecessor.close();

	}

	@Override
	public void flush() throws IOException {

		_predecessor.flush();
	}

	@Override
	public void write(char[] buffer, int offset, int lenght) throws IOException {
		// offset ist die position im buffer
		// buffer ist ein char array
		// lenght ist die anzahldie Charakter die noch nicht verschlüsselt/
		// verarbeitet sind

		// ceasarDecoding(); verschlüsselalgorithmuss bekommt mein buffer
		// und verarbeitet gibt es zurück
		// funktion aufruf

		for (int i = offset; i < offset + lenght; i++) {
			char c = buffer[i];
			char z = cesarDecode(c);
			buffer[i] = z;

		}
		_predecessor.write(buffer, offset, lenght);
	}

	private char cesarDecode(char c) {
		int shift = 4;
		return (encode(c, 26 - shift));
	}

	//
	// _predecessor.write(Character.toUpperCase(cbuf))
	private char encode(char c, int shift) {
		if (c >= 'A' && c <= 'Z') {
			return (char) ((c - 'A' + shift) % 26 + 'A');
		} else if (c >= 'a' && c <= 'z') {
			return (char) ((c - 'a' + shift) % 26 + 'a');
		} else
			return c;

	}

}
