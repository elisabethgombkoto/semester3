package oo.ego8769.tutorium.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class RechtengelFrame extends Frame {
	private RechtangelPanel _panelRect;

	public RechtengelFrame() {
		super("RechtengleFrame");
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);// anonyme innerklasse
			}

		});
		setupFrame();
		setSize(800, 600);
	}

	private void setupFrame() {
		setLayout(new BorderLayout());
		_panelRect = new RechtangelPanel();
		RechtangelPanel panelRecht = new RechtangelPanel();
		Panel panelButtons = new Panel();
		Button btnAddRechengel = new Button("Add Rect");
		btnAddRechengel.addActionListener(new ActionListener() {

			private Object _panelRect;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Add REct Button pressed.");
				Random rand = new Random();
				RechtangelPanel.MyRectangle rect = _panelRect.new MyRectangel(rand.nextInt(100), rand.nextInt(100),
						rand.nextInt(100) + 1, rand.nextInt(100) + 1);
				_panelRect.addRectangle(rect);
			}
		});
		Button btnRemoveRechtengel = new Button("Remove Rect");
		btnRemoveRechtengel.addActionListener(l);
		panelButtons.add(btnRemoveRechtengel);

		add(panelButtons, BorderLayout.SOUTH);

	}
}
