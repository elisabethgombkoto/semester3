package oo.ego8769.hue09.Gui.AWT;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ego8769
 */
public class GraphPlotter extends Frame {
	public GraphPlotter() {
		setTitle("Graph Plotter");
		setSize(500, 500);
		setLayout(new BorderLayout());

		PolynomFunctionInputPanel inputPanel = new PolynomFunctionInputPanel();
		add(inputPanel, BorderLayout.NORTH);

		PolynomFunctionOutputPanel outputPanel = new PolynomFunctionOutputPanel(inputPanel);
		add(outputPanel, BorderLayout.CENTER);

		// Closable
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		GraphPlotter graphPlotter = new GraphPlotter();
		graphPlotter.setVisible(true);
	}

}
