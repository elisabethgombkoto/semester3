package oo.ego8769.hue09.Gui.AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.LinkedList;

/**
 * Created by ego8769
 */
public class PolynomFunctionInputPanel extends Panel {
	private GridBagConstraints _gbc;
	private LinkedList<PolynomFunction> _polynomFunctions = new LinkedList<>();
	private LinkedList<PolynomFunctionInputChangedListener> _listeners = new LinkedList<>();

	public PolynomFunctionInputPanel() {
		setLayout(new GridBagLayout());
		_gbc = new GridBagConstraints();
		_gbc.gridwidth = GridBagConstraints.REMAINDER;
		_gbc.fill = GridBagConstraints.HORIZONTAL;

		Button addButton = new Button("Add function");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addInputPanel();
			}
		});
		add(addButton, _gbc);

		addInputPanel();
	}

	private void addInputPanel() {
		PolynomFunction polynomFunction = new PolynomFunction(1, 1, 0);
		_polynomFunctions.add(polynomFunction);

		Panel panel = new Panel();
		panel.setLayout(new FlowLayout());

		Label label1 = new Label("f(x)=");
		panel.add(label1);

		TextField textField1 = new TextField("1");
		textField1.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				polynomFunction.setA(parseTextValue(textField1.getText()));
				firePolynomFunctionInputChangedEvent();
			}
		});
		panel.add(textField1);

		Label label2 = new Label("x^2 +");
		panel.add(label2);

		TextField textField2 = new TextField("1");
		textField2.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				polynomFunction.setB(parseTextValue(textField2.getText()));
				firePolynomFunctionInputChangedEvent();
			}
		});
		panel.add(textField2);

		Label label3 = new Label("x +");
		panel.add(label3);

		TextField textField3 = new TextField("0");
		textField3.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				polynomFunction.setC(parseTextValue(textField3.getText()));
				firePolynomFunctionInputChangedEvent();
			}
		});
		panel.add(textField3);

		Button removeButton = new Button("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(panel);
				_polynomFunctions.remove(polynomFunction);
				revalidate();
				firePolynomFunctionInputChangedEvent();
			}
		});
		panel.add(removeButton);

		add(panel, _gbc);
		revalidate();
		firePolynomFunctionInputChangedEvent();
	}

	private int parseTextValue(String textValue) {
		try {
			return Integer.parseInt(textValue);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	public LinkedList<PolynomFunction> getPolynomFunctions() {
		return _polynomFunctions;
	}

	public synchronized void addPolynomFunctionInputChangedListener(PolynomFunctionInputChangedListener listener) {
		_listeners.add(listener);
	}

	private synchronized void firePolynomFunctionInputChangedEvent() {
		PolynomFunctionInputChangedEvent event = new PolynomFunctionInputChangedEvent(this);
		for (PolynomFunctionInputChangedListener listener : _listeners) {
			listener.handle(event);
		}
	}
}
