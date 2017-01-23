package oo.ego8769.hue09.jplot;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import oo.ego8769.hue09.Expr.Expr;

/**
 * Ein kleiner Graph Component. Tut nicht viel. Ausser Polwechselstellen zu
 * erkennen.<br>
 * Die Berechnung der Funktionswerte wird von <code>Expr<code> durchfuerht.
 * 
 * @see Expr
 */

class Plotter extends Canvas {

	private String function;

	/**
	 * Legen die Grenzen des Koordinatensystems fest.
	 */
	private double minx, maxx;
	private double miny, maxy;

	/*
	 * siehe updateAspects
	 */
	int canvaswidth;
	int canvasheight;
	double canvasstepX;
	double canvasstepY;

	boolean showedAsserts = false; // debug /analiser

	/**
	 * Legt eine neue Instanze an.
	 * 
	 * @see Component#add(Component)
	 *
	 * @param function
	 *            Function
	 * @minx Minimale x-werte der Darstellung
	 * @maxx Maximale x-werte der Darstellung
	 * @miny Minimale y-werte der Darstellung
	 * @maxy Maximale y-werte der Darstellung
	 */
	Plotter(String function, double minx, double maxx, double miny, double maxy) {

		showedAsserts = false;

		this.function = function;

		setInputRange(minx, maxx);
		setOutputRange(miny, maxy);
		updateAspects();
	}

	/**
	 * Legt X Bereich fest Getrennte Funktionen fuer X und Y werte da
	 * verschieden Aspecten (Bereich und Skalierung) der Beiden moeglich.
	 */
	public void setInputRange(double minx, double maxx) {
		this.minx = minx;
		this.maxx = maxx;
		updateAspects();
	}

	/**
	 * Legt Y Bereicht fest Getrennte Funktionen fuer X und Y werte da
	 * verschieden Aspecten (Bereich und Skalierung) der Beiden moeglich.
	 */
	public void setOutputRange(double miny, double maxy) {
		this.miny = miny;
		this.maxy = maxy;
		updateAspects();
	}

	/**
	 * Fenstergrosse Abhaengigkeiten aktualisieren<br>
	 * Man sollte eigentlich <code>ComponentListener</code> benutzen...
	 */
	private void updateAspects() {

		/*
		 * Canvas Koordinaten
		 */
		canvaswidth = getSize().width;
		canvasheight = getSize().height;
		canvasstepX = (maxx - minx) / canvaswidth;
		/*
		 * x-aspect = y-aspect wenn miny == maxy
		 */
		canvasstepY = (miny == maxy) ? canvasstepX : (maxy - miny) / canvasheight;

	}

	/**
	 * Bildschirm x nach Funktions x Getrennte Funktionen fuer X und Y werte da
	 * verschieden Aspecten (Bereich und Skalierung) der Beiden moeglich.
	 */
	private double DisplayToLogicalX(int x) {
		return minx + (x * canvasstepX);
	}

	/**
	 * Funktions x nach Bildschirm x Getrennte Funktionen fuer X und Y werte da
	 * verschieden Aspecten (Bereich und Skalierung) der Beiden moeglich.
	 */
	private int LogicalToDisplayX(double x) {
		return (int) ((x / canvasstepX) + (-minx) / canvasstepX);

	}

	/**
	 * Bildschirm y nach Funktions y Getrennte Funktionen fuer X und Y werte da
	 * verschieden Aspecten (Bereich und Skalierung) der Beiden moeglich.
	 */
	private double DisplayToLogicalY(int y) {
		/*
		 * - min allows schifting y-achse..
		 */
		return ((miny != maxy) ? maxy : (canvasheight / 2 * canvasstepY - miny)) - (y * canvasstepY);
	}

	/**
	 * Funktions y nach Bildschirm y Getrennte Funktionen fuer X und Y werte da
	 * verschieden Aspecten (Bereich und Skalierung) der Beiden moeglich.
	 */

	private int LogicalToDisplayY(double y) {
		return (int) ((((miny != maxy) ? maxy : (canvasheight / 2 * canvasstepY - miny)) - y) / canvasstepY);
	}

	/**
	 * Mehr kontrolle...
	 */
	@Override
	public void update(Graphics g) {
		updateAspects();
		paintBackground(g);
		paint(g);
	}

	/**
	 * Zeichnet Hintergrund. Faerben und Achsen zeichnen.
	 */
	public void paintBackground(Graphics g) {

		/*
		 * Hintergrund loeschen..
		 */
		g.setColor(getBackground());
		g.fillRect(0, 0, canvaswidth, canvasheight);

		g.setColor(Color.red);

		g.drawString(function, 5, 12);

		int gridStep = ((canvaswidth / (maxx - minx)) < 20) ? 5 : 1;
		g.setColor(Color.lightGray);
		// x-grid
		for (double x = 0; x <= maxx; x += gridStep) {
			int snx = LogicalToDisplayX(x);
			g.drawLine(snx, 0, snx, canvasheight);
		}

		for (double x = 0; x >= minx; x -= gridStep) {
			int snx = LogicalToDisplayX(x);
			g.drawLine(snx, 0, snx, canvasheight);
		}

		// y-grid
		for (double y = 0; y <= maxy; y += gridStep) {
			int sny = LogicalToDisplayY(y);
			g.drawLine(0, sny, canvaswidth, sny);
		}
		for (double y = 0; y >= miny; y -= gridStep) {
			int sny = LogicalToDisplayY(y);
			g.drawLine(0, sny, canvaswidth, sny);
		}

		// x-achse
		g.setColor(Color.black);
		if ((miny <= 0 && 0 <= maxy) || (miny == maxy)) {
			int x = LogicalToDisplayX(maxx) - 5;
			int y = LogicalToDisplayY(0);
			// Pfeil!
			g.drawLine(LogicalToDisplayX(minx), y, x, y);
			g.drawLine(x - 5, y + 5, x, y);
			g.drawLine(x - 5, y - 5, x, y);
			g.drawString("x", x - 10, y - 2);
		}

		// y-achse
		if (minx <= 0 && 0 <= maxx) {
			int x = LogicalToDisplayX(0);
			int y = 5 /* (for miny==maxy) + LogicalToDisplayY(maxy) */ ;
			// Pfeil!
			g.drawLine(x, y, x,
					canvasheight /* (for miny==maxy) LogicalToDisplayY(miny) */ );
			g.drawLine(x - 5, y + 5, x, y);
			g.drawLine(x + 5, y + 5, x, y);
			g.drawString("y", x + 3, y + 15);
		}

		g.setColor(Color.green);
		g.drawString("0,0", LogicalToDisplayX(0), LogicalToDisplayY(0) - 5);
		g.drawString(gridStep + ",0", LogicalToDisplayX(gridStep), LogicalToDisplayY(0) - 5);
		// g.drawString(-gridStep + ",0", LogicalToDisplayX(-gridStep),
		// LogicalToDisplayY(0) + 5);

		g.setColor(Color.blue);

	}

