package oo.ego8769.hue09.bsp01.Gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomParameterEingabePanel extends Panel {
	TextField _aTextfield;
	TextField _bTextfield;
	TextField _cTextfield;

	public PolynomParameterEingabePanel(KoordinatePanel koordinatePanel) {

		setLayout(new FlowLayout());
		add(new Label("f(x)="));
		_aTextfield = new TextField();
		add(_aTextfield);
		add(new Label("x^2+"));
		_bTextfield = new TextField();
		add(_bTextfield);
		add(new Label("x+"));
		_cTextfield = new TextField();
		add(_cTextfield);
		Button plot = new Button();
		plot.setLabel("Plot");

		plot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				koordinatePanel.addPolygon(new Polygone(readValues()));

			}
		});
		add(plot);

	}

	private int[] readValues() {
		int aWert = Integer.parseInt(_aTextfield.getText());
		int bWert = Integer.parseInt(_bTextfield.getText());
		int cWert = Integer.parseInt(_cTextfield.getText());
		return new int[] { aWert, bWert, cWert };
	}
}
