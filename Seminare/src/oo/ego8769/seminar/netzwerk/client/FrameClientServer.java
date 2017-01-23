package oo.ego8769.seminar.netzwerk.client;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFileChooser;

import oo.ego8769.seminar.netzwerk.exeptions.CommandFailedExeption;
import oo.ego8769.seminar.netzwerk.exeptions.InvalideCommandSequenceExeption;
import oo.ego8769.seminar.netzwerk.exeptions.NotLoggedInException;
import oo.ego8769.seminar.netzwerk.exeptions.PutFailedException;
import oo.ego8769.seminar.netzwerk.server.FileContener;

public class FrameClientServer extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8124307153056035311L;
	ClientCommuniction _clientCommuniction;
	Client _client;

	public FrameClientServer(ClientCommuniction clientcommunication) {
		_clientCommuniction = clientcommunication;
		setTitle("Peer-to-peer");
		setSize(500, 400);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setLayout(new GridLayout(1, 2));
		ClientFilesPanel clientFilesPanel = new ClientFilesPanel(clientcommunication, this);
		SharedFilesPanel sharedFilesPanel = new SharedFilesPanel(clientcommunication);
		add(clientFilesPanel);
		add(sharedFilesPanel);
		setVisible(true);
	}

	class ClientFilesPanel extends Panel implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1341170170290917663L;

		private Frame _parent;
		private List _listClientFiles;

		public ClientFilesPanel(ClientCommuniction clientCommuniction, Frame parent) {
			setLayout(new GridLayout(3, 0));
			Panel buttonPanel = new Panel();

			buttonPanel.setLayout(new FlowLayout());
			Button putButton = new Button();
			putButton.setLabel("PUT");
			buttonPanel.add(putButton);
			// add(_listClientFiles);
			// TODO
			putButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser(".");
					if (fileChooser.showOpenDialog(_parent) == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						// System.out.println(file.getAbsolutePath());
						// send file
						Collection<String> fileConntent = new ArrayList<>();
						BufferedReader input;
						try {
							input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

							String line = null;
							while ((line = input.readLine()) != null) {
								fileConntent.add(line);
							}

							try {
								_clientCommuniction.put(new FileContener(file.getName(), fileConntent));
							} catch (InterruptedException | IOException | InvalideCommandSequenceExeption
									| NotLoggedInException | PutFailedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			});
			/*
			 * Button directoryButton = new Button();
			 * directoryButton.setLabel("Directory");
			 * buttonPanel.add(directoryButton);
			 * directoryButton.addActionListener(new ActionListener() {
			 * 
			 * @Override public void actionPerformed(ActionEvent e) {
			 * 
			 * } });
			 */
			add(buttonPanel);

			setVisible(true);

		}

	}

	class SharedFilesPanel extends Panel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3592156141228461313L;
		List _list;

		public SharedFilesPanel(ClientCommuniction _clientCommuniction) {
			setLayout(new GridLayout(3, 0));
			Panel buttonPanel = new Panel();
			_list = new List();
			buttonPanel.setLayout(new FlowLayout());
			Button dirButton = new Button("DIR");
			Button getButton = new Button("GET");
			buttonPanel.add(dirButton);
			buttonPanel.add(getButton);
			add(buttonPanel);
			add(_list);
			dirButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						ArrayList<String> arrayList = _clientCommuniction.dir();
						for (String current : arrayList) {
							_list.add(current);
						}

					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CommandFailedExeption e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvalideCommandSequenceExeption e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			getButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String filename = _list.getSelectedItem();
					try {
						FileContener fileContener = _clientCommuniction.get(filename);
						File file = new File(fileContener.getFilename());
						if (file.exists()) {
							file = new File(fileContener.getFilename() + "2");
						}
						file.createNewFile();
						BufferedWriter out;
						out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

						for (String courrent : fileContener.getFilecontents()) {
							out.write(courrent);
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvalideCommandSequenceExeption e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			setVisible(true);
		}

	}
}
