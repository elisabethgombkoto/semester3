package oo.ego8769.hue09.bsp01.Gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FramePolynom extends Frame {
	public FramePolynom() {

		setTitle("Polynom darstellung"); // Fenstertitel setzen
		setSize(900, 800); // Fenstergröße einstellen

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // EventListener für das x

		setLayout(new BorderLayout());
		KoordinatePanel koordinatenPanel = new KoordinatePanel();
		add(koordinatenPanel, BorderLayout.CENTER);

		PolynomParameterEingabePanel eingabePanel = new PolynomParameterEingabePanel(koordinatenPanel);
		add(eingabePanel, BorderLayout.NORTH);

		// pack();
		setVisible(true);
	}

	class TestWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose();
			System.exit(0);
		}
	}

	class TestActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Schaltfläche wurde gedrückt");
		}
	}

	public static void main(String[] args) {
		FramePolynom framePloynom = new FramePolynom();
		framePloynom.setVisible(true);
	}
}
