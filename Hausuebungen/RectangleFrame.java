import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class RectangleFrame extends Frame {

	private RectanglePanel _panelRect;

	public RectangleFrame() {
		super("RectangleFrame");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setupFrame();
		setSize(800, 600);
	}
	
	void setupFrame() {
		setLayout(new BorderLayout());
		
		_panelRect = new RectanglePanel();
		add(_panelRect, BorderLayout.CENTER);
		
		Panel panelButtons = new Panel();
		Button btnAddRectangle = new Button("Add Rect");
		btnAddRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RectanglePanel.MyRectangle rect = 
						_panelRect.new MyRectangle (
							    (int) (Math.random() * 1000), 
								(int) (Math.random() * 1000), 
								(int) (Math.min( Math.random() * 1000, 1 )), 
								(int) (Math.min( Math.random() * 1000, 1 )));
				_panelRect.addRectangle(rect);
			}
		});
		panelButtons.add(btnAddRectangle);
		Button btnRemoveRectangle = new Button("Remove Rect");
		btnRemoveRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_panelRect.removeFirstRectangle();
			}
		});
		panelButtons.add(btnRemoveRectangle);
		add(panelButtons, BorderLayout.SOUTH);
	}
}
