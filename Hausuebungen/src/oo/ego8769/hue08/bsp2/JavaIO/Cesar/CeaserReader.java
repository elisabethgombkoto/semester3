package oo.ego8769.hue08.bsp2.JavaIO.Cesar;

import java.io.IOException;
import java.io.Reader;

public class CeaserReader extends Reader {
	private Reader _predecessor;

	public CeaserReader(Reader predecessor) {
		_predecessor = predecessor;
	}

	@Override
	public void close() throws IOException {
		_predecessor.close();
	}

	@Override
	public int read(char[] buffer, int offset, int length) throws IOException {
		// buffer wohin die char geschrieben werden sollen
		// offset wohin es geschrieben wird im buffer
		// length wie viele noch geschrieben werden sollen, ergo was fält noch
		// bis alles raus ist
		int charCount = _predecessor.read(buffer, offset, length);
		for (int i = offset; i < offset + length; i++) {
			char c = buffer[i];
			char encodetChar = ceaserEncode(c);
			buffer[i] = encodetChar;
		}

		return charCount;
	}

	private char ceaserEncode(char c) {
		int shift = 4;
		return encode(c, shift);
	}

	private char encode(char c, int shift) {
		if (c >= 'A' && c <= 'Z') {
			return (char) ((c - 'A' + shift) % 26 + 'A');
		} else if (c >= 'a' && c <= 'z') {
			return (char) ((c - 'a' + shift) % 26 + 'a');
		} else
			return c;

	}
}
