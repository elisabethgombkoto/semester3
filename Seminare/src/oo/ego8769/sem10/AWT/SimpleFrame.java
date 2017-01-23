package oo.ego8769.sem10.AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SimpleFrame extends Frame {
	protected Button plus;
	protected Button minus;

	public SimpleFrame() {
		setTitle("SimpleFrame");

		setLayout(new BorderLayout());
		add(new Label("Angel"), BorderLayout.NORTH);
		Panel buttonPanel = new Panel();
		add(buttonPanel, BorderLayout.EAST);

		plus = new Button("+");
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				/*
				 * RechtAngel rect=_rechtangelPanel.new Rechtangle(
				 * rend.nextInt(RectanglePanel.SIZE/2)+1,
				 * rend.nextInt(RectanglePanel.SIZE/2)+1,
				 * rend.nextInt(RectanglePanel.SIZE/2)+1,
				 * rend.nextInt(RectanglePanel.SIZE/2)+1); _rechtangelPanel
				 */
			}
		});
		minus = new Button("-");
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

	}
	// buttonPanel.add(plus);

	private void setLayout(FlowLayout flowLayout) {
		// TODO Auto-generated method stub

	}

}
