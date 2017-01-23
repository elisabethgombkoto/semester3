/*
 * Alle Dateien in ./Expr  und Compileren mit:
 *
 * javac -d . Expr/Token.java
 * javac -d . Expr/Expr.java
 * javac -d . Expr/JExpr.java
 *
 */

package oo.ego8769.hue09.Expr;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JExpr extends Applet implements WindowListener, KeyListener, ActionListener {

	boolean isApplet = true;
	TextArea ta = new TextArea("#>");
	Expr expr = new Expr();
	Checkbox stream = new Checkbox("Stream Modus");

	@Override
	public void init() {

		Panel p = new Panel();
		Button b;

		expr.setVariable("x", 0);

		setLayout(new BorderLayout());

		add("Center", ta);
		ta.setFont(new Font("Monospaced", 0, 12));

		p.add(stream);

		b = new Button("Clear");
		p.add(b);
		b.addActionListener(this);
		b = new Button("Reset");
		p.add(b);
		b.addActionListener(this);

		add("North", p);

		ta.addKeyListener(this);

	}

	String do_cmd(String s) {

		String ret = "";
		if (stream.getState()) {
			if (s.length() == 0) {
				ret = ret + "    .= " + expr.getValue() + "\n";
			} else {
				expr.evalToken(s);
				if (expr.canPeek())
					ret = ret + "    .= " + expr.peekValue() + "\n";
			}
		} else if (s.length() > 0) {
			ret = ret + "    := " + expr.evalExpr(s) + "\n";
		}

		while (expr.peekError() != null) {
			ret = ret + "    err: " + expr.getError() + "\n";
		}
		return ret;
	}

	public static void main(String args[]) {
		Frame f = new Frame();
		JExpr a = new JExpr();
		a.init();
		f.addWindowListener(a);
		f.add(a);
		f.setBounds(200, 200, 400, 300);
		f.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if (c instanceof Button) {
			Button b = (Button) c;
			String l = b.getLabel();
			if (l.charAt(0) == 'C') {
				ta.setText("#>");
				ta.setCaretPosition(2);
				ta.requestFocus();
			} else if (l.charAt(0) == 'R') {
				expr = new Expr();
				ta.setText("#>");
				ta.setCaretPosition(2);
				ta.requestFocus();
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		ta.setCaretPosition(ta.getText().length());
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

		char c = e.getKeyChar();
		String t = ta.getText();
		int ia, iz;

		iz = ta.getCaretPosition();

		if (c == '\t') {
			e.consume();
			stream.requestFocus();
			return;
		}

		// get current line
		for (ia = iz - 1; ia > 0; ia--) {
			if (t.charAt(ia) == '\n') {
				ia++;
				break;
			}
		}
		if (ia >= 0 && iz > 0) {
			t = t.substring(ia, iz);
		}

		// Ony edit own lines after prompt
		if (c != e.CHAR_UNDEFINED) {
			if (t.startsWith("#>") && (iz >= ia + 3 || (iz >= ia + 2 && c != '\b'))) {
				t = t.substring(2).trim();
			} else {
				if (c == '\n' || c == '\r') {
					int i;
					String s = ta.getText();
					int len = s.length();
					for (i = iz; i < len; i++) {
						if (Character.isSpace(s.charAt(i))) {
							while (i < len && Character.isSpace(s.charAt(i)))
								i++;
							break;
						}
					}

					if (!s.regionMatches(i, "#>\n", 0, 2) || s.regionMatches(i, "#>\r", 0, 2)) {
						ta.insert("#>\n", i);
					}
					iz = i + 2;
					ta.setCaretPosition(iz);

				}
				e.consume();
				return;
			}
		}

		if (c == '\n' || c == '\r') {
			e.consume();
			String s = do_cmd(t);
			s = "\n" + s + (s.endsWith("\n") ? "" : "\n") + "#>";
			ta.insert(s, iz);

		}

	}

}
