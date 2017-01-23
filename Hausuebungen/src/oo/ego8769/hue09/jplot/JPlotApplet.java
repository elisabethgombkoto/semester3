package oo.ego8769.hue09.jplot;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class JPlotApplet extends Applet implements ActionListener {
	public void init() {
		Button b =  new Button("JPlot Starten!");
		setLayout(new GridLayout(0,1));
		add(b);
		b.addActionListener(this);
	}

	public void paint(Graphics g) {

		g.setFont(new Font("Helvetica", 0, 16));
		g.setColor(Color.blue);
		g.drawString("zu cool um hier drin zu sitzen", 10, 20);
	}

	public void actionPerformed(ActionEvent e) {

		JPlot.main(new String[0]);
	}

}