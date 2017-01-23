package oo.ego8769.hue09.Gui.AWT;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.EventObject;

/**
 * Created by ego8769
 */
public class PolynomFunctionOutputPanel extends Panel {
	public PolynomFunctionOutputPanel(PolynomFunctionInputPanel inputPanel) {
		setLayout(new BorderLayout());
		PolynomFunctionOutputCanvas canvas = new PolynomFunctionOutputCanvas(inputPanel, 10, 1);
		add(canvas, BorderLayout.CENTER);

		Panel bottomPanel = new Panel();
		bottomPanel.setLayout(new FlowLayout());

		Label labelX = new Label("Scale X:");
		bottomPanel.add(labelX);

		TextField textFieldX = new TextField("10");
		textFieldX.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				canvas.setScaleX(parseTextValue(textFieldX.getText()));
			}
		});
		bottomPanel.add(textFieldX);

		Label labelY = new Label("Scale Y:");
		bottomPanel.add(labelY);

		TextField textFieldY = new TextField("1");
		textFieldY.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				canvas.setScaleY(parseTextValue(textFieldY.getText()));
			}
		});
		bottomPanel.add(textFieldY);

		add(bottomPanel, BorderLayout.SOUTH);
	}

	private int parseTextValue(String textValue) {
		try {
			return Integer.parseInt(textValue);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	private class PolynomFunctionOutputCanvas extends Canvas {
		private PolynomFunctionInputPanel _inputPanel;
		private int _scaleX;
		private int _scaleY;
		private Color[] _colors = new Color[] { Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE };

		public PolynomFunctionOutputCanvas(PolynomFunctionInputPanel inputPanel, int scaleX, int scaleY) {
			_inputPanel = inputPanel;
			_scaleX = scaleX;
			_scaleY = scaleY;

			_inputPanel.addPolynomFunctionInputChangedListener(new PolynomFunctionInputChangedListener() {
				@Override
				public void handle(EventObject e) {
					repaint();
				}
			});
		}

		public void setScaleX(int scaleX) {
			if (scaleX > 0) {
				_scaleX = scaleX;
				repaint();
			}
		}

		public void setScaleY(int scaleY) {
			if (scaleY > 0) {
				_scaleY = scaleY;
				repaint();
			}
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.BLACK);

			int startX = 10;
			int endX = getWidth() - 10;
			int zeroX = (endX - startX) / 2;

			int startY = getHeight() - 10;
			int endY = 10;
			int zeroY = startY - 100;

			// Draw coordinate system
			g.drawLine(startX, zeroY, endX, zeroY);
			g.drawLine(zeroX, startY, zeroX, endY);

			Font font = new Font("MyFont", 0, 10);
			g.setFont(font);

			for (int x = zeroX; x < endX; x += 30) {
				g.drawLine(x, zeroY - 2, x, zeroY + 2);
				int textValue = ((x - zeroX) / _scaleX);
				g.drawString("" + textValue, x + 2, zeroY + 10);
			}

			for (int x = zeroX; x > startX; x -= 30) {
				g.drawLine(x, zeroY - 2, x, zeroY + 2);
				int textValue = ((x - zeroX) / _scaleX);
				g.drawString("" + textValue, x + 2, zeroY + 10);
			}

			for (int y = zeroY; y > endY; y -= 30) {
				g.drawLine(zeroX - 2, y, zeroX + 2, y);
				int textValue = (zeroY - y) / _scaleY;
				if (textValue != 0) {
					g.drawString("" + textValue, zeroX - 20, y);
				}
			}

			for (int y = zeroY; y < startY; y += 30) {
				g.drawLine(zeroX - 2, y, zeroX + 2, y);
				int textValue = (zeroY - y) / _scaleY;
				if (textValue != 0) {
					g.drawString("" + textValue, zeroX - 20, y);
				}
			}

			// Draw functions
			for (PolynomFunction function : _inputPanel.getPolynomFunctions()) {
				setNextColor(g);
				int previousX = 0;
				int previousY = 0;
				for (int x = startX; x < endX; x += 1) {
					int y = function.getY(x - zeroX);
					double scaledY = y * ((double) _scaleY / (double) _scaleX);
					y = (zeroY - (int) scaledY);
					if (x != startX) {
						g.drawLine(previousX, previousY, x, y);
					}
					previousX = x;
					previousY = y;
				}
			}
		}

		private void setNextColor(Graphics g) {
			Color currentColor = g.getColor();
			int index = 0;
			for (int i = 0; i < _colors.length; i++) {
				if (_colors[i] == currentColor) {
					index = i + 1;
					break;
				}
			}
			g.setColor(index >= _colors.length ? _colors[0] : _colors[index]);
		}
	}
}