	/**
	 * Waehrend der Darstellung wird die Funktions werte berechnen.<br>
	 * Es wird eigenlich schneller wenn man die Werte bei der Aanderung der
	 * Componentengroesse vorberechnent aber ist auch schnell genug...
	 */
	@Override
	public void paint(Graphics g) {

		Expr expr = new Expr();

		updateAspects();
		paintBackground(g);

		int i;

		/*
		 * Wenn der letzer punkt nicht mit bildbereich war wird keine Linei
		 * gezeichnet
		 */
		boolean offscreen = true, lastoffscreen;

		/*
		 * Zeichn punkte
		 */
		int nx, ny = 0; // fuer verbindung zum naechste punkt
		int lx = 0, ly = 0;

		double x_next = 0, y_next = 0;
		double x = 0, y = 0;
		double x_last = 0, y_last = 0;
		double x_lastlast, y_lastlast;

		/*
		 * Da es heirbei um reele funktionen geht, koennen wir nicht zu keiner
		 * interval nehmen. wir nehmen deshalb der kleinste interval die mit
		 * einem Pixel darstellbar ist..
		 */

		for (nx = 0; nx < canvaswidth; lx = nx, ly = ny, nx++) {

			lastoffscreen = offscreen;
			offscreen = true; // until proven wrong

			// fuer polstellen
			x_lastlast = x_last;
			y_lastlast = y_last;

			x_last = x;
			y_last = y;

			// vorberechnete werte
			y = y_next;
			x = x_next;

			// im voraus berechnen
			x_next = DisplayToLogicalX(nx);
			expr.setVariable("x", x_next);
			y_next = expr.evalExpr(function);

			ny = LogicalToDisplayY(y);

			if (nx == 0)
				continue;

			if (nx == 1)
				ly = ny;

			if (Double.isInfinite(y)) {
				/* Unendlich... zeichnen (NullDivision z.B) */
				g.setColor(Color.red);
				g.drawLine(nx, 0, nx, canvasheight);
			} else if (y != y) {

				/* NaN */
				g.setColor(Color.orange);
				g.drawLine(nx, LogicalToDisplayY(0), nx, LogicalToDisplayY(0));
				g.setColor(Color.blue);

			} else {

				/*
				 * map pixel values ny,ly, lly to y-value and cmp
				 */
				if (polChanged(y_lastlast, y_last, y, y_next)) {

					// Kennung Linie fuer Polstellen..
					// Weil MT es so wollte
					g.setColor(Color.cyan);
					g.drawLine(nx, 0, nx, canvasheight);

				} else {

					/*
					 * int stelle koennte interessant sein... Eskommen oft
					 * undefinierte stellen an ints vor da Anwender Ganzezahlen
					 * mag ;-)
					 */
					int sx = (int) Math.round(x); // supect x
					expr.setVariable("x", sx);
					double sy = expr.evalExpr(function);
					if (Double.isInfinite(sy)) {
						// Aha! Ein roter strich...
						int snx = LogicalToDisplayX(sx);
						g.setColor(Color.red);
						g.drawLine(snx, 0, snx, canvasheight);
					}

					/*
					 * Bug: Java AWT gibt fuer f := e^x koemischen senkrechte
					 * linien... bei offscreen punkte...
					 */

					// MT zeigte fuer f := 1/(x*x) koemisches
					// verhalten in der naehe von x = 0
					// Behandlen: Nicht so weit ausserhalb canvas zeichnen
					// sonst kommt AWT durcheinander

					if (ny < 0)
						ny = -1;
					else if (ny > canvasheight)
						ny = canvasheight + 1;
					else {
						offscreen = false;
					}

					if (!(lastoffscreen && offscreen)) {
						g.setColor(Color.blue);
						g.drawLine(nx, ny, lx, ly);
					}

				}
			}

		} /* for */

	}

	/*
	 * y, letzer y, vorletzter y
	 * 
	 * @param lyy vorletzter Wert
	 * 
	 * @param ly letzter Wert
	 * 
	 * @param y aktueller Wert
	 * 
	 * @param naechster wert
	 * 
	 * @return true Wenn Vorzeichenwechsel aber gliecher orientation danach
	 */
	private boolean polChanged(double lly, double ly, double y, double ny) {

		if (y > 0) {
			return (ly < 0 && lly > ly && ny < y);
		} else {
			return (ly > 0 && lly < ly && ny > y);
		}

	}

}
