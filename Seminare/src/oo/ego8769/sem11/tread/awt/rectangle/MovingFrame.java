package oo.ego8769.sem11.tread.awt.rectangle;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovingFrame extends Frame {
	private RectanglePanel _panelRect;

	public MovingFrame() {
		super("Moving Rectangle");
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
			}

		});
		setupFrame();
		setSize(800, 600);
	}

	void setupFrame() {
		setLayout(new BorderLayout());
		_panelRect = new RectanglePanel();
		add(_panelRect, BorderLayout.CENTER);
	}
}
