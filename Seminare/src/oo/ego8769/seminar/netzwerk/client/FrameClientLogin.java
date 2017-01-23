package oo.ego8769.seminar.netzwerk.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;

import oo.ego8769.seminar.netzwerk.exeptions.InvalideCommandSequenceExeption;

public class FrameClientLogin extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6288464538425024733L;
	Client _client;

	public FrameClientLogin(ClientCommuniction _clientCommuniction, Client client) {
_client=client;
		setTitle("Login Daten");
		setSize(300, 100);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		setLayout(new BorderLayout());
		LoginDatenPanel loginDatenPanel = new LoginDatenPanel(_clientCommuniction);
		add(loginDatenPanel, BorderLayout.CENTER);

		setVisible(true);

	}

	class LoginDatenPanel extends Panel implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2559724824505456918L;
		private TextField _username;
		private TextField _password;

		public LoginDatenPanel(ClientCommuniction clientCommuniction) {
			add(new Label("Username:"));
			_username = new TextField();
			add(_username);
			add(new Label("Password"));
			_password = new TextField();
			add(_password);
			Button loginButton = new Button();
			loginButton.setLabel("Login");
			add(loginButton);

			loginButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if (clientCommuniction.connent(_username.getText(), _password.getText())) {
							_client.nextFrame();
						}

					} catch (IOException e1) {

						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (InvalideCommandSequenceExeption e1) {
						e1.printStackTrace();
					}
				}

			});

		}
	}

	public void close() {
		setVisible(false);
	}

}
