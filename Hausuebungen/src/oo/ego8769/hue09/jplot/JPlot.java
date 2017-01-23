package oo.ego8769.hue09.jplot;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import oo.ego8769.hue09.Expr.Expr;

/**
 * Ein kleiner Container fuer Plotter Man gibt "min, max" ein, und drück auf
 * "plot". Sehe Expr fuer Syntax der Funktionen
 *
 * @see Plotter
 * @see Expr.Expr
 */

public class JPlot extends Frame {

	public TextField textFunction = new TextField();
	public TextField textMin = new TextField();
	public TextField textMax = new TextField();

	public TextField textMinY = new TextField();
	public TextField textMaxY = new TextField();

	Button buttonPlot = new Button("Plot");

	public boolean isControl = false;

	static String appTitle = "GraphPlotter";

	MenuBar m_MenuBar;
	Menu m_GraphPlotterMenu;
	MenuItem m_PreferencesMenuItem;

	JPlot() {

		Panel p = new Panel();
		p.setLayout(new GridLayout(0, 1));
		Panel pp = new Panel();

		m_MenuBar = new MenuBar();
		m_GraphPlotterMenu = new Menu("Start");
		// m_GraphPlotterMenu = new Menu("About");

		setMenuBar(m_MenuBar);
		m_MenuBar.add(m_GraphPlotterMenu);

		pp.setLayout(new BorderLayout());
		pp.add("Center", textFunction);
		pp.add("East", buttonPlot);

		p.add("North", pp);

		pp = new Panel();
		// pp.setLayout(BorderLayout);
		pp.setLayout(new GridLayout());
		pp.add(new Label("X-Bereich"));
		pp.add(textMin);
		pp.add(textMax);
		pp.add(new Label("Y-Bereich"));
		pp.add(textMinY);
		pp.add(textMaxY);

		p.add("South", pp);

		add("South", p);

	}

	public static void main(String args[]) {

		String demof = "sin(x*3) + cos(e + x) + 1/(x - 2)";
		double mn = -10, mx = 12;
		double mny = -10, mxy = 10;

		JPlot mainFrame = new JPlot();

		mainFrame.setTitle(appTitle);

		mainFrame.textFunction.setText(demof);
		mainFrame.textMin.setText(String.valueOf(mn));
		mainFrame.textMax.setText(String.valueOf(mx));
		mainFrame.textMinY.setText(String.valueOf(mny));
		mainFrame.textMaxY.setText(String.valueOf(mxy));

		mainFrame.setBounds(400, 400, 700, 600);
		Plotter pt = new Plotter(demof, mn, mx, mny, mxy);
		pt.setBackground(Color.yellow);
		mainFrame.add("Center", pt);

		mainFrame.setVisible(true);

	}

	/**
	 * Prueft of function : f(x) OK durch probe mit 1 und gibt alle meldungen
	 * aus...
	 */
	public boolean invalidFunction(String function) {

		String err = "";
		String s;
		double x = 0, y;
		Expr expr = new Expr();
		expr.setVariable("x", x);
		y = expr.evalExpr(function);
		while ((s = expr.getError()) != null) {
			System.err.println(s);
			err += s + "\n";
		}

		if (err.length() == 0)
			return false;

		/*
		 * Dirty erros to Dialog
		 */
		Dialog d = new Dialog(this, "Funktions Fehler", false);
		d.add(new TextArea("Expresion Parser Reported Following Errors\nf(x) -> " + function + "\n\n" + err));
		d.pack();
		// center
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		d.move((screen.width - size().width) / 2, (screen.height - size().height) / 2);

		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
		d.show();

		return true;
	}

	/*
	 * Neuese Fenster leicht versetzt.
	 */
	private void newPlotter(String f, double mn, double mx, double mny, double mxy) {

		if (f == null)
			return;

		if (invalidFunction(f)) {
			return;
		}

		JPlot pi = new JPlot();
		Plotter cp = new Plotter(f, mn, mx, mny, mxy);

		pi.setTitle("GraphPlotter: " + f);
		pi.textFunction.setText(f);
		pi.textMin.setText(String.valueOf(mn));
		pi.textMax.setText(String.valueOf(mx));
		pi.textMinY.setText(String.valueOf(mny));
		pi.textMaxY.setText(String.valueOf(mxy));

		pi.add("Center", cp);
		Rectangle r = getBounds();
		Insets i = getInsets();
		pi.setBounds(r.x + i.left, r.y + i.top, r.width, r.height);
		pi.setVisible(true);
	}

	@Override
	public boolean handleEvent(Event e) {
		if (e.id == e.WINDOW_DESTROY) {
			dispose();
			Frame f = (Frame) e.target;
			if (f.getTitle().equals(appTitle)) {
				System.exit(0);
			}
			return true;
		} else if (e.id == e.ACTION_EVENT) {
			if (e.target == buttonPlot || e.target == textFunction) {
				double mn, mx, mny, mxy;
				String s = textFunction.getText();

				if (s == null || s.length() == 0) {

					System.err.println("keine Funktion eingegeben!");
					return true;
				}

				mn = Double.valueOf(textMin.getText()).doubleValue();
				mx = Double.valueOf(textMax.getText()).doubleValue();
				mny = Double.valueOf(textMinY.getText()).doubleValue();
				mxy = Double.valueOf(textMaxY.getText()).doubleValue();

				newPlotter(s, mn, mx, mny, mxy);
				return true;
			}
		}
		return super.handleEvent(e);
	}

}