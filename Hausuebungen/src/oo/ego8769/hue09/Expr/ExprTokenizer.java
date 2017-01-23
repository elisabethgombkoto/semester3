/*
 * Alle Dateien in ./Expr  und Compileren mit:
 *
 * javac -d . Expr/Token.java
 * javac -d . Expr/Expr.java
 * javac -d . Expr/JExpr.java
 *
 */

package oo.ego8769.hue09.Expr;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * StringTokenizer Wrapper mit Initialisierung
 * 
 * @see java.io.StreamTokenizer
 */
class ExprTokenizer extends StreamTokenizer {

	ExprTokenizer(String expr) {
		super(new StringReader(expr));
		init();
	}

	private void init() {

		commentChar('#');
		ordinaryChar('+');
		ordinaryChar('-');
		ordinaryChar('*');
		ordinaryChar('^'); // exponent
		ordinaryChar('/'); // division
		ordinaryChar(':'); // ersatz division
		ordinaryChar('%'); // modulo
		ordinaryChar(';'); // anweisung trenner
		ordinaryChar('=');
		whitespaceChars(0, ' ');
		wordChars('a', 'z');
		parseNumbers();

	}

	/*
	 * ordinaryChars int String umwandlen
	 */
	@Override
	public int nextToken() throws IOException {

		int tok = super.nextToken();

		if (tok > 0) {
			ttype = TT_WORD; // common proc
			sval = new Character((char) tok).toString();
		}
		return ttype;
	}

}
