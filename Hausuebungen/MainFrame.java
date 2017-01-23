
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MainFrame extends Frame {

	private List<Rectangle> rects;
	
	private RectangleCanvas canvas;
	
	private Button addRectButton;
	private Button toggleRenderingButton;
	
	public MainFrame() {
		super();
		
		this.setTitle( "Rectangles" );
		this.setSize( 500 , 500 );
		this.addWindowListener( new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.canvas = new RectangleCanvas( true );
		
		this.addRectButton = new Button( "New Rectangle" );
		this.addRectButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Rectangle r = createRandomRect();
				rects.add( r );
				
				canvas.rectanglesChanged( rects );
			}
		});
		
		this.toggleRenderingButton = new Button( "Toggle Rendering");
		this.toggleRenderingButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.toggleFillMode();
			}
		});
		
		this.rects = new ArrayList<Rectangle>();
		
		setLayout( new BorderLayout() );
		add( this.addRectButton, BorderLayout.NORTH );
		add( this.toggleRenderingButton, BorderLayout.SOUTH );
		add( this.canvas, BorderLayout.CENTER );
	}
	
	private static Rectangle createRandomRect() {
		Rectangle rect = new Rectangle();
		rect.x = Math.random();
		rect.y = Math.random();
		rect.height = Math.min( Math.random(), 0.1 );
		rect.width = Math.min( Math.random(), 0.1 );
		rect.c = new Color( ( float ) Math.random(), ( float ) Math.random(), ( float ) Math.random() );

		return rect;
	}
	
	public static void main(String[] args ) {
		MainFrame mf = new MainFrame();
		mf.setVisible( true );
	}
}
